package org.jarvis.controller;

import org.jarvis.config.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * author:tennyson date:2020/6/23
 **/
@Controller
@RequestMapping(value = "/ftl")
public class FreeMarkerController {

    @Autowired
    private Resource resource;

    @RequestMapping(value = "books")
    public String index(Map<String,Object> map){
        map.put("name", "[Angel -- 守护天使]");
        return "books";
    }

}
