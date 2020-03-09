package co.za.bank.balance.and.dispensing.system.bankbalanceanddispensingsystem.services;

import java.time.Instant;
import java.util.List;

import org.springframework.stereotype.Service;

import co.za.bank.balance.and.dispensing.system.bankbalanceanddispensingsystem.dto.ClientCurAccBalResponceDto;
import co.za.bank.balance.and.dispensing.system.bankbalanceanddispensingsystem.dto.ClientTransBalResponceDto;
import co.za.bank.balance.and.dispensing.system.bankbalanceanddispensingsystem.exceptions.NoAccountFoundException;

@Service
public interface ViewAccountService {
	
	List<ClientTransBalResponceDto> getTransactionalAccountBalances(String id, Instant instant) throws NoAccountFoundException;
    
	List<ClientCurAccBalResponceDto>getCurrencyAccountBalances(String id, Instant instant) throws NoAccountFoundException;

}
