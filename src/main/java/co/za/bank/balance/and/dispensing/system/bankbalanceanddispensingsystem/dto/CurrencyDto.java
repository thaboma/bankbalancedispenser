package co.za.bank.balance.and.dispensing.system.bankbalanceanddispensingsystem.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CurrencyDto extends Dto {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6359444820588550341L;

	@JsonProperty("currencyCode")
    private String currencyCode;

	@JsonProperty("decimalPlaces")
    private int decimalPlaces;

	@JsonProperty("description")
    private String description;
}
