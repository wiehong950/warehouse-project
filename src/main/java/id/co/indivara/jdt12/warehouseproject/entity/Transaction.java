package id.co.indivara.jdt12.warehouseproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import id.co.indivara.jdt12.warehouseproject.entity.master.Good;
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
@Table(name = "transaction")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "alltrans_generator")
    @GenericGenerator(
            name = "alltrans_generator",
            strategy = "id.co.indivara.jdt12.warehouseproject.sequence.StringPrefixedSequenceIdGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "trx"),
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d")
            }
    )
    private String idTransaction;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_goods")
    @JsonIgnore
    private Good idGood;

    @Column(name = "amounts_goods")
    private Integer amountGoods;

    @Column(name = "id_by_trans_type")
    private String idByTransType;

    @Column(name = "trans_type")
    private String transType;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist(){
        this.createdAt = LocalDateTime.now();
    }

}

//*id histori		== auto generated
//*id akun		    == id akun
//*id transaksi		== id transaksi
//*no rekening		== mstakun.get(norekening)
//*jumlah transaksi	== jumlah yang akan di setor(input dari request)
//*type transaksi ?	==
