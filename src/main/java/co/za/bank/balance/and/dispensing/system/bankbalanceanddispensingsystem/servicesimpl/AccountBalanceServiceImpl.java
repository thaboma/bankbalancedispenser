package co.za.bank.balance.and.dispensing.system.bankbalanceanddispensingsystem.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.za.bank.balance.and.dispensing.system.bankbalanceanddispensingsystem.dao.AccountTypeRepository;
import co.za.bank.balance.and.dispensing.system.bankbalanceanddispensingsystem.dto.AccountTypeDto;
import co.za.bank.balance.and.dispensing.system.bankbalanceanddispensingsystem.entities.AccountTypeEntity;
import co.za.bank.balance.and.dispensing.system.bankbalanceanddispensingsystem.services.AccountBalanceService;
import co.za.bank.balance.and.dispensing.system.bankbalanceanddispensingsystem.utils.Mapper;

@Service
public class AccountBalanceServiceImpl implements AccountBalanceService {

    @Autowired
    private AccountTypeRepository accountTypeRepository;

    public List<AccountTypeDto> getAllAccountType(){    	
    	 List<AccountTypeEntity> entities = accountTypeRepository.findAll();
    	 List<AccountTypeDto> accountTypeDtos = Mapper.map2Dto(entities);
        return accountTypeDtos;
    }

	@Override
	public List<? extends Object> getTransactionalAccountBalances() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<? extends Object> getCurrencyAccountBalances() {
		// TODO Auto-generated method stub
		return null;
	}
    
}
