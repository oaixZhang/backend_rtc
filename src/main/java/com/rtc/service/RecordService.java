package com.rtc.service;

import com.rtc.bean.QuesSetBean;
import com.rtc.bean.StuQuesRecordBean;
import com.rtc.bean.StuSetRecordBean;

import java.util.List;

public interface RecordService {
    public int insertRecord(StuQuesRecordBean stuQuesRecordBean);

    public int insertSetRecord(List<StuQuesRecordBean> list);

    public StuQuesRecordBean getRecordByStuIdQuesIdSetId(StuQuesRecordBean stuQuesRecordBean);

    public QuesSetBean getStuSetRecord(int stuId, int quesSetId);

    public List<StuSetRecordBean> getStuSetRecordByStuId(int stuId);

    public List<StuSetRecordBean> getStuSetRecordByClassIdAndSetId(int classId, int quesSetId);

    public int updateQuesRecord(List<StuQuesRecordBean> list);
}
