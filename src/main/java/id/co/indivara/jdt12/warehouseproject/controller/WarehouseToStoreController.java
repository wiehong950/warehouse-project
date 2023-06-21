package id.co.indivara.jdt12.warehouseproject.controller;

import id.co.indivara.jdt12.warehouseproject.entity.StoreInventory;
import id.co.indivara.jdt12.warehouseproject.entity.WarehouseInventory;
import id.co.indivara.jdt12.warehouseproject.entity.WarehouseToStore;
import id.co.indivara.jdt12.warehouseproject.entity.master.Good;
import id.co.indivara.jdt12.warehouseproject.entity.master.Store;
import id.co.indivara.jdt12.warehouseproject.entity.master.Warehouse;
import id.co.indivara.jdt12.warehouseproject.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/whtostr")
public class WarehouseToStoreController {
    @Autowired
    private WarehouseToStoreRepository warehouseToStoreRepository;

    @Autowired
    private WarehouseInventoryRepository warehouseInventoryRepository;

    @Autowired
    private StoreInventoryRepository storeInventoryRepository;

    @Autowired
    private WarehouseRepository warehouseRepository;

    @Autowired
    private StoreRepository storeRepository;

    @GetMapping("/create/{warehouseId}/{storeId}/{goodId}")
    public ResponseEntity<WarehouseToStore> createWarehouseToStore(
            @PathVariable
            Warehouse warehouseId,
            @PathVariable
            Store storeId,
            @PathVariable
            Good goodId,
            @RequestBody
            WarehouseToStore warehouseToStore
    ){

        WarehouseInventory warehouseInventorySrc = warehouseInventoryRepository.findByIdGoodAndIdWarehouse(goodId, warehouseId);
        StoreInventory storeInventoryDst = storeInventoryRepository.findByIdGoodAndIdStore(goodId, storeId);
        WarehouseInventory warehouseInventorySrcIsEmpty = new WarehouseInventory();
        StoreInventory storeInventoryDstIsEmpty = new StoreInventory();

        try {
            warehouseInventorySrc.setWarehouseStock(warehouseInventorySrc.getWarehouseStock()- warehouseToStore.getAmountsGoods());
            warehouseInventoryRepository.save(warehouseInventorySrc);
        } catch (Exception e) {
            warehouseInventorySrcIsEmpty.setIdWarehouse(warehouseId);
            warehouseInventorySrcIsEmpty.setIdGood(goodId);
            warehouseInventorySrcIsEmpty.setWarehouseStock(warehouseToStore.getAmountsGoods());
            warehouseInventoryRepository.save(warehouseInventorySrcIsEmpty);
        }

        WarehouseToStore warehouseToStore1 = new WarehouseToStore();

        warehouseToStore1.setWarehouseSrc(warehouseId);
        warehouseToStore1.setStoreDst(storeId);
        warehouseToStore1.setIdGoods(goodId);
        warehouseToStore1.setAmountsGoods(warehouseToStore.getAmountsGoods());

        warehouseToStoreRepository.save(warehouseToStore1);

        return new ResponseEntity<>(warehouseToStore1, HttpStatus.OK);
    }

}
