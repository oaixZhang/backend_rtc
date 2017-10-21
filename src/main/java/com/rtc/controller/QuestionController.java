package com.rtc.controller;

import com.rtc.bean.MyResponse;
import com.rtc.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @RequestMapping("/fillBlank")
    @ResponseBody
    public Map<String, Object> getAllFillBlankQuestions(){
        return MyResponse.sResponse(questionService.getAllFillBlankQuestions());
    }

    @RequestMapping("/selectQuestion")
    @ResponseBody
    public Map<String, Object> getAllSelectQuestions(){
        return MyResponse.sResponse(questionService.getAllSelectQuestions());
    }
}
