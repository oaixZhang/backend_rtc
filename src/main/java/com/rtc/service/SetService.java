package com.rtc.service;

import com.rtc.bean.BaseQuestionBean;
import com.rtc.bean.QuesSetBean;

import java.util.List;

public interface SetService {

    public QuesSetBean createQuesSet(QuesSetBean quesSetBean);

    public List<QuesSetBean> getSetListByClassId(int classId);

    public QuesSetBean getSetById(int quesSetId);

    public QuesSetBean getSetAndQuesById(int quesSetId);

    public BaseQuestionBean getQuesByTypeAndId(String quesType, int quesId);

    public int assignSetToClasses(int[] classIds, int quesSetId);

    public List<QuesSetBean> getSetIdsByClassId(int classId);

}
