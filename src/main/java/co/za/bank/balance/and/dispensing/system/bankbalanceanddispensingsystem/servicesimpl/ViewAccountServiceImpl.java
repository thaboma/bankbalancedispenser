package co.za.bank.balance.and.dispensing.system.bankbalanceanddispensingsystem.servicesimpl;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import co.za.bank.balance.and.dispensing.system.bankbalanceanddispensingsystem.dao.ClientAccountRepository;
import co.za.bank.balance.and.dispensing.system.bankbalanceanddispensingsystem.dao.CurrencyConversionRepository;
import co.za.bank.balance.and.dispensing.system.bankbalanceanddispensingsystem.dto.ClientCurAccBalResponceDto;
import co.za.bank.balance.and.dispensing.system.bankbalanceanddispensingsystem.dto.ClientTransBalResponceDto;
import co.za.bank.balance.and.dispensing.system.bankbalanceanddispensingsystem.entities.ClientAccountEntity;
import co.za.bank.balance.and.dispensing.system.bankbalanceanddispensingsystem.entities.CurrencyConversionRateEntity;
import co.za.bank.balance.and.dispensing.system.bankbalanceanddispensingsystem.exceptions.NoAccountFoundException;
import co.za.bank.balance.and.dispensing.system.bankbalanceanddispensingsystem.services.ViewAccountService;

public class ViewAccountServiceImpl implements ViewAccountService{

    @Autowired
    private ClientAccountRepository clientAccountRepository;
 
    @Autowired
    private CurrencyConversionRepository currencyConversionRepository;

	@Override
	public List<ClientTransBalResponceDto> getTransactionalAccountBalances(String id, Instant instant)  throws NoAccountFoundException {
		 List<ClientAccountEntity> clientAccountEntities = clientAccountRepository.findByClientId(id);
	 	/**
	 	 *  I was meant to transform the entities to Dtos ,didn't have enough time to complete that 
	 	 */
		 List<ClientTransBalResponceDto> clientTransBalResponceDtos = new ArrayList<>(); 
		
		clientAccountEntities.stream().sorted().forEach(acc ->{
			 ClientTransBalResponceDto  clientTransBalResponceDto  = new ClientTransBalResponceDto();
			clientTransBalResponceDto.setAccBalance(acc.getDisplayBalance());
			clientTransBalResponceDto.setAccountNo(acc.getClientAccNo());
			clientTransBalResponceDto.setAccType(acc.getAccountType().getDescription());
			clientTransBalResponceDtos.add(clientTransBalResponceDto);
			
		});
		
	
		return clientTransBalResponceDtos;
	}

	@Override
	public List<ClientCurAccBalResponceDto> getCurrencyAccountBalances(String id, Instant instant) throws NoAccountFoundException {
		
	 	/**
	 	 *  Again here I was meant to transform the entities to Dtos ,didn't have enough time to complete that 
	 	 */
		List<ClientAccountEntity> clientAccountEntities = clientAccountRepository.findByClientId(id);
		
		
		List<ClientCurAccBalResponceDto> clientCurAccBalResponceDtos = new ArrayList<>();

		
		clientAccountEntities.stream().sorted().forEach(acc ->{
			ClientCurAccBalResponceDto clientCurAccBalResponceDto = new ClientCurAccBalResponceDto();
			CurrencyConversionRateEntity currencyConversionRateEntity =currencyConversionRepository.findByRateByCurrencyCode(acc.getCurrency().getCurrencyCode());
			Double convertionRatio = currencyConversionRateEntity.getRate();
			Double zarAmount =acc.getDisplayBalance()* convertionRatio;
					
			clientCurAccBalResponceDto.setAccountNo(acc.getClientAccNo());
			clientCurAccBalResponceDto.setCurrency(acc.getCurrency().getCurrencyCode());
			clientCurAccBalResponceDto.setCurrencyBalance(acc.getDisplayBalance());
			clientCurAccBalResponceDto.setConvertionRatio(convertionRatio);
			clientCurAccBalResponceDto.setZarAmount(zarAmount);
			clientCurAccBalResponceDtos.add(clientCurAccBalResponceDto);
		});
		
		if (clientCurAccBalResponceDtos.isEmpty()) {
			
			throw new NoAccountFoundException("No accounts to display");
		}

		return clientCurAccBalResponceDtos;
	}
  	
	
 
	

}
