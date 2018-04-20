package com.gus.jobofferhunter.model.offer;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Data
@AllArgsConstructor

@Entity
@DiscriminatorValue("gratka")
public class Gratka extends JobOffer{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String branch;

    private String typeOfWork; //rodzaj pracy

    private String jobType; //typ stanowiska

    private String salary;

    private String dataId;

    private String additionalOptions; //opcje dodatkowe
    @Lob
    private String description; //treść ogłoszenia
    @Lob
    private String url;



}
