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
@Table(name = "goods")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Good {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_goods")
    private Long idGood;

    @Column(name = "name_goods")
    private String nameGood;

    @Column(name = "desc_goods")
    private String descGood;

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "goods_generator")
    @GenericGenerator(
            name = "goods_generator",
            strategy = "id.co.indivara.jdt12.warehouseproject.sequence.StringPrefixedSequenceIdGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "g"),
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d")
            }
    )
    @Column(name = "good_code")
    private String goodCode;
}
