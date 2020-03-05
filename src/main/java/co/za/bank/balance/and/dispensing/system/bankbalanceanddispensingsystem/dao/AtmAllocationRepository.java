package co.za.bank.balance.and.dispensing.system.bankbalanceanddispensingsystem.dao;

import co.za.bank.balance.and.dispensing.system.bankbalanceanddispensingsystem.entities.AtmAllocationEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtmAllocationRepository extends JpaRepository<AtmAllocationEntity, String> {
}
