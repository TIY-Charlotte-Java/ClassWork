package com.example;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by Jake on 5/10/17.
 */
public interface CustomerRepo extends CrudRepository<Customer, Integer> {


}
