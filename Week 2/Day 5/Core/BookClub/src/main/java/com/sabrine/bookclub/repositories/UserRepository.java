package com.sabrine.bookclub.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sabrine.bookclub.models.User;
@Repository

public interface UserRepository extends CrudRepository<User, Long> {
	Optional <User> findByEmail(String email);

}
