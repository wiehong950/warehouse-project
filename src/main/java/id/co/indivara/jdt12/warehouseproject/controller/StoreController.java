package id.co.indivara.jdt12.warehouseproject.controller;

import id.co.indivara.jdt12.warehouseproject.entity.master.Store;
import id.co.indivara.jdt12.warehouseproject.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/store")
public class StoreController {
    @Autowired
    private StoreService storeService;

    // create store
    @PostMapping("/create")
    public Store createStore(@RequestBody Store store){
        return storeService.createStore(store);
    }

    // view all store
    @GetMapping("/viewall")
    public List<Store> viewAllStore(){
        return storeService.viewAllStore();
    }

    @PutMapping("/update/{storeId}")
    public Store updateStore(
            @PathVariable Long storeId,
            @RequestBody Store store){
        return storeService.updateStore(storeId, store);
    }

    @DeleteMapping("/remove/{storeId}")
    public void deleteStore(@PathVariable Long storeId){
        storeService.deleteStore(storeId);
    }
}
