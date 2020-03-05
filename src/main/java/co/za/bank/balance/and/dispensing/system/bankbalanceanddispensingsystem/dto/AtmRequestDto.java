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
    private Double requiredAmt;
	
	
	@JsonProperty("instant")
    private Instant instant;


	public String getClientId() {
		return clientId;
	}


	public void setClientId(String clientId) {
		this.clientId = clientId;
	}


	public String getAccountNo() {
		return accountNo;
	}


	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}


	public Double getRequiredAmt() {
		return requiredAmt;
	}


	public void setRequiredAmt(Double requiredAmt) {
		this.requiredAmt = requiredAmt;
	}


	public Instant getInstant() {
		return instant;
	}


	public void setInstant(Instant instant) {
		this.instant = instant;
	}	

	
	
}
