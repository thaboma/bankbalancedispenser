package co.za.bank.balance.and.dispensing.system.bankbalanceanddispensingsystem.services;

import org.springframework.stereotype.Service;

import co.za.bank.balance.and.dispensing.system.bankbalanceanddispensingsystem.dto.AtmRequestDto;

@Service
public interface CashWithdrawalService {
	
     void getCash(AtmRequestDto atmRequestDto);

}
