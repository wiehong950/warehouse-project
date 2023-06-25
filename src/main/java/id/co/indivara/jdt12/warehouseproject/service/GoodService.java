package id.co.indivara.jdt12.warehouseproject.service;

import id.co.indivara.jdt12.warehouseproject.entity.master.Good;
import id.co.indivara.jdt12.warehouseproject.repository.GoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Service
public class GoodService {
    @Autowired
    private GoodRepository goodRepository;

    public Good createGood(Good good){
        return goodRepository.save(good);
    }

    public List<Good> viewAllGoods() {
        return new ArrayList<>(goodRepository.findAll());
    }

    public Good updateGood(Long goodId, Good good){
        Good goodFind = goodRepository.findById(goodId).get();
        goodFind.setNameGood(good.getNameGood());
        goodFind.setDescGood(good.getDescGood());
        return goodRepository.save(goodFind);
    }

    public void deleteGoodById(Long id){
        goodRepository.deleteById(id);
    }
}
