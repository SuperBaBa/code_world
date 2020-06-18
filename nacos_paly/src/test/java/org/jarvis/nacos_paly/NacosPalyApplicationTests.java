package org.jarvis.nacos_paly;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class NacosPalyApplicationTests {

    @Test
    void contextLoads() {
    }

    public static void main(String[] args) {
        System.out.println(System.getProperty("JM.SNAPSHOT.PATH", System.getProperty("user.home")));
    }
}
