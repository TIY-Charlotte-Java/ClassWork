package com.theironyard.charlotte.repositories;

import com.theironyard.charlotte.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
    User findFirstByUsername(String username);
}
