package com.rtc.service;

import com.rtc.bean.StuQuesRecordBean;
import com.rtc.dao.RecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecordService {
    @Autowired
    private RecordMapper recordMapper;

    public int insertRecord(StuQuesRecordBean stuQuesRecordBean) {
        return recordMapper.insertRecord(stuQuesRecordBean);
    }

    public StuQuesRecordBean getRecordByStuIdQuesIdSetId(StuQuesRecordBean stuQuesRecordBean) {
        return recordMapper.getRecordByStuIdQuesIdSetId(stuQuesRecordBean);
    }
    public int updateRecord(StuQuesRecordBean stuQuesRecordBean) {
        return recordMapper.updateRecord(stuQuesRecordBean);
    }
}
