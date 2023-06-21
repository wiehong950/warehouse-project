package id.co.indivara.jdt12.warehouseproject.entity.master;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private Integer idStore;
    @Column(name = "store_code")
    private String storeCode;
    @Column(name = "name_store")
    private String nameStore;
    @Column(name = "address_store")
    private String addressStore;
    @Column(name = "email_store")
    private String emailStore;
    @Column(name = "phone_number_store")
    private String phoneNumberStore;

}
