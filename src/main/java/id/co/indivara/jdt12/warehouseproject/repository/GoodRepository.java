package id.co.indivara.jdt12.warehouseproject.repository;

import id.co.indivara.jdt12.warehouseproject.entity.master.Good;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface GoodRepository extends JpaRepository<Good, Long> {

}
