package co.za.bank.balance.and.dispensing.system.bankbalanceanddispensingsystem.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.za.bank.balance.and.dispensing.system.bankbalanceanddispensingsystem.dto.AtmRequestDto;
import co.za.bank.balance.and.dispensing.system.bankbalanceanddispensingsystem.dto.DenominationCounterDto;
import co.za.bank.balance.and.dispensing.system.bankbalanceanddispensingsystem.exceptions.AtmExceptionException;
import co.za.bank.balance.and.dispensing.system.bankbalanceanddispensingsystem.exceptions.InsufficientFundsException;
import co.za.bank.balance.and.dispensing.system.bankbalanceanddispensingsystem.servicesimpl.CashWithdrawalServiceImpl;

@RestController
@RequestMapping("api/v1/withdrawal")
public class CashWithdrawalController {

    @Autowired
    private CashWithdrawalServiceImpl cashWithdrawalService;


  @PostMapping("/dispenseCash/{atmRequestDto}")
  public  List<DenominationCounterDto>  dispenseCash(@RequestBody AtmRequestDto atmRequestDton) throws InsufficientFundsException, AtmExceptionException{       
	  List<DenominationCounterDto> denominationCount;	
	try {
		denominationCount = cashWithdrawalService.dispenseCash(atmRequestDton);
	} catch (Exception e) {
		
		if (e instanceof InsufficientFundsException || e instanceof AtmExceptionException ) {
			throw e;
		}else {
		throw new AtmExceptionException("Oops something went wrong please try again later");
		}
	}
		return denominationCount;

	}
 
}
