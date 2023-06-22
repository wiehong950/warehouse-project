package id.co.indivara.jdt12.warehouseproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import id.co.indivara.jdt12.warehouseproject.entity.master.Good;
import id.co.indivara.jdt12.warehouseproject.entity.master.Store;
import id.co.indivara.jdt12.warehouseproject.entity.master.Warehouse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "delivery")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WarehouseToStore {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "wts_generator")
    @Column(name = "transId")
    private Long transId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "warehouse_src")
    @JsonIgnore
    private Warehouse warehouseSrc;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_dst")
    @JsonIgnore
    private Store storeDst;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_goods")
    @JsonIgnore
    private Good idGoods;

    @Column(name = "amounts_goods")
    private Integer amountsGoods;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist(){
        this.createdAt = LocalDateTime.now();
    }

}
