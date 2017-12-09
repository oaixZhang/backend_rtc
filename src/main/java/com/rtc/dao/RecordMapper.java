package com.rtc.dao;

import com.rtc.bean.StuQuesRecordBean;
import com.rtc.bean.StuSetRecordBean;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface RecordMapper {
    public int insertRecord(StuQuesRecordBean stuQuesRecordBean);

    public int insertSetRecord(@Param("stuId") int stuId, @Param("quesSetId") int quesSetId, @Param("date") Date date);

    public StuQuesRecordBean getRecordByStuIdQuesIdSetId(StuQuesRecordBean stuQuesRecordBean);

    public List<StuQuesRecordBean> getStuSetRecord(@Param("stuId") int stuId, @Param("quesSetId") int quesSetId);

    public List<StuSetRecordBean> getStuSetRecordByClassIdAndSetId(@Param("classId") int classId, @Param("quesSetId") int quesSetId);

    public int updateQuesRecord(StuQuesRecordBean stuQuesRecordBean);

}
