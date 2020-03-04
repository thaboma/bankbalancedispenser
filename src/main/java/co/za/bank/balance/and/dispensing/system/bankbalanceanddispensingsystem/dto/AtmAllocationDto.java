package co.za.bank.balance.and.dispensing.system.bankbalanceanddispensingsystem.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AtmAllocationDto extends Dto {

    /**
	 * 
	 */
	private static final long serialVersionUID = -499636923540664087L;

	@JsonProperty("atmAllocationId")
    private Integer  atmAllocationId;
	
	@JsonProperty("atms")
	private List<AtmDto> atms = new ArrayList<>();

	@JsonProperty("denaminations")
	private List<DenominationDto> denaminations = new ArrayList<>();

    @Column(name = "LOCATION")
    private int  count;   


}
