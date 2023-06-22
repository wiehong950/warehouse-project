package id.co.indivara.jdt12.warehouseproject.repository;

import id.co.indivara.jdt12.warehouseproject.entity.StoreInventory;
import id.co.indivara.jdt12.warehouseproject.entity.master.Good;
import id.co.indivara.jdt12.warehouseproject.entity.master.Store;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface StoreInventoryRepository extends JpaRepository<StoreInventory, Long> {
    StoreInventory findByIdGoodAndIdStore(Good idGood, Store idStore);

    List<StoreInventory> findByIdGood(Good idGood);

    List<StoreInventory> findByIdStore(Store store);

//    List<StoreInventory> findByStoreCode(Store store);
}
