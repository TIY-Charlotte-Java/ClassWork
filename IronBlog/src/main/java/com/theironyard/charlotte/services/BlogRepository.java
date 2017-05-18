package com.theironyard.charlotte.services;

import com.theironyard.charlotte.entities.Blog;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Ben on 5/17/17.
 */
public interface BlogRepository extends CrudRepository<Blog, Integer> {
}
