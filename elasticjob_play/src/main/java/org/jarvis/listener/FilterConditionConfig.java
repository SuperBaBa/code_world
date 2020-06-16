package org.jarvis.listener;

import com.dingtalk.api.response.CorpReportListResponse;
import org.apache.tomcat.util.json.JSONParser;
import org.apache.tomcat.util.json.ParseException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * author:tennyson date:2020/6/16
 **/
@Configuration
public class FilterConditionConfig {
    @Bean(value = "getConditionJSON")
    public Map<String, Long> getConditionJSON(@Value("${conditionJSON:''}") String conditionJSON) {
        Map<String, Long> conditionMap = new ConcurrentHashMap<>();
        try {
            if (!conditionJSON.isEmpty()) {
                JSONParser jsonParser = new JSONParser(conditionJSON);
                ArrayList<Object> mapArrayList = jsonParser.parseArray();
                for (Object object : mapArrayList) {
                    LinkedHashMap linkedHashMap = (LinkedHashMap) object;
                    Set<Map.Entry> entrySet = linkedHashMap.entrySet();
                    for (Map.Entry entry : entrySet) {
                        conditionMap.put((String) entry.getKey(), Long.parseLong((String) entry.getValue()));
                    }
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return conditionMap;
    }
}
