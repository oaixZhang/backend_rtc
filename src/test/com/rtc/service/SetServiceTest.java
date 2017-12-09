package com.rtc.service;

import com.rtc.bean.BaseQuestionBean;
import com.rtc.bean.QuesSetBean;
import com.rtc.dao.SetMapper;
import com.rtc.utils.LogUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class SetServiceTest {
    @Autowired
    private SetMapper setMapper;
    @Autowired
    private SetService setService;

    @Test
    public void assignSetToClasses() throws Exception {
        System.out.println("RESULT: " + setService.assignSetToClasses(new int[]{1}, 1));
    }

    @Test
    public void getSetByClassId() throws Exception {
        System.out.println("list: " + setService.getSetById(1));
    }

    @Test
    public void createQuesSet() throws Exception {
        QuesSetBean quesSetBean = new QuesSetBean();

        List<BaseQuestionBean> list = new ArrayList<>();
        for (int i = 1; i < 4; i++) {
            BaseQuestionBean baseQuestionBean = new BaseQuestionBean();
            baseQuestionBean.setQuesId(1);
            baseQuestionBean.setQuesType(i);
            list.add(baseQuestionBean);
        }


        quesSetBean.setQuesNum(list.size());
        quesSetBean.setFlag(0);
        quesSetBean.setMark(100);
        quesSetBean.setTeacherId(1);
        quesSetBean.setQuesList(list);

        if (setMapper.createQuesSet(quesSetBean) == 1) {
            LogUtils.info("quesSetBean: quesSetId = " + quesSetBean.getQuesSetId());
            Iterator iterator = quesSetBean.getQuesList().iterator();
            while (iterator.hasNext()) {
                if (setMapper.insertQuesIntoSet(quesSetBean.getQuesSetId(),
                        (BaseQuestionBean) iterator.next()) == 1) {
                    LogUtils.info("insert success");
                } else {
                    LogUtils.info("error");
                }
            }
        }
    }

    @Test
    public void getQuesSetById() throws Exception {
        QuesSetBean quesSetBean = setMapper.getQuesSetById(1);
        System.out.println("quesSetBean: " + quesSetBean);
    }

    @Test
    public void testGetQuesSetById() {
        QuesSetBean quesSetBean = setMapper.getQuesSetById(1);
        System.out.println("quesSetBean: " + quesSetBean);

    }

}