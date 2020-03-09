package co.za.bank.balance.and.dispensing.system.bankbalanceanddispensingsystem.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "CREDIT_CARD_LIMIT")
@Getter
@Setter
public class CreditCardLimitEntity implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 191166219898742382L;

//	@Id
//    @OneToOne(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
//    @JoinColumn(name="CLIENT_ACCOUNT_NUMBER") 
//    ClientAccountEntity clientAccount;
	
	@Id
	@Column(name = "CLIENT_ACCOUNT_NUMBER")
	private String clientAccNo;

    @Column(name = "ACCOUNT_LIMIT")
    private BigDecimal accountLimit;

    
//	public ClientAccountEntity getClientAccount() {
//		return clientAccount;
//	}
//
//	public void setClientAccount(ClientAccountEntity clientAccount) {
//		this.clientAccount = clientAccount;
//	}

	public String getClientAccNo() {
		return clientAccNo;
	}

	public void setClientAccNo(String clientAccNo) {
		this.clientAccNo = clientAccNo;
	}

	public BigDecimal getAccountLimit() {
		return accountLimit;
	}

	public void setAccountLimit(BigDecimal accountLimit) {
		this.accountLimit = accountLimit;
	}
    
    

}
