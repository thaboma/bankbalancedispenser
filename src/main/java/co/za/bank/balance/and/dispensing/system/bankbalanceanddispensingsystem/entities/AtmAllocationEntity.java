package co.za.bank.balance.and.dispensing.system.bankbalanceanddispensingsystem.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
	
//	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
//	@JoinColumn(name = "ATM_ID")
//	private List<AtmEntity> atms = new ArrayList<>();
//
//	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
//	@JoinColumn(name = "DENOMINATION_ID")
//	private List<DenominationEntity> denaminations = new ArrayList<>();

    @Column(name = "COUNT")
    private int  count ;

	public Integer getAtmAllocationId() {
		return atmAllocationId;
	}

	public void setAtmAllocationId(Integer atmAllocationId) {
		this.atmAllocationId = atmAllocationId;
	}

//	public List<AtmEntity> getAtms() {
//		return atms;
//	}
//
//	public void setAtms(List<AtmEntity> atms) {
//		this.atms = atms;
//	}
//
//	public List<DenominationEntity> getDenaminations() {
//		return denaminations;
//	}
//
//	public void setDenaminations(List<DenominationEntity> denaminations) {
//		this.denaminations = denaminations;
//	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	} 

    

}
