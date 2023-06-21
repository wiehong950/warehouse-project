package id.co.indivara.jdt12.warehouseproject.controller;

import id.co.indivara.jdt12.warehouseproject.entity.StoreInventory;
import id.co.indivara.jdt12.warehouseproject.repository.StoreInventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/store-inventory")
public class ViewStoreInventoryController {
    @Autowired
    private StoreInventoryRepository storeInventoryRepository;

    @GetMapping("/viewall")
    public ResponseEntity<List<StoreInventory>> viewAllInventory(){
        List<StoreInventory> storeInventoriesAll = storeInventoryRepository.findAll();
        return new ResponseEntity<>(storeInventoriesAll, HttpStatus.OK);
    }
}
