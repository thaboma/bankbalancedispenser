package co.za.bank.balance.and.dispensing.system.bankbalanceanddispensingsystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtmRepository extends JpaRepository<AtmAllocationRepository, String> {
}
