package co.za.bank.balance.and.dispensing.system.bankbalanceanddispensingsystem.dto;


import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

 
@Getter
@Setter
@ToString
public abstract class Dto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2161045052319238787L;
	@JsonProperty("id")
	private Long id;
	
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
}



