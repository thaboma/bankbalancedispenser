package co.za.bank.balance.and.dispensing.system.bankbalanceanddispensingsystem.dto;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
@Entity
@Table(name = "ATM")
@Getter
@Setter
public class AtmDto extends Dto {

    /**
	 * 
	 */
	private static final long serialVersionUID = -499636923540664087L;

	@JsonProperty("atmId")
    private Integer atmId;

	@JsonProperty("name")
    private String name;

	@JsonProperty("location")
    private String location;


}
