package com.rtc.controller;

import com.rtc.bean.MyResponse;
import com.rtc.service.QuestionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping("/question")
public class QuestionController {
    Logger logger = LoggerFactory.getLogger(QuestionController.class);
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private QuestionService questionService;

    @RequestMapping(value = "/fillBlank/all", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getAllFillBlankQuestions() {
        return MyResponse.sResponse(questionService.getAllFillBlankQuestions());
    }

    @RequestMapping(value = "/select/all", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getAllSelectQuestions() {

        logger.info("********** request select questions .\n" + "user-agent:" + request.getHeader("user-agent"));
        return MyResponse.sResponse(questionService.getAllSelectQuestions());
    }

    @RequestMapping(value = "/mulitChoice/all", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getAllMulitChoiceQues() {
        return MyResponse.sResponse(questionService.getAllMulitChoiceQues());
    }

    @RequestMapping(value = "/trueOrFalse/all", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getAllTrueOrFalseQues() {
        return MyResponse.sResponse(questionService.getAllTrueOrFalseQues());
    }

    @RequestMapping(value = "/simpleAnswer/all", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getAllSimpleAnswerQues() {
        return MyResponse.sResponse(questionService.getAllSimpleAnswerQues());
    }

}
