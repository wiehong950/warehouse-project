package id.co.indivara.jdt12.warehouseproject.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idTransaction;
    private String transType;
    private Integer idGoods;

    public enum transactionType{
        WAREHOUSETOWAREHOUSE,
        WAREHOUSETOSTORE,
        SUPPLYTOWAREHOUSE
    }
}
