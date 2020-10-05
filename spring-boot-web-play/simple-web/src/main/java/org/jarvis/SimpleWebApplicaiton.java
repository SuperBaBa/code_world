package org.jarvis;

import lombok.extern.slf4j.Slf4j;
import org.jarvis.aspectj.config.AspectJConfiguration;
import org.jarvis.model.TestBean;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author marcus
 * @date 2020/8/21-14:33
 */
@SpringBootApplication
@Slf4j
public class SimpleWebApplicaiton implements ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(SimpleWebApplicaiton.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        ApplicationContext fooContext = new AnnotationConfigApplicationContext(AspectJConfiguration.class);
        ClassPathXmlApplicationContext barContext = new ClassPathXmlApplicationContext(
                new String[]{"application-context.xml"}, fooContext);
        TestBean bean = fooContext.getBean("testBeanX", TestBean.class);
        bean.hello();

        log.info("=============");

        bean = barContext.getBean("testBeanX", TestBean.class);
        bean.hello();

        bean = barContext.getBean("testBeanY", TestBean.class);
        bean.hello();
    }

}
