package id.co.indivara.jdt12.warehouseproject.controller;

import id.co.indivara.jdt12.warehouseproject.Enum.EnumTransaction;
import id.co.indivara.jdt12.warehouseproject.entity.SupplyToWarehouse;
import id.co.indivara.jdt12.warehouseproject.entity.Transaction;
import id.co.indivara.jdt12.warehouseproject.entity.WarehouseInventory;
import id.co.indivara.jdt12.warehouseproject.entity.master.Good;
import id.co.indivara.jdt12.warehouseproject.entity.master.Warehouse;
import id.co.indivara.jdt12.warehouseproject.repository.GoodRepository;
import id.co.indivara.jdt12.warehouseproject.repository.SupplyToWarehouseRepository;
import id.co.indivara.jdt12.warehouseproject.repository.TransactionRepository;
import id.co.indivara.jdt12.warehouseproject.repository.WarehouseInventoryRepository;
import id.co.indivara.jdt12.warehouseproject.service.SupplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/supply")
public class SupplyController {
    @Autowired
    private SupplyService supplyService;

    @PostMapping("/create/{goodId}@{warehouseDst}")
    public ResponseEntity<SupplyToWarehouse> supplyToWarehouse(
            @PathVariable("goodId")
            Good goodId,
            @PathVariable("warehouseDst")
            Warehouse warehouseId,
            @RequestBody
            SupplyToWarehouse supplyToWarehouse
    ){
        return supplyService.supplyToWarehouse(goodId,warehouseId,supplyToWarehouse);
    }


//    @GetMapping("/all")
//    public ResponseEntity<List<SupplyToWarehouse>> viewSupply(){
//        List<SupplyToWarehouse> viewSupply = supplyToWarehouseRepository.findAll();
//        return new ResponseEntity<>(viewSupply, HttpStatus.OK);
//    }
}
