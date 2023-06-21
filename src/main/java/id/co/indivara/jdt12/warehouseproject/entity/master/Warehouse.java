package id.co.indivara.jdt12.warehouseproject.entity.master;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "warehouses")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Warehouse {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_warehouse")
    private Integer idWarehouse;
    @Column(name = "name_warehouse")
    private String nameWarehouse;
    @Column(name = "address_warehouse")
    private String addressWarehouse;
    @Column(name = "phone_number_warehouse")
    private String phoneNumberWarehouse;
    @Column(name = "warehouse_code")
    private String warehouseCode;
}
