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
    private Date dateOfBirth;

    @OneToOne(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name="CLIENT_SUB_TYPE_CODE")
    ClientSubTypeEntity clientSubTypeEntity;
    

}
