package id.co.indivara.jdt12.warehouseproject.controller;

import id.co.indivara.jdt12.warehouseproject.entity.WarehouseInventory;
import id.co.indivara.jdt12.warehouseproject.entity.master.Good;
import id.co.indivara.jdt12.warehouseproject.repository.WarehouseInventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/warehouse-inventory")
public class ViewWarehouseInventoryController {
    @Autowired
    private WarehouseInventoryRepository warehouseInventoryRepository;

    @GetMapping("/viewAll")
    public ResponseEntity<List<WarehouseInventory>> viewAllInventory(){
        List<WarehouseInventory> warehouseInventoriesAll = warehouseInventoryRepository.findAll();
        return new ResponseEntity<>(warehouseInventoriesAll, HttpStatus.OK);
    }

//    @GetMapping("/view-warehouse/{warehouseCode}")
//    public ResponseEntity<WarehouseInventory> viewByWarehouseCode(@PathVariable Integer warehouseCode){
//        WarehouseInventory warehouseInventoriesByCode = warehouseInventoryRepository.fin
//        return new ResponseEntity<>(HttpStatus.OK);
//    }

    @GetMapping("/viewbygoodid/{goodId}")
    public ResponseEntity<List<WarehouseInventory>> viewByGoodId(@PathVariable Good goodId){
        List<WarehouseInventory> warehouseInventoryByGoodId = new ArrayList<>();
        warehouseInventoryRepository.findByIdGood(goodId).forEach(warehouseInventoryByGoodId::add);
        return new ResponseEntity<>(warehouseInventoryByGoodId, HttpStatus.OK);
    }
}
