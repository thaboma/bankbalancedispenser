package co.za.bank.balance.and.dispensing.system.bankbalanceanddispensingsystem.services;

import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface AccountBalanceService {
	
    List<? extends Object> getTransactionalAccountBalances();
    
    List<? extends Object> getCurrencyAccountBalances();

}
