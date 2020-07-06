package com.jarvis.repository;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * author:tennyson date:2020/7/6
 **/
@NoRepositoryBean//告诉JPA不要创建对应接口的bean对象
public interface BaseReposity<T,Long> extends PagingAndSortingRepository<T,Long> {
}
