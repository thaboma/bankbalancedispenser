package co.za.bank.balance.and.dispensing.system.bankbalanceanddispensingsystem.entities;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DENOMINATION_TYPE")
@Getter
@Setter
public class DenominationTypeEntity {

    @Id
    @Column(name = "DENOMINATION_TYPE_CODE")
    private String denominationTypeCode;

    @Column(name = "DESCRIPTION")
    private String description;

	@Override
	public String toString() {
		return "DenominationTypeEntity [denominationTypeCode=" + denominationTypeCode + ", description=" + description
				+ "]";
	}

	public String getDenominationTypeCode() {
		return denominationTypeCode;
	}

	public void setDenominationTypeCode(String denominationTypeCode) {
		this.denominationTypeCode = denominationTypeCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}	
    
    
}
