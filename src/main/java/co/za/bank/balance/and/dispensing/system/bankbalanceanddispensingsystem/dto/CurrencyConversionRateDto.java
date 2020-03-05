package co.za.bank.balance.and.dispensing.system.bankbalanceanddispensingsystem.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import co.za.bank.balance.and.dispensing.system.bankbalanceanddispensingsystem.entities.CurrencyEntity;
import lombok.Getter;
import lombok.Setter;
 
@Setter
@Getter
public class CurrencyConversionRateDto extends Dto {

	/**
	 * 
	 */
	private static final long serialVersionUID = -656641132042308074L;

	@JsonProperty("currency")
    CurrencyEntity currency ;

	@JsonProperty("conversionIndicator")
    private String conversionIndicator;
 
	@JsonProperty("rate")
    private String rate;

}
