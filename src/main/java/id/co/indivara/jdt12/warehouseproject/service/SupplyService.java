package id.co.indivara.jdt12.warehouseproject.service;

import id.co.indivara.jdt12.warehouseproject.Enum.EnumTransaction;
import id.co.indivara.jdt12.warehouseproject.entity.SupplyToWarehouse;
import id.co.indivara.jdt12.warehouseproject.entity.Transaction;
import id.co.indivara.jdt12.warehouseproject.entity.WarehouseInventory;
import id.co.indivara.jdt12.warehouseproject.entity.master.Good;
import id.co.indivara.jdt12.warehouseproject.entity.master.Warehouse;
import id.co.indivara.jdt12.warehouseproject.repository.SupplyToWarehouseRepository;
import id.co.indivara.jdt12.warehouseproject.repository.TransactionRepository;
import id.co.indivara.jdt12.warehouseproject.repository.WarehouseInventoryRepository;
import id.co.indivara.jdt12.warehouseproject.repository.WarehouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplyService {
    @Autowired
    private SupplyToWarehouseRepository supplyToWarehouseRepository;        // dipakai jika ingin melihat record transaksi

    @Autowired
    private WarehouseInventoryRepository warehouseInventoryRepository;

    @Autowired
    private WarehouseRepository warehouseRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    public ResponseEntity<SupplyToWarehouse> supplyToWarehouse (Good goodId, Warehouse warehouseId, SupplyToWarehouse supplyToWarehouse){
        // goodIdwarehouseDst
        // lakukan operasi pertama dahulu yaitu simpan ke tabel Warehouse Inventory
        // buat dua object baru
        // yang pertama bila inventorynya sudah ada
        WarehouseInventory warehouseInventory = warehouseInventoryRepository.findByIdGoodAndIdWarehouse(goodId, warehouseId);
        // yang kedua bila inventorynya tidak ada
        WarehouseInventory warehouseInventory1 = new WarehouseInventory();

        try {
            // jika ada, ambil dari yang sudah ada, lakukan operasi penambahan
            warehouseInventory.setWarehouseStock(warehouseInventory.getWarehouseStock()+supplyToWarehouse.getAmountsGoods());
            // simpan perubahan tersebut di database inventory
            warehouseInventoryRepository.save(warehouseInventory);
        } catch (Exception e) {
            // jika tidak ada, buat baru dari object yang diambil dari request
            warehouseInventory1.setWarehouseStock(supplyToWarehouse.getAmountsGoods());
            warehouseInventory1.setIdGood(goodId);
            warehouseInventory1.setIdWarehouse(warehouseId);
            // simpan perubahan di database inventory
            warehouseInventoryRepository.save(warehouseInventory1);
        }

        // lalu operasi kedua yaitu simpan ke tabel daftar supply ke warehouse
        // buat object baru untuk supply warehouse
        SupplyToWarehouse supplyToWarehouse1 = new SupplyToWarehouse();

        // masukkan data atau set data ke object tersebut
        supplyToWarehouse1.setIdGood(goodId);
        supplyToWarehouse1.setWarehouseDst(warehouseId);
        supplyToWarehouse1.setAmountsGoods(supplyToWarehouse.getAmountsGoods());

        // simpan object yang sudah ada di database supplyToWarehouse
        supplyToWarehouseRepository.save(supplyToWarehouse1);

        // simpan ke transaksi
        // buat object transaksi
        Transaction transaction = new Transaction();

        // masukkan data atau set data ke object transaksi
        transaction.setIdGood(goodId);
        transaction.setAmountGoods(supplyToWarehouse1.getAmountsGoods());
        transaction.setIdByTransType(supplyToWarehouse1.getTransId());
        transaction.setTransType(EnumTransaction.SUPPLYTOWAREHOUSE.getText());

        // simpan object ke database
        transactionRepository.save(transaction);
        return new ResponseEntity<>(supplyToWarehouse1, HttpStatus.OK);
    }

    public ResponseEntity<List<SupplyToWarehouse>> viewSupply(){
        List<SupplyToWarehouse> viewSupply = supplyToWarehouseRepository.findAll();
        return new ResponseEntity<>(viewSupply, HttpStatus.OK);
    }
}
