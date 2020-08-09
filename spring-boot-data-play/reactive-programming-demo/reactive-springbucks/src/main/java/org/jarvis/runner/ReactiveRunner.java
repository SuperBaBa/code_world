package org.jarvis.runner;

import lombok.extern.slf4j.Slf4j;
import org.jarvis.model.Coffee;
import org.jarvis.model.CoffeeOrder;
import org.jarvis.model.OrderState;
import org.jarvis.service.CoffeeOrderService;
import org.jarvis.service.CoffeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Date;

/**
 * @author marcus
 * @date 2020/8/9-9:03
 */
@Component
@Slf4j
public class ReactiveRunner implements ApplicationRunner {
    @Autowired
    private CoffeeService coffeeService;
    @Autowired
    private CoffeeOrderService orderService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
//        coffeeService.initCache()
//                .then(
//                        coffeeService.findOneCoffee("mocha")
//                                .flatMap(c -> {
//                                    CoffeeOrder order = createOrder("Li Lei", c);
//                                    return orderService.create(order);
//                                })
//                                .doOnError(t -> log.error("error", t)))
//                .subscribe(o -> log.info("Create Order: {}", o));
//        log.info("After Subscribe");
//        Thread.sleep(5000);
    }

    private CoffeeOrder createOrder(String customer, Coffee... coffee) {
        return CoffeeOrder.builder()
                .customer(customer)
                .items(Arrays.asList(coffee))
                .state(OrderState.INIT)
                .createTime(new Date())
                .updateTime(new Date())
                .build();
    }
}
