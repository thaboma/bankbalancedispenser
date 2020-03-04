package co.za.bank.balance.and.dispensing.system.bankbalanceanddispensingsystem.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class AccountTypeDto extends Dto {
	/**
	 * 
	 */
	private static final long serialVersionUID = 908673321575539322L;

	@JsonProperty("accountTypeCode")
    private String accountTypeCode;

	@JsonProperty("description")
    private String description;

	@JsonProperty("transactional")
    private byte transactional;


}
