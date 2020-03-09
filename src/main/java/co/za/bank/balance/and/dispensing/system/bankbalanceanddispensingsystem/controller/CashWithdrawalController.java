package co.za.bank.balance.and.dispensing.system.bankbalanceanddispensingsystem.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.za.bank.balance.and.dispensing.system.bankbalanceanddispensingsystem.dto.AtmRequestDto;
import co.za.bank.balance.and.dispensing.system.bankbalanceanddispensingsystem.servicesimpl.CashWithdrawalServiceImpl;

@RestController
@RequestMapping("api/v1/withdrawal")
public class CashWithdrawalController {

    @Autowired
    private CashWithdrawalServiceImpl cashWithdrawalService;

    @PostMapping("/get_cash/{atmRequestDto}")
    public void getCash(@RequestBody AtmRequestDto atmRequestDto){       
    	 cashWithdrawalService.getCash(atmRequestDto);    	
    }
    
 
}
