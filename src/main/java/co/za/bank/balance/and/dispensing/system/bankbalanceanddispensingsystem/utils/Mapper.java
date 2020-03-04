package co.za.bank.balance.and.dispensing.system.bankbalanceanddispensingsystem.utils;

import java.util.ArrayList;
import java.util.List;

import co.za.bank.balance.and.dispensing.system.bankbalanceanddispensingsystem.dto.AccountTypeDto;
import co.za.bank.balance.and.dispensing.system.bankbalanceanddispensingsystem.entities.AccountTypeEntity;

public class Mapper {

	public static AccountTypeDto map2Dto(AccountTypeEntity accountTypeEntity) {
		if (accountTypeEntity != null) {
			return GenericTransformer.transform(accountTypeEntity, AccountTypeDto.class);
		}
		return new AccountTypeDto();
	}

	public static List<AccountTypeDto> map2Dto(List<AccountTypeEntity> accountTypeEntities) {
		List<AccountTypeDto> accountTypeDtos = new ArrayList<>();

		if (accountTypeEntities != null) {
			accountTypeEntities.stream().forEach(accountTypeEntity -> accountTypeDtos.add(map2Dto(accountTypeEntity)));

		} else {
			return new ArrayList<AccountTypeDto>();
		}
		return accountTypeDtos;
	}

}
