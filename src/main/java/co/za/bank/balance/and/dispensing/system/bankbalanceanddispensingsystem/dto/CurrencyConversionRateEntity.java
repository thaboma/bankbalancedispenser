package co.za.bank.balance.and.dispensing.system.bankbalanceanddispensingsystem.dto;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import co.za.bank.balance.and.dispensing.system.bankbalanceanddispensingsystem.entities.CurrencyEntity;

@Entity
@Table(name = "CURRENCY_CONVERSION_RATE")
public class CurrencyConversionRateEntity extends Dto {

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
