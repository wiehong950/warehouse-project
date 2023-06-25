package id.co.indivara.jdt12.warehouseproject.service;

import id.co.indivara.jdt12.warehouseproject.entity.Transaction;
import id.co.indivara.jdt12.warehouseproject.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    public ResponseEntity<List<Transaction>> viewAll(){
        List<Transaction> listViewAll = transactionRepository.findAll();
        return new ResponseEntity<>(listViewAll, HttpStatus.OK);
    }
}
