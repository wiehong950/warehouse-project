package id.co.indivara.jdt12.warehouseproject.controller;

import id.co.indivara.jdt12.warehouseproject.entity.WarehouseInventory;
import id.co.indivara.jdt12.warehouseproject.entity.WarehouseToWarehouse;
import id.co.indivara.jdt12.warehouseproject.entity.master.Good;
import id.co.indivara.jdt12.warehouseproject.entity.master.Warehouse;
import id.co.indivara.jdt12.warehouseproject.repository.WarehouseInventoryRepository;
import id.co.indivara.jdt12.warehouseproject.repository.WarehouseToWarehouseRepository;
import id.co.indivara.jdt12.warehouseproject.service.WarehouseToWarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/whtowh")
public class WarehouseToWarehouseController {
    @Autowired
    private WarehouseToWarehouseService warehouseToWarehouseService;

    @PostMapping("/create/{goodId}@{warehouseSrc}/{warehouseDst}")
    public ResponseEntity<WarehouseToWarehouse> warehouseToWarehouse(
            @PathVariable("goodId")
            Good goodId,
            @PathVariable("warehouseSrc")
            Warehouse warehouseIdSrc,
            @PathVariable("warehouseDst")
            Warehouse warehouseIdDst,
            @RequestBody
            WarehouseToWarehouse warehouseToWarehouse
    ){
        return warehouseToWarehouseService.warehouseToWarehouseResponseEntity(goodId, warehouseIdSrc, warehouseIdDst, warehouseToWarehouse);
    }
}
