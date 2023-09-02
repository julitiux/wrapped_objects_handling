package com.wrapped_objects_handling.repository;

import com.wrapped_objects_handling.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends CrudRepository<User, UUID> {

  Optional<User> findByUsername(final String username);

}
