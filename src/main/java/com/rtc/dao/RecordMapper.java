package com.rtc.dao;

import com.rtc.bean.StuQuesRecordBean;

public interface RecordMapper {
    public int insertRecord(StuQuesRecordBean stuQuesRecordBean);
    public StuQuesRecordBean getRecordByStuIdQuesIdSetId(StuQuesRecordBean stuQuesRecordBean);
    public int updateRecord(StuQuesRecordBean stuQuesRecordBean);

}
