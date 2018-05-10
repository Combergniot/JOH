package com.gus.jobofferhunter.model.offer;

//TODO - Agregator z 200 tys. ofert dla Polski, z 7mln pozostalych -https://www.careerjet.pl

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Data
@AllArgsConstructor

@Entity
@DiscriminatorValue("careerjet")
public class CareerJet extends JobOffer{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
}
