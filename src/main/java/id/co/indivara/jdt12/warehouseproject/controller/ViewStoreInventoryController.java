package id.co.indivara.jdt12.warehouseproject.controller;

import id.co.indivara.jdt12.warehouseproject.entity.StoreInventory;
import id.co.indivara.jdt12.warehouseproject.entity.master.Good;
import id.co.indivara.jdt12.warehouseproject.entity.master.Store;
import id.co.indivara.jdt12.warehouseproject.repository.StoreInventoryRepository;
import id.co.indivara.jdt12.warehouseproject.service.StoreInventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/store-inventory")
public class ViewStoreInventoryController {
    @Autowired
    private StoreInventoryRepository storeInventoryRepository;

    @Autowired
    private StoreInventoryService storeInventoryService;

    @GetMapping("/viewall")
    public ResponseEntity<List<StoreInventory>> viewAllInventory(){
        return storeInventoryService.viewAllInventory();
    }

    @GetMapping("/viewbygoodid/{goodId}")
    public ResponseEntity<List<StoreInventory>> viewByGoodId(
            @PathVariable("goodId")
            Good goodId
    ){
        return storeInventoryService.viewByGoodId(goodId);
    }

    @GetMapping("/viewbystoreid/{storeId}")
    public ResponseEntity<List<StoreInventory>> viewByStoreId(
            @PathVariable("storeId")
            Store storeId
    ){
        return storeInventoryService.viewByStoreId(storeId);
    }

//    @GetMapping("/viewbystorecode/{storeCode}")
//    public ResponseEntity<List<StoreInventory>> viewByStoreCode(
//            @PathVariable("storeCode")
//            Store store
//    ){
//        List<StoreInventory> storeInventoriesByStoreCode = new ArrayList<>();
//        storeInventoryRepository.findByStoreCode(store).forEach(storeInventoriesByStoreCode::add);
//        return new ResponseEntity<>(storeInventoriesByStoreCode, HttpStatus.OK);
//        // ini harusnya bukan list
//    }
}
