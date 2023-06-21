package id.co.indivara.jdt12.warehouseproject.repository;

import id.co.indivara.jdt12.warehouseproject.entity.WarehouseToStore;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface WarehouseToStoreRepository extends JpaRepository<WarehouseToStore, Integer> {
}
