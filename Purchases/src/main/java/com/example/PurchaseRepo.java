package com.example;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Created by Jake on 5/10/17.
 */
public interface PurchaseRepo extends PagingAndSortingRepository<Purchase, Integer> {
    // gets all purcahses by their category
    List<Purchase> findByCategory(String category);

    // gets all purchases by a page and a category
    Page<Purchase> findByCategory(Pageable pageable, String category);
}
