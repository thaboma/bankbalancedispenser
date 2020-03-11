package co.za.bank.balance.and.dispensing.system.bankbalanceanddispensingsystem.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DenominationCounterDto {

    /**
	 * 
	 */
	private static final long serialVersionUID = -499636923540664080L;

	@JsonProperty("Denomination")
    private Integer denomination;

	@JsonProperty("Count")
    private Integer count;

	public Integer getDenomination() {
		return denomination;
	}

	public void setDenomination(Integer denomination) {
		this.denomination = denomination;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
 

}
