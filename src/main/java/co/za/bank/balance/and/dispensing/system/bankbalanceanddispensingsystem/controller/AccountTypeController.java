package co.za.bank.balance.and.dispensing.system.bankbalanceanddispensingsystem.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.za.bank.balance.and.dispensing.system.bankbalanceanddispensingsystem.dto.AccountTypeDto;
import co.za.bank.balance.and.dispensing.system.bankbalanceanddispensingsystem.entities.ClientEntity;
import co.za.bank.balance.and.dispensing.system.bankbalanceanddispensingsystem.entities.ClientTypeEntity;
import co.za.bank.balance.and.dispensing.system.bankbalanceanddispensingsystem.servicesimpl.AccountServiceImpl;

@RestController
@RequestMapping("api/v1/account")
public class AccountTypeController {

    @Autowired
    private AccountServiceImpl accountService;
    
    @GetMapping("/get_all_account_type")
    public List<AccountTypeDto> getAllCountType(){
        return accountService.getAllAccountType();
    }

    @GetMapping("/get_all_clients")
    public List<ClientEntity> getAllClients(){
       return accountService.getAllClient();
    }

    @GetMapping("/get_all_client_type")
    public List<ClientTypeEntity> getAllClientType(){
        return accountService.getAllClientType();
    }
}
