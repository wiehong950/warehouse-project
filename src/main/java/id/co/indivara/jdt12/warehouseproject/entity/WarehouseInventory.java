package id.co.indivara.jdt12.warehouseproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import id.co.indivara.jdt12.warehouseproject.entity.master.Good;
import id.co.indivara.jdt12.warehouseproject.entity.master.Warehouse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "warehouse_inventory")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WarehouseInventory {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "warehouse_inven_generator")
    @Column(name = "id_inventory")
    private Long idInventory;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_goods")
    @JsonIgnore
    private Good idGood;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_warehouse")
    @JsonIgnore
    private Warehouse idWarehouse;

    @Column(name = "warehouse_stock")
    private Integer warehouseStock;
}
