package co.za.bank.balance.and.dispensing.system.bankbalanceanddispensingsystem.services;

import co.za.bank.balance.and.dispensing.system.bankbalanceanddispensingsystem.dto.AtmRequestDto;

public interface CashWithdrawalService {
	
    public void getCash(AtmRequestDto atmRequestDto);
    
    //public List<? extends Object> getCurrencyAccountBalances();

}
