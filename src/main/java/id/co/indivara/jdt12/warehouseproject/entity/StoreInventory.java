package id.co.indivara.jdt12.warehouseproject.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "store_inventory")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StoreInventory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_goods")
    private Integer idGoods;
    @Column(name = "id_store")
    private Integer idStore;
    @Column(name = "store_stock")
    private Integer storeStock;

}
