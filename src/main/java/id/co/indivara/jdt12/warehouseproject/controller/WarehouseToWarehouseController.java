package id.co.indivara.jdt12.warehouseproject.controller;

import id.co.indivara.jdt12.warehouseproject.entity.WarehouseInventory;
import id.co.indivara.jdt12.warehouseproject.entity.WarehouseToWarehouse;
import id.co.indivara.jdt12.warehouseproject.entity.master.Good;
import id.co.indivara.jdt12.warehouseproject.entity.master.Warehouse;
import id.co.indivara.jdt12.warehouseproject.repository.WarehouseInventoryRepository;
import id.co.indivara.jdt12.warehouseproject.repository.WarehouseToWarehouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/whtowh")
public class WarehouseToWarehouseController {
    @Autowired
    private WarehouseToWarehouseRepository warehouseToWarehouseRepository;

    @Autowired
    private WarehouseInventoryRepository warehouseInventoryRepository;

    @GetMapping("/create/{warehouseSrc}/{warehouseDst}/{goodId}")
    public ResponseEntity<WarehouseToWarehouse> warehouseToWarehouse(
            @PathVariable("warehouseSrc")
            Warehouse warehouseIdSrc,
            @PathVariable("warehouseDst")
            Warehouse warehouseIdDst,
            @PathVariable("goodId")
            Good goodId,
            @RequestBody
            WarehouseToWarehouse warehouseToWarehouse
    ){
        WarehouseInventory warehouseInventorySrc = warehouseInventoryRepository.findByIdGoodAndIdWarehouse(goodId, warehouseIdSrc);
        WarehouseInventory warehouseInventoryDst = warehouseInventoryRepository.findByIdGoodAndIdWarehouse(goodId, warehouseIdDst);
        WarehouseInventory warehouseInventorySrc1 = new WarehouseInventory();
        WarehouseInventory warehouseInventoryDst1 = new WarehouseInventory();

        // belum cek jika stok kurang
        // jika stok kurang akan mengeluarkan error

        try {
            // jika data di inventory ada, ambil dari yang sudah ada, lakukan operasi penambahan
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





//        WarehouseInventory warehouseInventorySrc;
//        WarehouseInventory warehouseInventoryDst;
//        WarehouseToWarehouse warehouseToWarehouse1 = new WarehouseToWarehouse();
//        // ambil semua data dari request
//        // contoh data
////        -01	id_trans
////        -02	warehouse_src               apakah ini diganti dengan warehouse_id?
////        -04	warehouse_dst integer
////        -01	id_goods integer
////        -1000	amounts_goods integer
//
////        id_inventory integer [primary key]
////        id_goods integer
////        id_warehouse integer
////        warehouse_stock integer
//
//        // apakah ini ada di activity diagram?
//        // generate id di database misal 1, sudah di generate otomatis
//        // cek ke warehouse dengan id 02, apakah ada
//        // cek ke warehouse dengan id 04, apakah ada
//        // bila ada cek apakah barang dengan id 01, di table warehouse inventory dengan warehouse id 02, apakah ada
//        // lalu cek jumlah barang dengan id 01, di table warehouse inventory dengan warehouse id 02, dan id 01
//        // cek apakah nilai stok barang lebih dari atau kurang dari jumlah yang diinginkan
//        // jika stok barang kurang, akan keluar error
//        // jika stok ada,
//        // kurangi barang dengan warehouse id 01, dan id goods 01
//        // tambahkan barang dengan warehouse id 04, dan id goods 01
//
//
////        int idWarehouseSrc = warehouseToWarehouse.getWarehouseSrc().getIdWarehouse();       // belum ada exception jika tidak ada
////        int idWarehouseDst = warehouseToWarehouse.getWarehouseDst().getIdWarehouse();       // belum ada exception jika tidak ada
////        int idGoods = warehouseToWarehouse.getIdGood().getIdGood();
////        int goodChange = warehouseToWarehouse.getAmountsGoods();
////
////        warehouseInventorySrc = warehouseInventoryRepository.findByIdGoodAndIdWarehouse(idGoods, idWarehouseSrc);
////        warehouseInventoryDst = warehouseInventoryRepository.findByIdGoodAndIdWarehouse(idGoods, idWarehouseDst);
////        int stockSrc = warehouseInventorySrc.getWarehouseStock();
////
////        int stockDst = warehouseInventoryDst.getWarehouseStock();       // belum cek destinasi warehouse ada atau ggk
////
////        // set 2 warehouse inventory
////        if (stockSrc > goodChange){
////            warehouseInventoryDst.setWarehouseStock(stockDst + goodChange);     // belum ada exception
////            warehouseInventorySrc.setWarehouseStock(stockSrc - goodChange);     // belum ada exception
////        }
////
////        warehouseToWarehouse1.setWarehouseSrc(warehouseRepository.findById(idWarehouseSrc).get());      // belum ada exception
////        warehouseToWarehouse1.setWarehouseDst(warehouseRepository.findById(idWarehouseDst).get());      // belum ada exception
////
////        return new ResponseEntity<>(warehouseToWarehouse1, HttpStatus.OK);
//
        // how to record the transaction?
    }
}
