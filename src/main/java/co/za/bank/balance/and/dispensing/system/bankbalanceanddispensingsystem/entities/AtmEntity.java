package co.za.bank.balance.and.dispensing.system.bankbalanceanddispensingsystem.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
@Entity
@Table(name = "ATM")
@Getter
@Setter
public class AtmEntity implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -499636923540664087L;

	@Id
    @Column(name = "ATM_ID")
    private Integer  atmId;

    @Column(name = "NAME")
    private String name;

    @Column(name = "LOCATION")
    private String location;

	@Override
	public String toString() {
		return "AtmEntity [atmId=" + atmId + ", name=" + name + ", location=" + location + "]";
	}


}
