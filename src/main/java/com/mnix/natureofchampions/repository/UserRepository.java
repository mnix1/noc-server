package com.mnix.natureofchampions.repository;

import com.mnix.natureofchampions.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
