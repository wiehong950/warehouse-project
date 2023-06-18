package id.co.indivara.jdt12.warehouseproject.entity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.math.BigDecimal;
import java.util.Date;

@MappedSuperclass               // untuk semua entity memakai table dalam class ini, jadi memakai annotation ini
public class BaseEntity {
    @Column(name = "created_date")
    private Date createdDate;
    @Column(name = "created_by")
    private Date createdBy;
    @Column(name = "last_updated_date")
    private Date lastUpdatedDate;
    @Column(name = "last_updated_by")
    private Date lastUpdatedBy;
    @Column(name = "status_number")
    private BigDecimal statusNumber;
}
