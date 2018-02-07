package com.gus.jobofferhunter.repository;


import com.gus.jobofferhunter.model.offer.PracaGovPl;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PracaGovPlRepository extends CrudRepository <PracaGovPl, Long>{
}
