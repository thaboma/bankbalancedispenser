package co.za.bank.balance.and.dispensing.system.bankbalanceanddispensingsystem.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class DenominationDto {

	@JsonProperty("denominationId")
    private int denominationId;    
    
	@JsonProperty("value")
    private int value;
    
	@JsonProperty("denominationType")
    DenominationTypeDto denominationType;
}
