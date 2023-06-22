package id.co.indivara.jdt12.warehouseproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import id.co.indivara.jdt12.warehouseproject.entity.master.Good;
import id.co.indivara.jdt12.warehouseproject.entity.master.Warehouse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "supplies")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SupplyToWarehouse {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "wtw_generator")
    @Column(name = "trans_id")
    private Long transId;

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
