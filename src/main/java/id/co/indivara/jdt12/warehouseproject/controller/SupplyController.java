package id.co.indivara.jdt12.warehouseproject.controller;

import id.co.indivara.jdt12.warehouseproject.entity.SupplyToWarehouse;
import id.co.indivara.jdt12.warehouseproject.entity.WarehouseInventory;
import id.co.indivara.jdt12.warehouseproject.entity.master.Good;
import id.co.indivara.jdt12.warehouseproject.entity.master.Warehouse;
import id.co.indivara.jdt12.warehouseproject.repository.GoodRepository;
import id.co.indivara.jdt12.warehouseproject.repository.SupplyToWarehouseRepository;
import id.co.indivara.jdt12.warehouseproject.repository.WarehouseInventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/supply")
public class SupplyController {
    @Autowired
    private SupplyToWarehouseRepository supplyToWarehouseRepository;        // dipakai jika ingin melihat record transaksi

    @Autowired
    private WarehouseInventoryRepository warehouseInventoryRepository;

    @Autowired
    private GoodRepository goodRepository;

    @GetMapping("/create/{warehouseDst}/{goodId}")
    public ResponseEntity<SupplyToWarehouse> supplyToWarehouse(
            @PathVariable("warehouseDst")
            Warehouse warehouseId,
            @PathVariable("goodId")
            Good goodId,
            @RequestBody
            SupplyToWarehouse supplyToWarehouse
    ){
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

        // masukkan data atau set data ke object transaksi

        // simpan object ke database

        return new ResponseEntity<>(supplyToWarehouse1, HttpStatus.OK);
        // ada error di parsing json, di request body sudah error

//        apakah lebih baik request body tidak mengambil object yang nested
        // inisialisasi object supplyToWarehouse1
//        SupplyToWarehouse supplyToWarehouse1 = new SupplyToWarehouse();
//        // inisialisasi object warehouseInventory
//        WarehouseInventory warehouseInventory = new WarehouseInventory();
        // ambil semua data dari request
        // contoh data
//        -01	id_trans
//        -04	warehouse_dst integer
//        -01	id_goods integer
//        -1000	amounts_goods integer

//        id_inventory integer [primary key]
//        id_goods integer
//        id_warehouse integer
//        warehouse_stock integer

        // generate id di database misal 1, sudah di generate otomatis
        // cek ke warehouse dengan id 04, apakah ada            jika tidak ada keluarkan error
        // masukkan nama barang, jumlah barang

//        Good aG = new Good();
//
//
////        WarehouseInventory warehouse1 = warehouseInventoryRepository.findByIdGoodAndIdWarehouse(supplyToWarehouse.getIdGood().getIdGood(), supplyToWarehouse.getWarehouseDst().getIdWarehouse());
//
//        Good idGoodIdentifier = goodRepository.findById(supplyToWarehouse.getIdGood().getIdGood()).get();
//        WarehouseInventory warehouseInventory1 = new WarehouseInventory();
//        // set warehouse inventory
//        try {
//            warehouseInventory.setIdGood(idGoodIdentifier);
//            warehouseInventory.setIdWarehouse(warehouseId);
//            warehouseInventory.setWarehouseStock(supplyToWarehouse.getAmountsGoods());
//            warehouseInventoryRepository.save(warehouseInventory);
//
//        } catch (Exception e) {
//            warehouseInventory1.setIdGood(idGoodIdentifier);
//            warehouseInventory1.setIdWarehouse(warehouseId);
//            warehouseInventory1.setWarehouseStock(supplyToWarehouse.getAmountsGoods());
//            warehouseInventoryRepository.save(warehouseInventory1);
//        }
//
//        // set ke supply to warehouse
////        warehouseRepository.findById(idWarehouse);      // belum ada exception
//        supplyToWarehouse1.setWarehouseDst(warehouse1.getIdWarehouse());
//        supplyToWarehouse1.setIdGood(idGoodIdentifier);
//        supplyToWarehouse1.setAmountsGoods(supplyToWarehouse1.getAmountsGoods());
//
//        supplyToWarehouseRepository.save(supplyToWarehouse1);
//
//        return new ResponseEntity<>(supplyToWarehouse1, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<SupplyToWarehouse>> viewSupply(){
        List<SupplyToWarehouse> viewSupply = supplyToWarehouseRepository.findAll();
        return new ResponseEntity<>(viewSupply, HttpStatus.OK);
    }
}
