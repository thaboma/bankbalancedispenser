package co.za.bank.balance.and.dispensing.system.bankbalanceanddispensingsystem.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "CURRENCY_CONVERSION_RATE")

@NamedQueries({
		@NamedQuery(name = "CurrencyConversionRateEntity.findZarRate", query = "SELECT a FROM CurrencyConversionRateEntity a WHERE a.currencyCode = 'ZAR'"),
		@NamedQuery(name = "CurrencyConversionRateEntity.findByRateByCurrencyCode", query = "SELECT c FROM CurrencyConversionRateEntity c WHERE c.currencyCode = :currencyCode")

})

@Getter
 @Setter
public class CurrencyConversionRateEntity  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2378508650555080536L;

	@Id   
	@OneToOne(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name="CURRENCY_CODE") 
    CurrencyEntity currency;

    @Column(name = "CONVERSION_INDICATOR")
    private String conversionIndicator;

    @Column(name = "RATE")
    private Double rate;

	public CurrencyEntity getCurrency() {
		return currency;
	}

	public void setCurrency(CurrencyEntity currency) {
		this.currency = currency;
	}

	public String getConversionIndicator() {
		return conversionIndicator;
	}

	public void setConversionIndicator(String conversionIndicator) {
		this.conversionIndicator = conversionIndicator;
	}

	public Double getRate() {
		return rate;
	}

	public void setRate(Double rate) {
		this.rate = rate;
	}

    
}
