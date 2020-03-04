package co.za.bank.balance.and.dispensing.system.bankbalanceanddispensingsystem.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.za.bank.balance.and.dispensing.system.bankbalanceanddispensingsystem.dto.AtmRequestDto;
import co.za.bank.balance.and.dispensing.system.bankbalanceanddispensingsystem.services.CashWithdrawalService;

@RestController
@RequestMapping("api/v1/withdrawall")
public class CashWithdrawalController {

    @Autowired
    private CashWithdrawalService cashWithdrawalService;

    @GetMapping("/get_cash")
    public void getCash(@PathVariable AtmRequestDto atmRequestDto){       
    	 cashWithdrawalService.getCash(atmRequestDto);    	
    }
    
 
}
