package id.co.indivara.jdt12.warehouseproject.repository;

import id.co.indivara.jdt12.warehouseproject.entity.WarehouseToWarehouse;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
@Transactional
public interface WarehouseToWarehouseRepository extends JpaRepository<WarehouseToWarehouse, String> {

}
