package co.za.bank.balance.and.dispensing.system.bankbalanceanddispensingsystem.dto;


import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ClientTypeDto implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 3126449412093920305L;

	@JsonProperty("clientTypeCode")
    private String clientTypeCode;

	@JsonProperty("description")
    private String description;

//	@JsonProperty("clientSubTypes")
//    private List<ClientSubTypeDto> clientSubTypes = new ArrayList<>();

	
}
