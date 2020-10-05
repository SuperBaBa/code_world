package org.jarvis.controller;

import org.jarvis.model.Coffee;
import org.jarvis.service.CoffeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author marcus
 * @date 2020/9/6-17:37
 */
@RestController
@RequestMapping(value = "coffee")
public class CoffeeOrderController {
    @Autowired
    private CoffeeService coffeeService;

    @GetMapping("/")
    public List<Coffee> getAll() {
        return coffeeService.getAllCoffee();
    }
}
