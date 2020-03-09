package co.za.bank.balance.and.dispensing.system.bankbalanceanddispensingsystem.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "CURRENCY")
@NamedQuery(name = "CurrencyEntity.findRateByCurrencyCode", query = "SELECT c FROM CurrencyEntity c WHERE c.currencyCode = :currencyCode")

public class CurrencyEntity implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = -9116550696002531390L;

	@Id
    @Column(name = "CURRENCY_CODE")
    private String currencyCode;

    @Column(name = "DECIMAL_PLACES")
    private int decimalPlaces;

    @Column(name = "DESCRIPTION")
    private String description;

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public int getDecimalPlaces() {
		return decimalPlaces;
	}

	public void setDecimalPlaces(int decimalPlaces) {
		this.decimalPlaces = decimalPlaces;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
    
    
}
