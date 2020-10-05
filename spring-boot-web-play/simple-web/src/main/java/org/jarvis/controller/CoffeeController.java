package org.jarvis.controller;

import org.jarvis.controller.request.NewCoffeeRequest;
import org.jarvis.model.Coffee;
import org.jarvis.service.CoffeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author marcus
 * @date 2020/8/24-9:38
 */
@Controller
@RequestMapping(value = "/coffee")
public class CoffeeController {
    @Autowired
    private CoffeeService coffeeService;

    @PostMapping(value = "increased")
    public Coffee addCoffeeWithoutBindResult(NewCoffeeRequest coffeeRequest) {
        return coffeeService.save(coffeeRequest.getName(), coffeeRequest.getPrice());
    }
}
