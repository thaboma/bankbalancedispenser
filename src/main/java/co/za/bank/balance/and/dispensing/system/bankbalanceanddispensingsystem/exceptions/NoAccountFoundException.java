package co.za.bank.balance.and.dispensing.system.bankbalanceanddispensingsystem.exceptions;

public class NoAccountFoundException extends  Exception { 
    public NoAccountFoundException(String errorMessage) {
        super(errorMessage);
    }

}
