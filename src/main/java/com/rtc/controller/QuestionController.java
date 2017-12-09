package com.rtc.controller;

import com.rtc.bean.MyResponse;
import com.rtc.service.QuestionService;
import com.rtc.utils.LogUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 题目相关
 */
@Controller
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private QuestionService questionService;

    /**
     * 获取所有填空题
     * @return HashMap，键值对形式的json
     */
    @RequestMapping(value = "/fillBlank/all", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getAllFillBlankQuestions() {
        return MyResponse.sResponse(questionService.getAllFillBlankQuestions());
    }

    /**
     * 获取所有选择题
     */
    @RequestMapping(value = "/select/all", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getAllSelectQuestions() {
        LogUtils.info("********** request select questions .\n" + "user-agent:" + request.getHeader("user-agent"));
        return MyResponse.sResponse(questionService.getAllSelectQuestions());
    }

    /**
     * 多选题
     */
    @RequestMapping(value = "/mulitChoice/all", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getAllMulitChoiceQues() {
        return MyResponse.sResponse(questionService.getAllMulitChoiceQues());
    }

    /**
     * 判断题
     */
    @RequestMapping(value = "/trueOrFalse/all", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getAllTrueOrFalseQues() {
        return MyResponse.sResponse(questionService.getAllTrueOrFalseQues());
    }

    /**
     * 简答题
     */
    @RequestMapping(value = "/simpleAnswer/all", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getAllSimpleAnswerQues() {
        return MyResponse.sResponse(questionService.getAllSimpleAnswerQues());
    }

    /**
     * 根据题目Id获取指定的题目（填空题）
     * @param quesId 题目的Id
     */
    @RequestMapping(value = "/fillBlank/{quesId}", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getFillBlankQuesById(@PathVariable("quesId") int quesId) {
        return MyResponse.sResponse(questionService.getFillBlankQuesById(quesId));
    }

    @RequestMapping(value = "/select/{quesId}", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getSelectQuesById(@PathVariable("quesId") int quesId) {
        return MyResponse.sResponse(questionService.getSelectQuesById(quesId));
    }

    @RequestMapping(value = "/mulitChoice/{quesId}", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getMulitChoiceQuesById(@PathVariable("quesId") int quesId) {
        return MyResponse.sResponse(questionService.getMulitChoiceQuesById(quesId));
    }

    @RequestMapping(value = "/trueOrFalse/{quesId}", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getTrueOrFalseQuesById(@PathVariable("quesId") int quesId) {
        return MyResponse.sResponse(questionService.getTrueOrFalseQuesById(quesId));
    }

    @RequestMapping(value = "/simpleAnswer/{quesId}", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getSimpleAnswerQuesById(@PathVariable("quesId") int quesId) {
        return MyResponse.sResponse(questionService.getSimpleAnswerQuesById(quesId));
    }


}
