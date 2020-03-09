package co.za.bank.balance.and.dispensing.system.bankbalanceanddispensingsystem.exceptions;

public class NoAccountFoundException extends  Exception { 
    /**
	 * 
	 */
	private static final long serialVersionUID = -1697272839136620104L;

	public NoAccountFoundException(String errorMessage) {
        super(errorMessage);
    }

}
