package id.co.indivara.jdt12.warehouseproject.controller;

import id.co.indivara.jdt12.warehouseproject.entity.WarehouseInventory;
import id.co.indivara.jdt12.warehouseproject.entity.master.Good;
import id.co.indivara.jdt12.warehouseproject.entity.master.Warehouse;
import id.co.indivara.jdt12.warehouseproject.repository.WarehouseInventoryRepository;
import id.co.indivara.jdt12.warehouseproject.service.WarehouseInventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/warehouse-inventory")
public class ViewWarehouseInventoryController {
    @Autowired
    private WarehouseInventoryRepository warehouseInventoryRepository;

    @Autowired
    private WarehouseInventoryService warehouseInventoryService;

    @GetMapping("/viewAll")
    public ResponseEntity<List<WarehouseInventory>> viewAllInventory(){
        return warehouseInventoryService.viewAllInventory();
    }

    @GetMapping("/viewbygoodid/{goodId}")
    public ResponseEntity<List<WarehouseInventory>> viewByGoodId(
            @PathVariable("goodId")
            Good goodId
    ) {
        return warehouseInventoryService.viewByGoodId(goodId);
    }

    @GetMapping("/viewbywarehouseid/{warehouseId}")
    public ResponseEntity<List<WarehouseInventory>> viewByWarehouseId(
            @PathVariable("warehouseId")
            Warehouse warehouseId
    ){
        return warehouseInventoryService.viewByWarehouseId(warehouseId);
    }

//    @GetMapping("/view-warehouse/{warehouseCode}")
//    public ResponseEntity<WarehouseInventory> viewByWarehouseCode(@PathVariable String warehouseCode){
//        return warehouseInventoryService.viewByWarehouseCode(warehouseCode);
//    }
}
