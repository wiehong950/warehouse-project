package id.co.indivara.jdt12.warehouseproject.controller;

import id.co.indivara.jdt12.warehouseproject.entity.master.Good;
import id.co.indivara.jdt12.warehouseproject.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/good")
public class GoodController {
    @Autowired
    private GoodService goodService;

    // create Good
    @PostMapping("/create")
    public Good createGood(@RequestBody Good good){
        return goodService.createGood(good);
    }

    // view all good
    @GetMapping("/viewall")
    public List<Good> viewAllGoods() {
        return goodService.viewAllGoods();
    }

    @PutMapping("/update/{goodId}")
    public Good updateGood(
            @PathVariable Long goodId,
            @RequestBody Good good
    ){
        return goodService.updateGood(goodId, good);
    }

    @DeleteMapping("/remove/{id}")
    public void deleteGoodById(@PathVariable Long id){
        goodService.deleteGoodById(id);
    }
}
