package com.gus.jobofferhunter.model.offer;

//TODO - świetny agregator

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Data
@AllArgsConstructor

@Entity
@DiscriminatorValue("jobswype")
public class JobSwype extends JobOffer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
}
