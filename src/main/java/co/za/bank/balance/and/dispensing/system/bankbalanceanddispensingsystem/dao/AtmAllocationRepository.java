package co.za.bank.balance.and.dispensing.system.bankbalanceanddispensingsystem.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.za.bank.balance.and.dispensing.system.bankbalanceanddispensingsystem.entities.AtmAllocationEntity;

@Repository
public interface AtmAllocationRepository extends JpaRepository<AtmAllocationEntity, String> {
	//List<AtmAllocationEntity> findByAtmAllocationId(Integer atmAllocationId);
	List<AtmAllocationEntity> findByAtmAtmId(Integer atmIdAtmId);
	//List<AtmAllocationEntity> findByAtmAllocationIdAndDenominationTypeCode(Integer atmAllocationId,String denominationTypeCode);
}
