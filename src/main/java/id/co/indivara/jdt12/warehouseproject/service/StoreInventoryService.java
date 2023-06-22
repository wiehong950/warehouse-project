package id.co.indivara.jdt12.warehouseproject.service;

import id.co.indivara.jdt12.warehouseproject.entity.StoreInventory;
import id.co.indivara.jdt12.warehouseproject.entity.master.Good;
import id.co.indivara.jdt12.warehouseproject.entity.master.Store;
import id.co.indivara.jdt12.warehouseproject.repository.StoreInventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StoreInventoryService {
    @Autowired
    private StoreInventoryRepository storeInventoryRepository;

    public ResponseEntity<List<StoreInventory>> viewAllInventory(){
        List<StoreInventory> storeInventoriesAll = storeInventoryRepository.findAll();
        return new ResponseEntity<>(storeInventoriesAll, HttpStatus.OK);
    }

    public ResponseEntity<List<StoreInventory>> viewByGoodId(
            Good goodId
    ){
        List<StoreInventory> storeInventoriesByGoodId = new ArrayList<>();
        storeInventoryRepository.findByIdGood(goodId).forEach(storeInventoriesByGoodId::add);
        return new ResponseEntity<>(storeInventoriesByGoodId, HttpStatus.OK);
    }

    public ResponseEntity<List<StoreInventory>> viewByStoreId(
            Store storeId
    ){
        List<StoreInventory> storeInventoriesByStoreId = new ArrayList<>();
        storeInventoryRepository.findByIdStore(storeId).forEach(storeInventoriesByStoreId::add);
        return new ResponseEntity<>(storeInventoriesByStoreId, HttpStatus.OK);
    }
}
