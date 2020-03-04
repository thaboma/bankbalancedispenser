package co.za.bank.balance.and.dispensing.system.bankbalanceanddispensingsystem.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientAccountDto extends Dto {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1322712122770818759L;

	@JsonProperty("clientAccNo")
	private String clientAccNo;

	@JsonProperty("clients")
	private List<ClientDto> clients = new ArrayList<>();

	@JsonProperty("accountTypes")
	private List<AccountTypeDto> accountTypes = new ArrayList<>();
 
	@JsonProperty("currencies")
	private List<CurrencyDto> currencies = new ArrayList<>();

	@JsonProperty("displayBalance")
	private Double displayBalance;

}
