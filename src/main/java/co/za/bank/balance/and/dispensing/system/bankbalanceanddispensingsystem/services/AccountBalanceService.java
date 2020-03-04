package co.za.bank.balance.and.dispensing.system.bankbalanceanddispensingsystem.services;

import java.util.List;

public interface AccountBalanceService {
	
    public List<? extends Object> getTransactionalAccountBalances();
    
    public List<? extends Object> getCurrencyAccountBalances();

}
