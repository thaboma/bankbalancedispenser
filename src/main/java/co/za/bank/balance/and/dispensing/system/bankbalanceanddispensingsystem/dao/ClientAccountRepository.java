package co.za.bank.balance.and.dispensing.system.bankbalanceanddispensingsystem.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.za.bank.balance.and.dispensing.system.bankbalanceanddispensingsystem.entities.ClientAccountEntity;

@Repository
public interface ClientAccountRepository extends JpaRepository<ClientAccountEntity, String> {

	List<ClientAccountEntity> findByClientId(Integer clientId);
	  
}

 
