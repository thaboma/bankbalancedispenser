package co.za.bank.balance.and.dispensing.system.bankbalanceanddispensingsystem.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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


    @OneToOne(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name="CLIENT_ACCOUNT_NUMBER") 
    ClientAccountEntity clientAccount;

    @Column(name = "ACCOUNT_LIMIT")
    private Double accountLimit;

}
