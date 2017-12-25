package com.rtc.service.impl;

import com.rtc.bean.BaseQuestionBean;
import com.rtc.bean.QuesSetBean;
import com.rtc.dao.QuestionMapper;
import com.rtc.dao.SetMapper;
import com.rtc.service.SetService;
import com.rtc.utils.LogUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service("setService")
public class SetServiceImpl implements SetService {
    @Autowired
    private SetMapper setMapper;
    @Autowired
    private QuestionMapper questionMapper;


    @Override
    @Transactional
    public QuesSetBean createQuesSet(QuesSetBean quesSetBean) {
        if (setMapper.createQuesSet(quesSetBean) == 1) {
            LogUtils.info("quesSetBean: quesSetId = " + quesSetBean.getSetId());
            Iterator iterator = quesSetBean.getQuesList().iterator();
            while (iterator.hasNext()) {
                if (setMapper.insertQuesIntoSet(quesSetBean.getSetId(), (BaseQuestionBean) iterator.next()) == 1) {
                    LogUtils.info("insert success");
                } else {
                    LogUtils.info("error");
                }
            }
        }
        return quesSetBean;
    }

    @Override
    public List<QuesSetBean> getSetListByClassId(int classId) {
        return setMapper.getSetListByClassId(classId);
    }

    @Override
    public QuesSetBean getSetById(int quesSetId) {
        return setMapper.getQuesSetById(quesSetId);
    }

    @Override
    public QuesSetBean getSetAndQuesById(int quesSetId) {
        QuesSetBean quesSetBean = setMapper.getSetAndQuesById(quesSetId);
        List<BaseQuestionBean> finalList = new ArrayList<>();
        for (BaseQuestionBean quesBean : quesSetBean.getQuesList()) {
            BaseQuestionBean bean = getQuesByTypeAndId(quesBean.getType(), quesBean.getId());
            bean.setType(quesBean.getType());
            finalList.add(bean);
        }
        quesSetBean.setQuesList(finalList);
        return quesSetBean;
    }

    @Override
    public BaseQuestionBean getQuesByTypeAndId(String quesType, int quesId) {
//        switch (quesType) {
//            case BaseQuestionBean.FILLBLANK:
//                return questionMapper.getFillBlankQuesById(quesId);
//            case BaseQuestionBean.SELECT:
//                return questionMapper.getSelectQuesById(quesId);
//            case BaseQuestionBean.MULITCHOICE:
//                return questionMapper.getMulitChoiceQuesById(quesId);
//            case BaseQuestionBean.SIMPLEANSWER:
//                return questionMapper.getSimpleAnswerQuesById(quesId);
//            case BaseQuestionBean.TRUEORFALSE:
//                return questionMapper.getTrueOrFalseQuesById(quesId);
//        }
//        return null;
        return null;
    }

    @Override
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

    @Override
    public List<QuesSetBean> getSetIdsByClassId(int classId) {
        List<QuesSetBean> list = new ArrayList<>();
        int[] setIds = setMapper.getSetIdsByClassId(classId);
        for (int setId : setIds) {
            list.add(getSetById(setId));
        }
        return list;
    }

}
