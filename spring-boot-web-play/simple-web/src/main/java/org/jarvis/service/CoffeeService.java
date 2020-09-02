package org.jarvis.service;

import org.jarvis.dao.CoffeeRepository;
import org.jarvis.model.Coffee;
import org.joda.money.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Sort;

import java.util.List;

/**
 * @author marcus
 * @date 2020/8/24-11:29
 */
public class CoffeeService {
    @Autowired
    private CoffeeRepository coffeeRepository;

    public Coffee save(String name, Money price) {
        return coffeeRepository.save(Coffee.builder().name(name).price(price).build());
    }

    @Cacheable
    public List<Coffee> getAllCoffee() {
        return coffeeRepository.findAll(Sort.by("id"));
    }

    public Coffee getCoffee(Long id) {
//        return coffeeRepository.findById(id).get();
        return coffeeRepository.getOne(id);
    }

    public Coffee getCoffee(String name) {
        return coffeeRepository.findByName(name);
    }

    public List<Coffee> getCoffeeByName(List<String> names) {
        return coffeeRepository.findByNameInOrderById(names);
    }
}
