package co.za.bank.balance.and.dispensing.system.bankbalanceanddispensingsystem.services;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Service;

import co.za.bank.balance.and.dispensing.system.bankbalanceanddispensingsystem.dto.AtmRequestDto;
import co.za.bank.balance.and.dispensing.system.bankbalanceanddispensingsystem.dto.DenominationCounterDto;
import co.za.bank.balance.and.dispensing.system.bankbalanceanddispensingsystem.exceptions.AtmExceptionException;
import co.za.bank.balance.and.dispensing.system.bankbalanceanddispensingsystem.exceptions.InsufficientFundsException;

@Service
public interface CashWithdrawalService {
	
	List<DenominationCounterDto> dispenseCash(AtmRequestDto atmRequestDton) throws InsufficientFundsException, AtmExceptionException;
	
//     void getCash(AtmRequestDto atmRequestDto);
//     
// 
    public Set<Integer> getAvailableDenominations( AtmRequestDto atmRequestDto) throws AtmExceptionException,AtmExceptionException;
// /
//     void dispenseCash(@RequestBody List<Integer> notesPerDenomination);
//     
    Map<String,String> getNotesPerDenomination(int amount, Set<Integer> denominations);
     
//	Set<Integer> getAvailableDenominations(List<AtmAllocationEntity> atmAllocations, double reqAmnt);

	// Set<Integer> getNotesPerDenomination(Set<Integer> availableDenominations, int reqAmnt);

}
