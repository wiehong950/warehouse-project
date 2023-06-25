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
@Table(name = "stores")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_store")
    private Long idStore;

    @Column(name = "name_store")
    private String nameStore;

    @Column(name = "address_store")
    private String addressStore;

    @Column(name = "email_store")
    private String emailStore;

    @Column(name = "phone_number_store")
    private String phoneNumberStore;

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "store_generator")
    @GenericGenerator(
            name = "store_generator",
            strategy = "id.co.indivara.jdt12.warehouseproject.sequence.StringPrefixedSequenceIdGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "st"),
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d")
            }
    )
    @Column(name = "store_code", unique = true)
    private String storeCode;

}
