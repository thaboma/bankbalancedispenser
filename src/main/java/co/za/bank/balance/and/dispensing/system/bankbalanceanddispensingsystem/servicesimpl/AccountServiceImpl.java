package co.za.bank.balance.and.dispensing.system.bankbalanceanddispensingsystem.servicesimpl;

import co.za.bank.balance.and.dispensing.system.bankbalanceanddispensingsystem.dao.AccountTypeRepository;
import co.za.bank.balance.and.dispensing.system.bankbalanceanddispensingsystem.dao.ClientRepository;
import co.za.bank.balance.and.dispensing.system.bankbalanceanddispensingsystem.dao.ClientTypeRepository;
import co.za.bank.balance.and.dispensing.system.bankbalanceanddispensingsystem.dto.AccountTypeDto;
import co.za.bank.balance.and.dispensing.system.bankbalanceanddispensingsystem.entities.AccountTypeEntity;
import co.za.bank.balance.and.dispensing.system.bankbalanceanddispensingsystem.entities.ClientEntity;
import co.za.bank.balance.and.dispensing.system.bankbalanceanddispensingsystem.entities.ClientTypeEntity;
import co.za.bank.balance.and.dispensing.system.bankbalanceanddispensingsystem.utils.Mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountServiceImpl {

    @Autowired
    private AccountTypeRepository accountTypeRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ClientTypeRepository clientTypeRepository;


    public List<AccountTypeDto> getAllAccountType(){    	
    	 List<AccountTypeEntity> entities = accountTypeRepository.findAll();
    	 List<AccountTypeDto> accountTypeDtos = Mapper.map2Dto(entities);
        return accountTypeDtos;
    }

    public List<ClientEntity> getAllClient(){
      return   clientRepository.findAll();
    }

    public List<ClientTypeEntity> getAllClientType(){
      return   clientTypeRepository.findAll();
    }
    
    
    public List<? extends Object> getTransactionalAccountBalances(){
    	return new ArrayList<Object>();
    }
    
    public List<? extends Object> getCurrencyAccountBalances(){
    	
    	return new ArrayList<Object>();
    }
    
}
