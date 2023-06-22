package id.co.indivara.jdt12.warehouseproject.service;

import id.co.indivara.jdt12.warehouseproject.entity.WarehouseInventory;
import id.co.indivara.jdt12.warehouseproject.entity.master.Good;
import id.co.indivara.jdt12.warehouseproject.entity.master.Warehouse;
import id.co.indivara.jdt12.warehouseproject.repository.WarehouseInventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Service
public class WarehouseInventoryService {
    @Autowired
    private WarehouseInventoryRepository warehouseInventoryRepository;

    public ResponseEntity<List<WarehouseInventory>> viewAllInventory(){
        List<WarehouseInventory> warehouseInventoriesAll = warehouseInventoryRepository.findAll();
        return new ResponseEntity<>(warehouseInventoriesAll, HttpStatus.OK);
    }

//    public ResponseEntity<WarehouseInventory> viewByWarehouseCode(String warehouseCode){
//        WarehouseInventory warehouseInventoriesByCode = warehouseInventoryRepository.fin
//        return new ResponseEntity<>(HttpStatus.OK);
//    }

    public ResponseEntity<List<WarehouseInventory>> viewByGoodId(
            Good goodId
    ){
        List<WarehouseInventory> warehouseInventoryByGoodId = new ArrayList<>();
        warehouseInventoryRepository.findByIdGood(goodId).forEach(warehouseInventoryByGoodId::add);
        return new ResponseEntity<>(warehouseInventoryByGoodId, HttpStatus.OK);
    }

    public ResponseEntity<List<WarehouseInventory>> viewByWarehouseId(
            Warehouse warehouseId
    ){
        List<WarehouseInventory> warehouseInventoriesByWarehouseId = new ArrayList<>();
        warehouseInventoryRepository.findByIdWarehouse(warehouseId).forEach(warehouseInventoriesByWarehouseId::add);
        return new ResponseEntity<>(warehouseInventoriesByWarehouseId, HttpStatus.OK);
    }
}
