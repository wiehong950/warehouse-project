package id.co.indivara.jdt12.warehouseproject.entity.master;

import id.co.indivara.jdt12.warehouseproject.sequence.StringPrefixedSequenceIdGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

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
    private Long idWarehouse;

    @Column(name = "name_warehouse")
    private String nameWarehouse;

    @Column(name = "address_warehouse")
    private String addressWarehouse;

    @Column(name = "phone_number_warehouse")
    private String phoneNumberWarehouse;

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "warehouse_generator")
    @GenericGenerator(
            name = "warehouse_generator",
            strategy = "id.co.indivara.jdt12.warehouseproject.sequence.StringPrefixedSequenceIdGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "wh"),
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d")
            }
    )
    @Column(name = "warehouse_code", unique = true)
    private String warehouseCode;
}
