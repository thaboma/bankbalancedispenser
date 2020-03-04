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

@Entity
@Table(name = "DENOMINATION")
@Setter
@Getter
public class DenominationEntity {

    @Id
    @Column(name = "DENOMINATION_ID")
    private int denominationId;    
    
    @Column(name = "VALUE")
    private int value;
    
    @OneToOne(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name="DENOMINATION_TYPE") 
    DenominationTypeEntity denominationTypeEntity;

}
