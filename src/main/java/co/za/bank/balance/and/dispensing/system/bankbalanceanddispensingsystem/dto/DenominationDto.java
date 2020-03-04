package co.za.bank.balance.and.dispensing.system.bankbalanceanddispensingsystem.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DENOMINATION")
@Setter
@Getter
public class DenominationDto {

    @Id
    @Column(name = "DENOMINATION_ID")
    private int denominationId;

}
