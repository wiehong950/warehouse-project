package id.co.indivara.jdt12.warehouseproject.controller;

import id.co.indivara.jdt12.warehouseproject.entity.master.Warehouse;
import id.co.indivara.jdt12.warehouseproject.repository.WarehouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/warehouse")
public class WarehouseController {
    @Autowired
    private WarehouseRepository warehouseRepository;

    // create warehouse
    @GetMapping("/create")
    public Warehouse createWarehouse(@RequestBody Warehouse warehouse) {
        return warehouseRepository.save(warehouse);
    }

    // view all warehouse
    @GetMapping("/viewall")
    public List<Warehouse> viewAllWarehouse(){
        return new ArrayList<>(warehouseRepository.findAll());
    }

    // update warehouse
    @PutMapping("/update")
    public Warehouse updateWarehouse(@RequestBody Warehouse warehouse){
        return warehouseRepository.save(warehouse);
    }

    // delete warehouse by id
    @DeleteMapping("/remove")
    public void deleteWarehouse(@RequestParam Integer id){
        warehouseRepository.deleteById(id);
    }
}
