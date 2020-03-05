package co.za.bank.balance.and.dispensing.system.bankbalanceanddispensingsystem.dto;


import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

 
@Getter
@Setter
public class DenominationTypeDto {

	@JsonProperty("denominationTypeCode")
    private String denominationTypeCode;
 
    @JsonProperty("description")
    private String description;
}
