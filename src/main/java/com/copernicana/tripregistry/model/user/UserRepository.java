package com.copernicana.tripregistry.model.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Marcin on 2017-07-05.
 */

@Repository
public interface  UserRepository extends CrudRepository <User, Long> {
    User findByUsername (String username);

}
