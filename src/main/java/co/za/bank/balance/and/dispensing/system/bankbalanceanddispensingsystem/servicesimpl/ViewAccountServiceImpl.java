package co.za.bank.balance.and.dispensing.system.bankbalanceanddispensingsystem.servicesimpl;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.za.bank.balance.and.dispensing.system.bankbalanceanddispensingsystem.dao.ClientAccountRepository;
import co.za.bank.balance.and.dispensing.system.bankbalanceanddispensingsystem.dao.CurrencyConversionRepository;
import co.za.bank.balance.and.dispensing.system.bankbalanceanddispensingsystem.dto.ClientCurAccBalResponceDto;
import co.za.bank.balance.and.dispensing.system.bankbalanceanddispensingsystem.dto.ClientTransBalResponceDto;
import co.za.bank.balance.and.dispensing.system.bankbalanceanddispensingsystem.entities.ClientAccountEntity;
import co.za.bank.balance.and.dispensing.system.bankbalanceanddispensingsystem.entities.CurrencyConversionRateEntity;
import co.za.bank.balance.and.dispensing.system.bankbalanceanddispensingsystem.exceptions.NoAccountFoundException;
import co.za.bank.balance.and.dispensing.system.bankbalanceanddispensingsystem.services.ViewAccountService;
 
@Component
public class ViewAccountServiceImpl implements ViewAccountService{

	   static Logger log = Logger.getLogger(ViewAccountServiceImpl.class.getName());
	
    @Autowired
    private ClientAccountRepository clientAccountRepository;
 
    @Autowired
    private CurrencyConversionRepository currencyConversionRepository;

	@Override
	public List<ClientTransBalResponceDto> getTransactionalAccountBalances(String id, Instant instant)
			throws NoAccountFoundException {
		log.info("getTransactionalAccountBalances .. Client Id is  : " + id);
		List<ClientAccountEntity> clientAccountEntities = clientAccountRepository.findByClientId(Integer.parseInt(id));
		log.info("ClientAccountEntity size is  : " + clientAccountEntities.size());

		/**
		 * I was meant to transform the entities to Dtos ,didn't have enough time to
		 * complete that
		 */
		List<ClientTransBalResponceDto> clientTransBalResponceDtos = new ArrayList<>();

		for (ClientAccountEntity acc : clientAccountEntities) {
			if (acc.getAccountType().getTransactional()) {
				ClientTransBalResponceDto clientTransBalResponceDto = new ClientTransBalResponceDto();
				clientTransBalResponceDto.setAccBalance(acc.getDisplayBalance());
				clientTransBalResponceDto.setAccountNo(acc.getClientAccNo());
				clientTransBalResponceDto.setAccType(acc.getAccountType().getDescription());
				clientTransBalResponceDtos.add(clientTransBalResponceDto);
			}
		}

		Comparator<ClientTransBalResponceDto> clientTransBalResponceDtoComparator = (ClientTransBalResponceDto c1,
				ClientTransBalResponceDto c2) -> c2.getAccBalance().subtract(c1.getAccBalance()).intValue();
		clientTransBalResponceDtos = clientTransBalResponceDtos.stream().sorted(clientTransBalResponceDtoComparator)
				.collect(Collectors.toList());
		return clientTransBalResponceDtos;
	}

	@Override
	public List<ClientCurAccBalResponceDto> getCurrencyAccountBalances(String id, Instant instant)
			throws NoAccountFoundException {

		/**
		 * Again here I was meant to transform the entities to Dtos ,didn't have enough
		 * time to transform clientAccountEntities and clientCurAccBalResponceDtos
		 */

		log.info("Client Id is  : " + id);
		List<ClientAccountEntity> clientAccountEntities = clientAccountRepository.findByClientId(Integer.parseInt(id));
		log.info("ClientAccountEntity size is  : " + clientAccountEntities.size());

		List<ClientCurAccBalResponceDto> clientCurAccBalResponceDtos = new ArrayList<>();

		for (ClientAccountEntity acc : clientAccountEntities) {
			log.info("Currency code is  : " + acc.getCurrency().getCurrencyCode() + " ... "
					+ acc.getCurrency().getDescription());
			ClientCurAccBalResponceDto clientCurAccBalResponceDto = new ClientCurAccBalResponceDto();
			CurrencyConversionRateEntity currencyConversionRateEntity = currencyConversionRepository
					.findRateByCurrencyCode(acc.getCurrency().getCurrencyCode());
			BigDecimal convertionRatio = currencyConversionRateEntity.getRate();
			BigDecimal zarAmount = acc.getDisplayBalance().multiply(convertionRatio);

			clientCurAccBalResponceDto.setAccountNo(acc.getClientAccNo());
			clientCurAccBalResponceDto.setCurrency(acc.getCurrency().getCurrencyCode());
			clientCurAccBalResponceDto.setCurrencyBalance(acc.getDisplayBalance());
			clientCurAccBalResponceDto.setConvertionRatio(convertionRatio);
			clientCurAccBalResponceDto.setZarAmount(zarAmount);
			clientCurAccBalResponceDtos.add(clientCurAccBalResponceDto);
		}

		if (clientCurAccBalResponceDtos.isEmpty()) {

			throw new NoAccountFoundException("No accounts to display");
		}

		Comparator<ClientCurAccBalResponceDto> clientCurAccBalResponceDtoComparator = (ClientCurAccBalResponceDto c1,
				ClientCurAccBalResponceDto c2) -> c2.getZarAmount().subtract(c1.getZarAmount()).intValue();
		clientCurAccBalResponceDtos = clientCurAccBalResponceDtos.stream().sorted(clientCurAccBalResponceDtoComparator)
				.collect(Collectors.toList());

		return clientCurAccBalResponceDtos;
	}
	
 
	

}
