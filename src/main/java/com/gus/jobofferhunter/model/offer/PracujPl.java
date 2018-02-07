package com.gus.jobofferhunter.model.offer;

import com.gus.jobofferhunter.model.JobOffer;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity
@DiscriminatorValue("pracujpl")
public class PracujPl extends JobOffer {



}
