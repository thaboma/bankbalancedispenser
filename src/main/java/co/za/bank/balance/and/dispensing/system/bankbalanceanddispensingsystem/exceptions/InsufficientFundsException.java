package co.za.bank.balance.and.dispensing.system.bankbalanceanddispensingsystem.exceptions;

public class InsufficientFundsException extends  Exception { 
    /**
	 * 
	 */
	private static final long serialVersionUID = -1697272839136620103L;

	public InsufficientFundsException(String errorMessage) {
        super(errorMessage);
    }

}
