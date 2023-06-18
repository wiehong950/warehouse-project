package id.co.indivara.jdt12.warehouseproject.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "warehouse_inventory")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WarehouseInventory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_goods")
    private Integer idGoods;
    @Column(name = "id_warehouse")
    private Integer idWarehouse;
    @Column(name = "warehouse_stock")
    private Integer warehouseStock;
}
