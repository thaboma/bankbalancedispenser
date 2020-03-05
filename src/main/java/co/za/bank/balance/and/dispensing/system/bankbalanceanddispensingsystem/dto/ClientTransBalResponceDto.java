package co.za.bank.balance.and.dispensing.system.bankbalanceanddispensingsystem.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class ClientTransBalResponceDto extends Dto {
 
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5460471021291044364L;

	@JsonProperty("accountNo")
    private String accountNo;

	@JsonProperty("accType")
    private String accType;
	
	
	@JsonProperty("accBalance")
    private Double accBalance;
	
	@JsonProperty("errorMessage")
    private Double errorMessage;


	public String getAccountNo() {
		return accountNo;
	}


	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}


	public String getAccType() {
		return accType;
	}


	public void setAccType(String accType) {
		this.accType = accType;
	}


	public Double getAccBalance() {
		return accBalance;
	}


	public void setAccBalance(Double accBalance) {
		this.accBalance = accBalance;
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
		result = prime * result + ((accBalance == null) ? 0 : accBalance.hashCode());
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
		ClientTransBalResponceDto other = (ClientTransBalResponceDto) obj;
		if (accBalance == null) {
			if (other.accBalance != null)
				return false;
		} else if (!accBalance.equals(other.accBalance))
			return false;
		return true;
	}


 
	
	

}
