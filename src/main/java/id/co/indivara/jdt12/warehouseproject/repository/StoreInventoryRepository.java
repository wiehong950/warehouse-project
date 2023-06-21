package id.co.indivara.jdt12.warehouseproject.repository;

import id.co.indivara.jdt12.warehouseproject.entity.StoreInventory;
import id.co.indivara.jdt12.warehouseproject.entity.master.Good;
import id.co.indivara.jdt12.warehouseproject.entity.master.Store;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface StoreInventoryRepository extends JpaRepository<StoreInventory, Integer> {
    StoreInventory findByIdGoodAndIdStore(Good idGood, Store idStore);
}
