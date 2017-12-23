package com.rtc.controller;



import com.rtc.bean.MyResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * 测试类
 */
@Controller
public class HelloController {
    final Logger logger = LoggerFactory.getLogger(HelloController.class);
    @RequestMapping("/hello")
    @ResponseBody
    public Map<String, Object> helloWorld(){
        logger.info("***** from log4j logger");
        return MyResponse.sResponse("hello spring");
    }
}
