package id.co.indivara.jdt12.warehouseproject.service;

import id.co.indivara.jdt12.warehouseproject.entity.master.Warehouse;
import id.co.indivara.jdt12.warehouseproject.repository.WarehouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WarehouseService {
    @Autowired
    private WarehouseRepository warehouseRepository;

    // create warehouse
    public Warehouse createWarehouse(Warehouse warehouse) {
        return warehouseRepository.save(warehouse);
    }

    // view all warehouse
    public List<Warehouse> viewAllWarehouse(){
        return new ArrayList<>(warehouseRepository.findAll());
    }

    // update warehouse
    public Warehouse updateWarehouse(Long id, Warehouse warehouse){
        Warehouse warehouseFind = warehouseRepository.findById(id).get();
        warehouseFind.setNameWarehouse(warehouse.getNameWarehouse());
        warehouseFind.setAddressWarehouse(warehouse.getAddressWarehouse());
        warehouseFind.setPhoneNumberWarehouse(warehouse.getPhoneNumberWarehouse());
        return warehouseRepository.save(warehouseFind);
    }

    // delete warehouse by id
    public void deleteWarehouse(Long id){
        warehouseRepository.deleteById(id);
    }
}
