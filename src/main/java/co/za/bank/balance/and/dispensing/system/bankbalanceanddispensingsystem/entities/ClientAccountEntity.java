package co.za.bank.balance.and.dispensing.system.bankbalanceanddispensingsystem.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "ACCOUNT_ACCOUNT")
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

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	@JoinColumn(name = "CLIENT_ID")
	private List<ClientEntity> clients = new ArrayList<>();

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	@JoinColumn(name = "ACCOUNT_TYPE_CODE")
	private List<AccountTypeEntity> accountTypes = new ArrayList<>();

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	@JoinColumn(name = "CURRENCY_CODE")
	private List<CurrencyEntity> currencies = new ArrayList<>();

	@Column(name = "DISPLAY_BALANCE")
	private Double displayBalance;

}
