package id.co.indivara.jdt12.warehouseproject.repository;

import id.co.indivara.jdt12.warehouseproject.entity.master.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WarehouseRepository extends JpaRepository<Warehouse,Integer> {
}
