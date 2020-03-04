package co.za.bank.balance.and.dispensing.system.bankbalanceanddispensingsystem.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CURRENCY_CONVERSION_RATE")
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
    private String rate;

}
