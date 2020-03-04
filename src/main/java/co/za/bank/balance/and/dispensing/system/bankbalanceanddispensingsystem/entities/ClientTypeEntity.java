package co.za.bank.balance.and.dispensing.system.bankbalanceanddispensingsystem.entities;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "CLIENT_TYPE")
@Getter
@Setter
public class ClientTypeEntity implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 3126449412093920305L;

	@Id
    @Column(name = "CLIENT_TYPE_CODE")
    private String clientTypeCode;

    @Column(name = "DESCRIPTION")
    private String description;


//    @OneToMany(
//            cascade = CascadeType.ALL,
//            orphanRemoval = true,
//            fetch = FetchType.LAZY
//    )
//    @JoinColumn(name = "CLIENT_TYPE_CODE")
//    private List<ClientSubTypeEntity> clientSubTypeEntities = new ArrayList<>();
    
//    @OneToOne(cascade=CascadeType.ALL,mappedBy="clientTypeEntity")
//    ClientSubTypeEntity clientSubTypeEntity;
    
}
