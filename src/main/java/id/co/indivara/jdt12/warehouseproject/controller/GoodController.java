package id.co.indivara.jdt12.warehouseproject.controller;

import id.co.indivara.jdt12.warehouseproject.entity.master.Good;
import id.co.indivara.jdt12.warehouseproject.repository.GoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/good")
public class GoodController {
    @Autowired
    private GoodRepository goodRepository;

    // create Good
    @GetMapping("/create")
    public Good createGood(@RequestBody Good good){
        return goodRepository.save(good);
    }

    // view all good
    @GetMapping("/viewall")
    public List<Good> viewAllGoods() {
        return new ArrayList<>(goodRepository.findAll());
    }

    @PutMapping("/update")
    public Good updateGood(@RequestBody Good good){
        return goodRepository.save(good);
    }

    @DeleteMapping("/remove")
    public void deleteGoodById(@RequestParam Integer id){
        goodRepository.deleteById(id);
    }
}
