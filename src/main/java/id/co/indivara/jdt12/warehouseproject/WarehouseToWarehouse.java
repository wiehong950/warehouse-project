package id.co.indivara.jdt12.warehouseproject;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "delivery")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WarehouseToWarehouse {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_warehouse")
    private Integer transId;
    @Column(name = "warehouse_src")
    private String warehouseSrc;
    @Column(name = "store_dst")
    private String warehouseDst;
    @Column(name = "id_goods")
    private Integer idGoods;
    @Column(name = "amounts_goods")
    private Integer amountsGoods;
}
