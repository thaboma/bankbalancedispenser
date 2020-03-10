package co.za.bank.balance.and.dispensing.system.bankbalanceanddispensingsystem.entities;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "DENOMINATION")
@Setter
@Getter
public class DenominationEntity {

    @Id
    @Column(name = "DENOMINATION_ID")
    private int denominationId;    
    
    @Column(name = "VALUE")
    private BigDecimal value;
    
    @ManyToOne(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name="DENOMINATION_TYPE_CODE") 
    DenominationTypeEntity denominationType;

	public int getDenominationId() {
		return denominationId;
	}

	public void setDenominationId(int denominationId) {
		this.denominationId = denominationId;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public DenominationTypeEntity getDenominationType() {
		return denominationType;
	}

	public void setDenominationType(DenominationTypeEntity denominationType) {
		this.denominationType = denominationType;
	}

	@Override
	public String toString() {
		return "DenominationEntity [denominationId=" + denominationId + ", value=" + value + ", denominationType="
				+ denominationType + "]";
	}

    
}
