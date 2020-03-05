package co.za.bank.balance.and.dispensing.system.bankbalanceanddispensingsystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.za.bank.balance.and.dispensing.system.bankbalanceanddispensingsystem.entities.CreditCardLimitEntity;

@Repository
public interface CreditCardLimitRepository extends JpaRepository<CreditCardLimitEntity, String> {
}
