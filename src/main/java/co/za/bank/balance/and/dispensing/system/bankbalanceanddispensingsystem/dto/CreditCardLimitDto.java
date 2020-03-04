package co.za.bank.balance.and.dispensing.system.bankbalanceanddispensingsystem.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreditCardLimitDto extends Dto {

    /**
	 * 
	 */
	private static final long serialVersionUID = 191166219898742382L;

	@JsonProperty("clientAccount")
    ClientAccountDto clientAccount;

	@JsonProperty("accountLimit")
    private Double accountLimit;

}
