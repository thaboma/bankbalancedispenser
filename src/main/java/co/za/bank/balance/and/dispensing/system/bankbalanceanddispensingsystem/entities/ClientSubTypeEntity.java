package co.za.bank.balance.and.dispensing.system.bankbalanceanddispensingsystem.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "CLIENT_SUB_TYPE")
@Getter
@Setter
public class ClientSubTypeEntity implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 191166219898742382L;

	@Id
    @Column(name = "CLIENT_SUB_TYPE_CODE")
    private String clientSubTypeCode;

    @Column(name = "DESCRIPTION")
    private String description;
    
    
    @OneToOne(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name="CLIENT_TYPE_CODE") 
    ClientTypeEntity clientTypeEntity;
}
