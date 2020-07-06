package com.jarvis.repository;

import com.jarvis.entity.Coffee;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * author:tennyson date:2020/7/5
 **/
@Repository
public interface CoffeeRepository extends PagingAndSortingRepository<Coffee, Long> {
}
