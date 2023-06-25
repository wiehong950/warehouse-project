package id.co.indivara.jdt12.warehouseproject.controller;

import id.co.indivara.jdt12.warehouseproject.entity.Transaction;
import id.co.indivara.jdt12.warehouseproject.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/alltrans")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @GetMapping("/viewAll")
    public ResponseEntity<List<Transaction>> viewAll(){
        return transactionService.viewAll();
    }
}
