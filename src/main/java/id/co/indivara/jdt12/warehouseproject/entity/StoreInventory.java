package id.co.indivara.jdt12.warehouseproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import id.co.indivara.jdt12.warehouseproject.entity.master.Good;
import id.co.indivara.jdt12.warehouseproject.entity.master.Store;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "store_inventory")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StoreInventory {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "inventory_store_generator")
    @Column(name = "id_inventory")
    private Long idInventory;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_goods")
    @JsonIgnore
    private Good idGood;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_store")
    @JsonIgnore
    private Store idStore;

    @Column(name = "store_stock")
    private Integer storeStock;

}
