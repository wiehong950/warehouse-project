package id.co.indivara.jdt12.warehouseproject.controller;

import id.co.indivara.jdt12.warehouseproject.entity.master.Store;
import id.co.indivara.jdt12.warehouseproject.entity.master.Warehouse;
import id.co.indivara.jdt12.warehouseproject.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/store")
public class StoreController {
    @Autowired
    private StoreRepository storeRepository;

    // create store
    @GetMapping("/create")
    public Store createStore(@RequestBody Store store){
        return storeRepository.save(store);
    }

    // view all store
    @GetMapping("/viewall")
    public List<Store> viewAllStore(){
        return new ArrayList<>(storeRepository.findAll());
    }

    @PutMapping("/update")
    public Store updateStore(@RequestBody Store store){
        return storeRepository.save(store);
    }

    @DeleteMapping("/remove")
    public void deleteStore(@RequestParam Integer id){
        storeRepository.deleteById(id);
    }
}
