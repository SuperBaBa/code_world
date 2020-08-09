package org.jarvis.ssl.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.jarvis.ssl.service.ProcessParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @author marcus @date 2020/8/7
 **/
@RestController
public class MatTestKitController {
    @Autowired
    private ProcessParamService processParamService;
    @GetMapping("/mat")
    public HashMap matTest(@RequestParam String waybill, @RequestParam String channel) throws JsonProcessingException {
        return processParamService.processParam(waybill,channel);
    }
}
