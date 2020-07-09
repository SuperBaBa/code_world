package com.jarvis.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * author:marcus date:2020/7/9
 **/
@Component
public class LogOutput {
    private Logger log = LoggerFactory.getLogger(LogOutput.class);

    @PostConstruct
    public void outputLog() {
        log.info("this is a paragraph. I say {} you say {}", "切克", "闹");
    }
}
