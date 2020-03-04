package co.za.bank.balance.and.dispensing.system.bankbalanceanddispensingsystem.dto;

import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class AtmRequestDto extends Dto {
    /**
	 * 
	 */
	private static final long serialVersionUID = -499636923540664087L;

	@JsonProperty("clientId")
    private String clientId;

	@JsonProperty("accountNo")
    private String accountNo;

	@JsonProperty("requiredAmt")
    private String requiredAmt;
	
	
	@JsonProperty("instant")
    private Instant instant;	

}
