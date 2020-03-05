package co.za.bank.balance.and.dispensing.system.bankbalanceanddispensingsystem.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class ClientCurAccBalResponceDto extends Dto {
 
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5460471021291044364L;

	@JsonProperty("accountNo")
    private String accountNo;

	@JsonProperty("currency")
    private String currency;
	
	
	@JsonProperty("convertionRatio")
    private Double convertionRatio;
	 
	@JsonProperty("currencyBalance")
    private Double currencyBalance;
	
	@JsonProperty("zarAmount")
    private Double zarAmount;
	
	@JsonProperty("errorMessage")
    private Double errorMessage;


	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Double getConvertionRatio() {
		return convertionRatio;
	}

	public void setConvertionRatio(Double convertionRatio) {
		this.convertionRatio = convertionRatio;
	}

	public Double getCurrencyBalance() {
		return currencyBalance;
	}

	public void setCurrencyBalance(Double currencyBalance) {
		this.currencyBalance = currencyBalance;
	}

	public Double getZarAmount() {
		return zarAmount;
	}

	public void setZarAmount(Double zarAmount) {
		this.zarAmount = zarAmount;
	}
	
	

	public Double getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(Double errorMessage) {
		this.errorMessage = errorMessage;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((zarAmount == null) ? 0 : zarAmount.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClientCurAccBalResponceDto other = (ClientCurAccBalResponceDto) obj;
		if (zarAmount == null) {
			if (other.zarAmount != null)
				return false;
		} else if (!zarAmount.equals(other.zarAmount))
			return false;
		return true;
	}
	
	

}
