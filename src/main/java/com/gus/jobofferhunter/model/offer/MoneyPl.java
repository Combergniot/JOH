package com.gus.jobofferhunter.model.offer;

import com.gus.jobofferhunter.model.JobOffer;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity
@DiscriminatorValue("moneypl")
public class MoneyPl extends JobOffer{
}
