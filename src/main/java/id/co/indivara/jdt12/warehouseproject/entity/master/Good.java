package id.co.indivara.jdt12.warehouseproject.entity.master;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "goods")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Good {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_goods")
    private Integer idGood;

    @Column(name = "name_good")
    private String nameGood;

    @Column(name = "desc_good")
    private String descGood;
}
