package id.co.indivara.jdt12.warehouseproject.repository;

import id.co.indivara.jdt12.warehouseproject.entity.WarehouseInventory;
import id.co.indivara.jdt12.warehouseproject.entity.master.Good;
import id.co.indivara.jdt12.warehouseproject.entity.master.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface WarehouseInventoryRepository extends JpaRepository<WarehouseInventory, Long> {
    WarehouseInventory findByIdGoodAndIdWarehouse(Good idGood, Warehouse idWarehouse);
    List<WarehouseInventory> findByIdGood(Good idGood);
    List<WarehouseInventory> findByIdWarehouse(Warehouse warehouse);
}
