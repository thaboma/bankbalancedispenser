package co.za.bank.balance.and.dispensing.system.bankbalanceanddispensingsystem.dao;

import co.za.bank.balance.and.dispensing.system.bankbalanceanddispensingsystem.entities.ClientTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientTypeRepository extends JpaRepository<ClientTypeEntity, String> {
}
