package com.theironyard.charlotte.services;

import com.theironyard.charlotte.entities.User;
import org.springframework.data.repository.CrudRepository;

// defines the userrepository interface as one that has basic
// CRUD abilities.
// Will be autowired into our controller.
// The actual class that Spring will use is SimpleJpaRepository

//                              Type of thing to store--v    v-- type of ID column
public interface UserRepository extends CrudRepository<User, Integer> {
}