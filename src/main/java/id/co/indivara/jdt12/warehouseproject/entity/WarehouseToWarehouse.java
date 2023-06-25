package id.co.indivara.jdt12.warehouseproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import id.co.indivara.jdt12.warehouseproject.entity.master.Good;
import id.co.indivara.jdt12.warehouseproject.entity.master.Warehouse;
import id.co.indivara.jdt12.warehouseproject.sequence.StringPrefixedSequenceIdGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "transfer")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WarehouseToWarehouse {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "wtw_generator")
    @GenericGenerator(
            name = "wtw_generator",
            strategy = "id.co.indivara.jdt12.warehouseproject.sequence.StringPrefixedSequenceIdGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "wtw"),
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d")
            }
    )
    @Column(name = "transId")
    private String transId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "warehouse_src")
    @JsonIgnore
    private Warehouse warehouseSrc;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "warehouse_dst")
    @JsonIgnore
    private Warehouse warehouseDst;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_goods")
    @JsonIgnore
    private Good idGood;

    @Column(name = "amounts_goods")
    private Integer amountsGoods;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist(){
        this.createdAt = LocalDateTime.now();
    }
}
