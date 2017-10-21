package com.rtc.service;

import com.rtc.bean.FillBlankBean;
import com.rtc.bean.SelectQuesBean;
import com.rtc.dao.QuestionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class QuestionService {
    @Autowired
    private QuestionMapper questionMapper;

    @Transactional
    public List<FillBlankBean> getAllFillBlankQuestions(){
        return questionMapper.getAllFillBlankQuestions();
    }
    @Transactional
    public List<SelectQuesBean> getAllSelectQuestions(){
        return questionMapper.getAllSelectQuestions();
    }
}
