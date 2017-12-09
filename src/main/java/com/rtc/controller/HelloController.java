package com.rtc.controller;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 测试类
 */
@Controller
public class HelloController {
    final Logger logger = LoggerFactory.getLogger(HelloController.class);
    @RequestMapping("/hello")
    public String helloWorld(){
        logger.info("***** from log4j logger");
        return "hello";
    }
}
