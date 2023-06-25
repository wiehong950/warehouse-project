package id.co.indivara.jdt12.warehouseproject.controller;

import id.co.indivara.jdt12.warehouseproject.entity.WarehouseToStore;
import id.co.indivara.jdt12.warehouseproject.entity.master.Good;
import id.co.indivara.jdt12.warehouseproject.entity.master.Store;
import id.co.indivara.jdt12.warehouseproject.entity.master.Warehouse;
import id.co.indivara.jdt12.warehouseproject.service.WarehouseToStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/whtostr")
public class WarehouseToStoreController {
    @Autowired
    private WarehouseToStoreService warehouseToStoreService;

    @PostMapping("/create/{goodId}@{warehouseId}/{storeId}")
    public ResponseEntity<WarehouseToStore> createWarehouseToStore(
            @PathVariable("goodId")
            Good goodId,
            @PathVariable("warehouseId")
            Warehouse warehouseId,
            @PathVariable("storeId")
            Store storeId,
            @RequestBody
            WarehouseToStore warehouseToStore
    ){
        return warehouseToStoreService.createWarehouseToStore(goodId, warehouseId, storeId, warehouseToStore);
    }

    @GetMapping("/all")
    public ResponseEntity<List<WarehouseToStore>> viewDelivery(){
        return warehouseToStoreService.viewDelivery();
    }
}
