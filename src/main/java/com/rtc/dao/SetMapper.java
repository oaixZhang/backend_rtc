package com.rtc.dao;

import com.rtc.bean.BaseQuestionBean;
import com.rtc.bean.QuesSetBean;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface SetMapper {
    public int createQuesSet(QuesSetBean quesSetBean);

    public int insertQuesIntoSet(@Param("quesSetId") int quesSetId, @Param("questionBean") BaseQuestionBean baseQuestionBean);

    public QuesSetBean getQuesSetById(int quesSetId);

    public int assignSetToClass(@Param("quesSetId") int quesSetId, @Param("classId") int classId, @Param("date") Date time);

    public int[] getSetIdsByClassId(int classId);
}
