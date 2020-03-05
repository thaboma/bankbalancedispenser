package co.za.bank.balance.and.dispensing.system.bankbalanceanddispensingsystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.za.bank.balance.and.dispensing.system.bankbalanceanddispensingsystem.entities.CurrencyConversionRateEntity;

@Repository
public interface CurrencyConversionRepository extends JpaRepository<CurrencyConversionRateEntity, String> {
	public default  CurrencyConversionRateEntity findByRateByCurrencyCode(String currencyCode) {
		 return  findByRateByCurrencyCode(currencyCode); 
	}
	
	public default  CurrencyConversionRateEntity findZarRate() {
		 return  findZarRate(); 
	}
	
	
}
