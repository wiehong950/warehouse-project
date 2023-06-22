package id.co.indivara.jdt12.warehouseproject.service;

import id.co.indivara.jdt12.warehouseproject.entity.WarehouseInventory;
import id.co.indivara.jdt12.warehouseproject.entity.WarehouseToWarehouse;
import id.co.indivara.jdt12.warehouseproject.entity.master.Good;
import id.co.indivara.jdt12.warehouseproject.entity.master.Warehouse;
import id.co.indivara.jdt12.warehouseproject.repository.WarehouseInventoryRepository;
import id.co.indivara.jdt12.warehouseproject.repository.WarehouseToWarehouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class WarehouseToWarehouseService {
    @Autowired
    private WarehouseToWarehouseRepository warehouseToWarehouseRepository;

    @Autowired
    private WarehouseInventoryRepository warehouseInventoryRepository;

    public ResponseEntity<WarehouseToWarehouse> warehouseToWarehouseResponseEntity(
            Good goodId,
            Warehouse warehouseIdSrc,
            Warehouse warehouseIdDst,
            WarehouseToWarehouse warehouseToWarehouse
    ){
        WarehouseInventory warehouseInventorySrc = warehouseInventoryRepository.findByIdGoodAndIdWarehouse(goodId, warehouseIdSrc);
        WarehouseInventory warehouseInventoryDst = warehouseInventoryRepository.findByIdGoodAndIdWarehouse(goodId, warehouseIdDst);
        WarehouseInventory warehouseInventoryDst1 = new WarehouseInventory();

        if (warehouseIdSrc == warehouseIdDst) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        try {
            // jika data di inventory ada, ambil dari yang sudah ada, lakukan operasi penambahan
            // cek jika stok yang di request lebih dari stok di warehouse sumber
            if (warehouseInventorySrc.getWarehouseStock() >= warehouseToWarehouse.getAmountsGoods()){
                warehouseInventorySrc.setWarehouseStock(warehouseInventorySrc.getWarehouseStock()-warehouseToWarehouse.getAmountsGoods());
                // simpan perubahan tersebut di database inventory
                warehouseInventoryRepository.save(warehouseInventorySrc);
                try {
                    warehouseInventoryDst.setWarehouseStock(warehouseInventoryDst.getWarehouseStock()+warehouseToWarehouse.getAmountsGoods());
                    warehouseInventoryRepository.save(warehouseInventoryDst);
                } catch (Exception e){
                    warehouseInventoryDst1.setWarehouseStock(warehouseToWarehouse.getAmountsGoods());
                    warehouseInventoryDst1.setIdGood(goodId);
                    warehouseInventoryDst1.setIdWarehouse(warehouseIdDst);
                    warehouseInventoryRepository.save(warehouseInventoryDst1);
                }
                WarehouseToWarehouse warehouseToWarehouse1 = new WarehouseToWarehouse();

                warehouseToWarehouse1.setIdGood(goodId);
                warehouseToWarehouse1.setWarehouseSrc(warehouseIdSrc);
                warehouseToWarehouse1.setWarehouseDst(warehouseIdDst);
                warehouseToWarehouse1.setAmountsGoods(warehouseToWarehouse.getAmountsGoods());

                warehouseToWarehouseRepository.save(warehouseToWarehouse1);

                return new ResponseEntity<>(warehouseToWarehouse1, HttpStatus.OK);
            }
        } catch (Exception e) {
            // jika tidak ada, buat baru dari object yang diambil dari request
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
