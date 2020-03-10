package co.za.bank.balance.and.dispensing.system.bankbalanceanddispensingsystem.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

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

	@Override
	public String toString() {
		return "AtmDto [atmId=" + atmId + ", name=" + name + ", location=" + location + "]";
	}


}
