package co.za.bank.balance.and.dispensing.system.bankbalanceanddispensingsystem.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CURRENCY")
public class CurrencyDto {

    @Id
    @Column(name = "CURRENCY_CODE")
    private String currencyCode;

    @Column(name = "DECIMAL_PLACES")
    private int decimalPlaces;

    @Column(name = "DESCRIPTION")
    private String description;
}
