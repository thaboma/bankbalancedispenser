package co.za.bank.balance.and.dispensing.system.bankbalanceanddispensingsystem.entities;

import java.io.Serializable;

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
@Table(name = "ATM_ALLOCATION")
@Getter
@Setter
public class AtmAllocationEntity implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -499636923540664087L;

	@Id
    @Column(name = "ATM_ALLOCATION_ID")
    private Integer  atmAllocationId;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "ATM_ID")
	private AtmEntity atm;

	@ManyToOne(cascade = CascadeType.ALL,  fetch = FetchType.LAZY)
	@JoinColumn(name = "DENOMINATION_ID")
	private DenominationEntity denomination;

    @Column(name = "COUNT")
    private int  count ;

	public Integer getAtmAllocationId() {
		return atmAllocationId;
	}

	public void setAtmAllocationId(Integer atmAllocationId) {
		this.atmAllocationId = atmAllocationId;
	}
	
	public int getCount() {
		return count;
	}

	public AtmEntity getAtm() {
		return atm;
	}

	public void setAtm(AtmEntity atm) {
		this.atm = atm;
	}

	public DenominationEntity getDenomination() {
		return denomination;
	}

	public void setDenamination(DenominationEntity denamination) {
		this.denomination = denamination;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "AtmAllocationEntity [atmAllocationId=" + atmAllocationId + ", \r\natm=" + atm.toString() + ", \r\ndenomination="
				+ denomination.toString() + "], \r\ncount=" + count + "]";
	}

 

    

}
