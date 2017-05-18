package com.theironyard.charlotte.repositories;

import com.theironyard.charlotte.entities.BlogPost;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by Ben on 5/18/17.
 */
public interface BlogPostRepository extends PagingAndSortingRepository<BlogPost, Integer> {
}
