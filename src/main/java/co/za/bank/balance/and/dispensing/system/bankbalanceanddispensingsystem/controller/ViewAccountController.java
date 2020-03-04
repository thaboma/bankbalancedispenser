package co.za.bank.balance.and.dispensing.system.bankbalanceanddispensingsystem.controller;


import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.za.bank.balance.and.dispensing.system.bankbalanceanddispensingsystem.services.AccountBalanceService;

@RestController
@RequestMapping("api/v1/view")
public class ViewAccountController {

    @Autowired
    private AccountBalanceService accountBalanceService;

    @GetMapping("/get_transactional_account_balances")
    public List<?> getTransactionalAccountBalances(@PathVariable String id, Instant instant  ){       
    	return accountBalanceService.getTransactionalAccountBalances();    	
    }
    
    @GetMapping("/get_currency_account_balances")
    public List<?> getCurrencyAccountBalances(@PathVariable String id, Instant instant  ){       
    	return accountBalanceService.getCurrencyAccountBalances();    	
    }
}
