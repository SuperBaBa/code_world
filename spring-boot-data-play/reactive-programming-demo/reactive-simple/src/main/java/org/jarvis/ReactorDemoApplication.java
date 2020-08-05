package org.jarvis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

/**
 * author:tennyson  date:2020/8/1
 */
@SpringBootApplication
@Slf4j
public class ReactorDemoApplication implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(ReactorDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Flux.range(1, 6) //创建一个序列
				.publishOn(Schedulers.newElastic("yto")) //提供一个任务调用，用于request、complete、error
                .doOnRequest(n -> log.info("Request {} number", n)) // 注意顺序造成的区别
                .doOnComplete(() -> log.info("Publisher COMPLETE 1"))
                .onBackpressureBuffer()
                .map(i -> {
                    log.info("Publish {}, {}", Thread.currentThread(), i);
//                    return 10 / (i - 3);
					return i;
                })// 通过Flux使用同步的方式来对序列的每一项进行转换
                .doOnComplete(() -> log.info("Publisher COMPLETE 2"))
				.subscribeOn(Schedulers.single())
//				.onErrorResume(e -> {
//					log.error("Exception {}", e.toString());
//					return Mono.just(-1);
//				})
//				.onErrorReturn(-1)
                .subscribe(i -> log.info("Subscribe {}: {}", Thread.currentThread(), i),
                        e -> log.error("error {}", e.toString()),
                        () -> log.info("Subscriber COMPLETE")//,
//						s -> s.request(4)
                );
        Thread.sleep(2000);
    }
}
