package com.gus.jobofferhunter.model.offer;

//TODO - ok 16tys. ofert

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Data
@AllArgsConstructor

@Entity
@DiscriminatorValue("infopraca")
public class InfoPraca extends JobOffer{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
}
