package co.za.bank.balance.and.dispensing.system.bankbalanceanddispensingsystem.controller;


import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.za.bank.balance.and.dispensing.system.bankbalanceanddispensingsystem.dto.ClientCurAccBalResponceDto;
import co.za.bank.balance.and.dispensing.system.bankbalanceanddispensingsystem.dto.ClientTransBalResponceDto;
import co.za.bank.balance.and.dispensing.system.bankbalanceanddispensingsystem.exceptions.NoAccountFoundException;
import co.za.bank.balance.and.dispensing.system.bankbalanceanddispensingsystem.services.ViewAccountService;

@RestController
@RequestMapping("api/v1/view")
public class ViewAccountController {

    @Autowired
    private ViewAccountService viewAccountService;

    @GetMapping("/get_transactional_account_balances/{id}/")
    public List<ClientTransBalResponceDto> getTransactionalAccountBalances(@PathVariable String id,Instant instant) throws NoAccountFoundException{       

    	List<ClientTransBalResponceDto> clientTransBalResponceDtos;      	
      	try {
      		clientTransBalResponceDtos=viewAccountService.getTransactionalAccountBalances(id ,instant);  
      	} catch (Exception e) {
      		throw new NoAccountFoundException("Oops something went wrong please try again later");
      	}
      	  return clientTransBalResponceDtos;     
        }
 
    
    @GetMapping("/get_currency_account_balances/{id}")
    public List<ClientCurAccBalResponceDto> getCurrencyAccountBalances(@PathVariable String id,Instant instant) throws NoAccountFoundException{       

    	List<ClientCurAccBalResponceDto> clientCurAccBalResponceDtos;
  	
  	try {
  		clientCurAccBalResponceDtos=viewAccountService.getCurrencyAccountBalances(id,instant); 
  	} catch (Exception e) {
  		throw new NoAccountFoundException("Oops something went wrong please try again later");
  	}
		return clientCurAccBalResponceDtos;
	}
}
