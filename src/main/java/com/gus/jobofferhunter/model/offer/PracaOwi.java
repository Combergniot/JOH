package com.gus.jobofferhunter.model.offer;

//TODO - glownie zagraniczne oferty - http://praca.owi.pl/za-granica

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Data
@AllArgsConstructor

@Entity
@DiscriminatorValue("pracaowi")
public class PracaOwi extends JobOffer{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

}
