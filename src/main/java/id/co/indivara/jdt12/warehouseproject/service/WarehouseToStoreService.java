package id.co.indivara.jdt12.warehouseproject.service;

import id.co.indivara.jdt12.warehouseproject.Enum.EnumTransaction;
import id.co.indivara.jdt12.warehouseproject.entity.StoreInventory;
import id.co.indivara.jdt12.warehouseproject.entity.Transaction;
import id.co.indivara.jdt12.warehouseproject.entity.WarehouseInventory;
import id.co.indivara.jdt12.warehouseproject.entity.WarehouseToStore;
import id.co.indivara.jdt12.warehouseproject.entity.master.Good;
import id.co.indivara.jdt12.warehouseproject.entity.master.Store;
import id.co.indivara.jdt12.warehouseproject.entity.master.Warehouse;
import id.co.indivara.jdt12.warehouseproject.repository.StoreInventoryRepository;
import id.co.indivara.jdt12.warehouseproject.repository.TransactionRepository;
import id.co.indivara.jdt12.warehouseproject.repository.WarehouseInventoryRepository;
import id.co.indivara.jdt12.warehouseproject.repository.WarehouseToStoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WarehouseToStoreService {
    @Autowired
    private WarehouseToStoreRepository warehouseToStoreRepository;

    @Autowired
    private WarehouseInventoryRepository warehouseInventoryRepository;

    @Autowired
    private StoreInventoryRepository storeInventoryRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    public ResponseEntity<WarehouseToStore> createWarehouseToStore(
            Good goodId,
            Warehouse warehouseId,
            Store storeId,
            WarehouseToStore warehouseToStore
    ){
        WarehouseInventory warehouseInventorySrc = warehouseInventoryRepository.findByIdGoodAndIdWarehouse(goodId, warehouseId);
        StoreInventory storeInventoryDst = storeInventoryRepository.findByIdGoodAndIdStore(goodId, storeId);
        StoreInventory storeInventoryDstIsEmpty = new StoreInventory();

        try {
            if (warehouseInventorySrc.getWarehouseStock() >= warehouseToStore.getAmountsGoods()){
                warehouseInventorySrc.setWarehouseStock(warehouseInventorySrc.getWarehouseStock()- warehouseToStore.getAmountsGoods());
                warehouseInventoryRepository.save(warehouseInventorySrc);
                try {
                    storeInventoryDst.setStoreStock(storeInventoryDst.getStoreStock()+warehouseToStore.getAmountsGoods());
                    storeInventoryRepository.save(storeInventoryDst);
                } catch (Exception e) {
                    storeInventoryDstIsEmpty.setStoreStock(warehouseToStore.getAmountsGoods());
                    storeInventoryDstIsEmpty.setIdStore(storeId);
                    storeInventoryDstIsEmpty.setIdGood(goodId);
                    storeInventoryRepository.save(storeInventoryDstIsEmpty);
                }
                WarehouseToStore warehouseToStore1 = new WarehouseToStore();

                warehouseToStore1.setWarehouseSrc(warehouseId);
                warehouseToStore1.setStoreDst(storeId);
                warehouseToStore1.setIdGoods(goodId);
                warehouseToStore1.setAmountsGoods(warehouseToStore.getAmountsGoods());

                warehouseToStoreRepository.save(warehouseToStore1);

                // simpan ke transaksi
                // buat object transaksi
                Transaction transaction = new Transaction();

                // masukkan data atau set data ke object transaksi
                transaction.setIdGood(goodId);
                transaction.setAmountGoods(warehouseToStore1.getAmountsGoods());
                transaction.setIdByTransType(warehouseToStore1.getTransId());
                transaction.setTransType(EnumTransaction.WAREHOUSETOSTORE.getText());

                // simpan object ke database
                transactionRepository.save(transaction);

                return new ResponseEntity<>(warehouseToStore1, HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<WarehouseToStore>> viewDelivery(){
        List<WarehouseToStore> viewDelivery = warehouseToStoreRepository.findAll();
        return new ResponseEntity<>(viewDelivery, HttpStatus.OK);
    }
}
