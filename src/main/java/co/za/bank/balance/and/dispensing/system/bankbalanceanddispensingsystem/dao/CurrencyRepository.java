package co.za.bank.balance.and.dispensing.system.bankbalanceanddispensingsystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.za.bank.balance.and.dispensing.system.bankbalanceanddispensingsystem.entities.CurrencyEntity;

@Repository
public interface CurrencyRepository extends JpaRepository<CurrencyEntity, String> {
	public default   CurrencyEntity findRateByCurrencyCode(String id) {
		 return  findRateByCurrencyCode(id); 
	}
	
}
