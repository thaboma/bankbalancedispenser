package co.za.bank.balance.and.dispensing.system.bankbalanceanddispensingsystem.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "CLIENT_ACCOUNT")
@NamedQuery(name = "ClientAccountEntity.findByClientId", query = "SELECT a FROM ClientAccountEntity a WHERE a.client.clientId = :clientId")

@Getter
@Setter
public class ClientAccountEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1322712122770818759L;

	@Id
	@Column(name = "CLIENT_ACCOUNT_NUMBER")
	private String clientAccNo;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "CLIENT_ID")
	private  ClientEntity client;

	@ManyToOne(cascade = CascadeType.ALL,   fetch = FetchType.LAZY)
	@JoinColumn(name = "ACCOUNT_TYPE_CODE")
	private  AccountTypeEntity  accountType;;

	@ManyToOne(cascade = CascadeType.ALL,   fetch = FetchType.LAZY)
	@JoinColumn(name = "CURRENCY_CODE")
	private  CurrencyEntity currency;
	

	@Column(name = "DISPLAY_BALANCE")
	private BigDecimal displayBalance;

	public String getClientAccNo() {
		return clientAccNo;
	}

	public void setClientAccNo(String clientAccNo) {
		this.clientAccNo = clientAccNo;
	}


	public ClientEntity getClient() {
		return client;
	}

	public void setClient(ClientEntity client) {
		this.client = client;
	}

	public AccountTypeEntity getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountTypeEntity accountType) {
		this.accountType = accountType;
	}

	public CurrencyEntity getCurrency() {
		return currency;
	}

	public void setCurrency(CurrencyEntity currency) {
		this.currency = currency;
	}

	public BigDecimal getDisplayBalance() {
		return displayBalance;
	}

	public void setDisplayBalance(BigDecimal displayBalance) {
		this.displayBalance = displayBalance;
	}	
	

}
