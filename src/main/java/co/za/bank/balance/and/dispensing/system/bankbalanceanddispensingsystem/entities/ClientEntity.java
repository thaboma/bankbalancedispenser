package co.za.bank.balance.and.dispensing.system.bankbalanceanddispensingsystem.entities;


import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "CLIENT")
@Getter
@Setter
public class ClientEntity {

    @Id
    @Column(name = "CLIENT_ID")
    private int clientId;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "NAME")
    private String name;

    @Column(name = "SURNAME")
    private String surname;

    @Column(name = "DOB")
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;

    @OneToOne(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name="CLIENT_SUB_TYPE_CODE")
    ClientSubTypeEntity clientSubTypeEntity;
    
    
	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public ClientSubTypeEntity getClientSubTypeEntity() {
		return clientSubTypeEntity;
	}

	public void setClientSubTypeEntity(ClientSubTypeEntity clientSubTypeEntity) {
		this.clientSubTypeEntity = clientSubTypeEntity;
	}
    

}
