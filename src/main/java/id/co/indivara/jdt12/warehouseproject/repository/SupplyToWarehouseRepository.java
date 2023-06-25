package id.co.indivara.jdt12.warehouseproject.repository;

import id.co.indivara.jdt12.warehouseproject.entity.SupplyToWarehouse;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface SupplyToWarehouseRepository extends JpaRepository<SupplyToWarehouse, String> {
}
