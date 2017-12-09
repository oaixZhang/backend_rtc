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
            Iterator iterator = quesSetBean.getQuesList().iterator();
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

    public List<QuesSetBean> getSetListByClassId(int classId) {
        return setMapper.getSetListByClassId(classId);
    }

    public QuesSetBean getSetById(int quesSetId) {
        return setMapper.getQuesSetById(quesSetId);
    }

    public QuesSetBean getSetAndQuesById(int quesSetId) {
        QuesSetBean quesSetBean = setMapper.getSetAndQuesById(quesSetId);
        List<BaseQuestionBean> finalList = new ArrayList<>();
        for (BaseQuestionBean quesBean : quesSetBean.getQuesList()) {
            BaseQuestionBean bean = getQuesByTypeAndId(quesBean.getQuesType(), quesBean.getQuesId());
            bean.setQuesType(quesBean.getQuesType());
            finalList.add(bean);
        }
        quesSetBean.setQuesList(finalList);
        return quesSetBean;
    }

    public BaseQuestionBean getQuesByTypeAndId(int quesType, int quesId) {
        switch (quesType) {
            case BaseQuestionBean.FILLBLANK:
                return questionMapper.getFillBlankQuesById(quesId);
            case BaseQuestionBean.SELECT:
                return questionMapper.getSelectQuesById(quesId);
            case BaseQuestionBean.MULITCHOICE:
                return questionMapper.getMulitChoiceQuesById(quesId);
            case BaseQuestionBean.SIMPLEANSWER:
                return questionMapper.getSimpleAnswerQuesById(quesId);
            case BaseQuestionBean.TRUEORFALSE:
                return questionMapper.getTrueOrFalseQuesById(quesId);
        }
        return null;
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

    public List<QuesSetBean> getSetIdsByClassId(int classId) {
        List<QuesSetBean> list = new ArrayList<>();
        int[] setIds = setMapper.getSetIdsByClassId(classId);
        for (int setId : setIds) {
            list.add(getSetById(setId));
        }
        return list;
    }

}
