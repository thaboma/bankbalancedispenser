package co.za.bank.balance.and.dispensing.system.bankbalanceanddispensingsystem.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//@IdClass(CurrencyEntity.class)
@Entity
@Table(name = "CURRENCY_CONVERSION_RATE")
//@NamedQueries({
//		@NamedQuery(name = "CurrencyConversionRateEntity.findZarRate", query = "SELECT a FROM CurrencyConversionRateEntity a WHERE a.currency.currencyCode = 'ZAR'"),
//		@NamedQuery(name = "CurrencyConversionRateEntity.findRateByCurrencyCode", query = "SELECT c FROM CurrencyConversionRateEntity c WHERE c.currency.currencyCode = :currencyCode")
//
//})
public class CurrencyConversionRateEntity  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2378508650555080530L;

 
	
	@Id
    @Column(name = "CURRENCY_CODE")
    private String currencyCode;

	  
//	@OneToOne(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
//    @JoinColumn(name="CURRENCY_CODE") 
//    CurrencyEntity currency;

    @Column(name = "CONVERSION_INDICATOR")
    private String conversionIndicator;

    @Column(name = "RATE")
    private BigDecimal rate;


	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public String getConversionIndicator() {
		return conversionIndicator;
	}

	public void setConversionIndicator(String conversionIndicator) {
		this.conversionIndicator = conversionIndicator;
	}

	public BigDecimal getRate() {
		return rate;
	}

	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}

	

    
}
