package com.rtc.service;

import com.rtc.bean.BaseQuestionBean;
import com.rtc.bean.QuesSetBean;
import com.rtc.dao.QuestionMapper;
import com.rtc.dao.SetMapper;
import com.rtc.utils.LogUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class SetService {
    @Autowired
    private SetMapper setMapper;
    @Autowired
    private QuestionMapper questionMapper;

    @Transactional
    public QuesSetBean createQuesSet(QuesSetBean quesSetBean) {
        if (setMapper.createQuesSet(quesSetBean) == 1) {
            LogUtils.info("quesSetBean: quesSetId = " + quesSetBean.getQuesSetId());
            Iterator iterator = quesSetBean.getQuesSet().iterator();
            while (iterator.hasNext()) {
                if (setMapper.insertQuesIntoSet(quesSetBean.getQuesSetId(), (BaseQuestionBean) iterator.next()) == 1) {
                    LogUtils.info("insert success");
                } else {
                    LogUtils.info("error");
                }
            }
        }
        return quesSetBean;
    }

    public QuesSetBean getQuesSetById(int quesSetId) {
        QuesSetBean quesSetBean = setMapper.getQuesSetById(quesSetId);
        Iterator iterator = quesSetBean.getQuesSet().iterator();
        Set<BaseQuestionBean> finalSet = new HashSet<>();

        while (iterator.hasNext()) {
            BaseQuestionBean baseQuestionBean = (BaseQuestionBean) iterator.next();
            switch (baseQuestionBean.getQuesType()) {
                case BaseQuestionBean.FILLBLANK:
                    finalSet.add(questionMapper.getFillBlankQuesById(baseQuestionBean.getQuesId()));
                    break;
                case BaseQuestionBean.SELECT:
                    finalSet.add(questionMapper.getSelectQuesById(baseQuestionBean.getQuesId()));
                    break;
                case BaseQuestionBean.MULITCHOICE:
                    finalSet.add(questionMapper.getMulitChoiceQuesById(baseQuestionBean.getQuesId()));
                    break;
                case BaseQuestionBean.SIMPLEANSWER:
                    finalSet.add(questionMapper.getSimpleAnswerQuesById(baseQuestionBean.getQuesId()));
                    break;
                case BaseQuestionBean.TRUEORFALSE:
                    finalSet.add(questionMapper.getTrueOrFalseQuesById(baseQuestionBean.getQuesId()));
                    break;
            }
        }

        quesSetBean.setQuesSet(finalSet);
        return quesSetBean;
    }

    public int assignSetToClasses(int[] classIds, int quesSetId) {
        for (int classId : classIds) {
            if (setMapper.assignSetToClass(classId, quesSetId, new Date()) == 1) {
                LogUtils.info("insert succeed");
            } else {
                LogUtils.info("insert failed");
            }
        }
        return 1;
    }

    public List<QuesSetBean> getSetByClassId(int classId) {
        List<QuesSetBean> list = new ArrayList<>();
        int[] setIds = setMapper.getSetIdsByClassId(classId);
        for (int setId : setIds) {
            list.add(getQuesSetById(setId));
        }
        return list;
    }

}
