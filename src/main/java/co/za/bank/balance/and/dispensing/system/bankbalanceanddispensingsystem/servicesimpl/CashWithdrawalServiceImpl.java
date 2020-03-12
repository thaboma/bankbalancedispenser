package co.za.bank.balance.and.dispensing.system.bankbalanceanddispensingsystem.servicesimpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import co.za.bank.balance.and.dispensing.system.bankbalanceanddispensingsystem.dao.AtmAllocationRepository;
import co.za.bank.balance.and.dispensing.system.bankbalanceanddispensingsystem.dao.ClientAccountRepository;
import co.za.bank.balance.and.dispensing.system.bankbalanceanddispensingsystem.dto.AtmRequestDto;
import co.za.bank.balance.and.dispensing.system.bankbalanceanddispensingsystem.dto.DenominationCounterDto;
import co.za.bank.balance.and.dispensing.system.bankbalanceanddispensingsystem.entities.AtmAllocationEntity;
import co.za.bank.balance.and.dispensing.system.bankbalanceanddispensingsystem.entities.ClientAccountEntity;
import co.za.bank.balance.and.dispensing.system.bankbalanceanddispensingsystem.exceptions.AtmExceptionException;
import co.za.bank.balance.and.dispensing.system.bankbalanceanddispensingsystem.exceptions.InsufficientFundsException;
import co.za.bank.balance.and.dispensing.system.bankbalanceanddispensingsystem.services.CashWithdrawalService;

@Component
public class CashWithdrawalServiceImpl implements CashWithdrawalService{

    
    @Autowired
    private ClientAccountRepository clientAccountRepository;
    
    @Autowired
    private AtmAllocationRepository atmAllocationRepository;
    
    
    private static final  String CHEQUE_ACCOUNT="CHQ";
    
    private static final  String NOTES="N";
    
	@Override
	@Transactional
	public List<DenominationCounterDto> dispenseCash(AtmRequestDto atmRequestDto)
			throws InsufficientFundsException, AtmExceptionException {
		System.out.println("atmRequestDto\r\n" + atmRequestDto);

		List<ClientAccountEntity> clientAccountEntities = clientAccountRepository
				.findByClientId(Integer.parseInt(atmRequestDto.getClientId()));
		List<DenominationCounterDto> denominationCounts = new ArrayList<>();

		/**
		 * I was meant to transform the entities to Dtos ,didn't have enough time to
		 *  complete that transform clientAccountEntities and denominationCounts
		 */
		Set<Integer> availableDenominations = getAvailableDenominations(atmRequestDto);
		if (availableDenominations.isEmpty()) {
			throw new AtmExceptionException("ATM not registered or unfunded");
		}

		StringBuffer errorStr = new StringBuffer("Insufficient funds Amount not available, would you like to draw ");

		for(ClientAccountEntity acc:clientAccountEntities) {
		//clientAccountEntities.stream().forEach(acc -> {
			if (acc.getAccountType().getTransactional()) {
				if (acc.getClientAccNo().equals(atmRequestDto.getAccountNo())) {

					if (acc.getAccountType().getAccountTypeCode().equalsIgnoreCase(CHEQUE_ACCOUNT)) {

						double odLimit = acc.getDisplayBalance().doubleValue() + 10000D;
						System.out.println(
								"odLimit = " + odLimit + "[" + (odLimit >= atmRequestDto.getRequiredAmt().doubleValue())
										+ "] " + atmRequestDto.getRequiredAmt().doubleValue());
						if (odLimit >= atmRequestDto.getRequiredAmt().doubleValue()) {
							denominationCounts.addAll(withDrawCash(acc, atmRequestDto, availableDenominations));
						} else {
							errorStr.append(odLimit + "");
						}

					} else {
						if (acc.getDisplayBalance().doubleValue() >= atmRequestDto.getRequiredAmt().doubleValue()) {
							denominationCounts.addAll(withDrawCash(acc, atmRequestDto, availableDenominations));
						} else {
							errorStr.append(acc.getDisplayBalance().doubleValue()
									- (acc.getDisplayBalance().doubleValue() % 10) + "");
						}
					}

				}

			}
		//});
		}

		if (denominationCounts.isEmpty()) {
			throw new InsufficientFundsException(errorStr.toString());
		}

		return denominationCounts;
	}
	
	private List<DenominationCounterDto> withDrawCash(ClientAccountEntity acc, AtmRequestDto atmRequestDto,
			Set<Integer> availableDenominations) throws AtmExceptionException {
		List<DenominationCounterDto> denominationCounts = new ArrayList<>();
		if (atmRequestDto.getRequiredAmt().doubleValue() % 10 == 0) {

			if (availableDenominations != null) {

				if (!availableDenominations.isEmpty()) {
					getNotesPerDenomination(atmRequestDto.getRequiredAmt().intValue(), availableDenominations)
							.forEach((d, c) -> {
								DenominationCounterDto denominationCount = new DenominationCounterDto();
								denominationCount.setDenomination(Integer.parseInt(d));
								denominationCount.setCount(Integer.parseInt(c));
								denominationCounts.add(denominationCount);
							});
					// );
					acc.setDisplayBalance(acc.getDisplayBalance().subtract(atmRequestDto.getRequiredAmt()));
					clientAccountRepository.saveAndFlush(acc);
				}
			}

		}else {
			throw new AtmExceptionException("Please check your required amonut and try again");
		}
		return denominationCounts;
	}

	@Override
	public Set<Integer> getAvailableDenominations(AtmRequestDto atmRequestDto) throws AtmExceptionException {
		List<AtmAllocationEntity> atmAllocations = atmAllocationRepository
				.findByAtmAtmId(Integer.parseInt(atmRequestDto.getAtmId()));
		
		if (atmAllocations.isEmpty()) {		 
				throw new AtmExceptionException("ATM not registered or unfunded");
		}

		Set<Integer> denominationNotes = new HashSet<Integer>();
		atmAllocations.forEach(a -> {
			if (a.getDenomination().getDenominationType().getDenominationTypeCode().equals(NOTES)) {

				@SuppressWarnings("resource")
				Scanner intScanner = new Scanner(atmRequestDto.getRequiredAmt().toString());

				if (intScanner.hasNextInt()) {
					denominationNotes.add(a.getDenomination().getValue().intValue());
				}
			}
		});
		System.out.print("denominationNotes = " + denominationNotes);
		return denominationNotes;
	}


	@Override
	public Map<String,String> getNotesPerDenomination(int amount, Set<Integer> denominations) {  
		 
		Map<String,String> note2Count = new HashMap<>();
	
		Integer[] notes = new Integer[denominations.size()];
		 denominations.toArray(notes);
		 
		 int noteCounter[] = new int[denominations.size()];
	 
	    for (int i = 0; i < denominations.size(); i++) { 
	        if (amount >= notes[i]) { 
	            noteCounter[i] = amount / notes[i]; 
	            amount = amount - noteCounter[i] * notes[i]; 
	        } 
	    } 
	      

	    // Count notes using Greedy approach 
	    for (int i = 0; i < denominations.size(); i++) { 
	        if (amount >= notes[i]) { 
	            noteCounter[i] = amount / notes[i]; 
	            amount = amount - noteCounter[i] * notes[i]; 
	        } 
	    } 
	      
	    // Print notes 
	    for (int i = 0; i < denominations.size(); i++) { 
	        if (noteCounter[i] != 0) { 
	            note2Count.put(""+notes[i], ""+noteCounter[i]);           
	            
	        } 
	    } 
	    System.out.println("note2Count is = "+note2Count);
	    return note2Count;
	} 

}
