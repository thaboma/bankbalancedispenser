package co.za.bank.balance.and.dispensing.system.bankbalanceanddispensingsystem.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.za.bank.balance.and.dispensing.system.bankbalanceanddispensingsystem.dao.ClientAccountRepository;
import co.za.bank.balance.and.dispensing.system.bankbalanceanddispensingsystem.dto.AtmRequestDto;
import co.za.bank.balance.and.dispensing.system.bankbalanceanddispensingsystem.entities.ClientAccountEntity;
import co.za.bank.balance.and.dispensing.system.bankbalanceanddispensingsystem.services.CashWithdrawalService;

@Component
public class CashWithdrawalServiceImpl implements CashWithdrawalService{

    
    @Autowired
    private ClientAccountRepository clientAccountRepository;
    
	@Override
	public void getCash(AtmRequestDto atmRequestDto) {

		 List<ClientAccountEntity> clientAccountEntities = clientAccountRepository.findByClientId(Integer.parseInt(atmRequestDto.getClientId()));
	 	/**
	 	 *  I was meant to transform the entities to Dtos ,didn't have enough time to complete that 
	 	 */
	
		//clientAccountEntities.stream().sorted().forEach(acc ->{
			clientAccountEntities.stream().forEach(acc ->{
			if (acc.getClientAccNo().equals(atmRequestDto.getAccountNo())) {
//				if (acc.getDisplayBalance().compareTo(atmRequestDto.getRequiredAmt())) {
//					
//					//TO DO....
//				}
			}			
		});
	}

}
