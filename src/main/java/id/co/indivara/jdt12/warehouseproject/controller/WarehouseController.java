package id.co.indivara.jdt12.warehouseproject.controller;

import id.co.indivara.jdt12.warehouseproject.entity.master.Warehouse;
import id.co.indivara.jdt12.warehouseproject.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/warehouse")
public class WarehouseController {
    @Autowired
    private WarehouseService warehouseService;

    // create warehouse
    @PostMapping("/create")
    public Warehouse createWarehouse(@RequestBody Warehouse warehouse) {
        return warehouseService.createWarehouse(warehouse);
    }

    // view all warehouse
    @GetMapping("/viewall")
    public List<Warehouse> viewAllWarehouse(){
        return warehouseService.viewAllWarehouse();
    }

    // update warehouse
    @PutMapping("/update/{warehouseId}")
    public Warehouse updateWarehouse(
            @PathVariable Long warehouseId,
            @RequestBody Warehouse warehouse){
        return warehouseService.updateWarehouse(warehouseId, warehouse);
    }

    // delete warehouse by id
    @DeleteMapping("/remove/{warehouseId}")
    public void deleteWarehouse(@PathVariable Long warehouseId){
        warehouseService.deleteWarehouse(warehouseId);
    }
}
