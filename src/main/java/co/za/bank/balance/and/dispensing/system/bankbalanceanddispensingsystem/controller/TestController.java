package co.za.bank.balance.and.dispensing.system.bankbalanceanddispensingsystem.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/bank")
public class TestController {

    @GetMapping("/test")
    public String test(){

        return "I am working";
    }
}
