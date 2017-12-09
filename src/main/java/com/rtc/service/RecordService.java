package com.rtc.service;

import com.rtc.bean.BaseQuestionBean;
import com.rtc.bean.QuesSetBean;
import com.rtc.bean.StuQuesRecordBean;
import com.rtc.bean.StuSetRecordBean;
import com.rtc.dao.RecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class RecordService {
    @Autowired
    private RecordMapper recordMapper;
    @Autowired
    private SetService setService;

    public int insertRecord(StuQuesRecordBean stuQuesRecordBean) {
        return recordMapper.insertRecord(stuQuesRecordBean);
    }

    public int insertSetRecord(List<StuQuesRecordBean> list) {

        for (StuQuesRecordBean quesRecord : list) {
            recordMapper.insertRecord(quesRecord);
        }
        return recordMapper.insertSetRecord(list.get(0).getStuId(), list.get(0).getQuesSetId(), new Date());
    }

    public StuQuesRecordBean getRecordByStuIdQuesIdSetId(StuQuesRecordBean stuQuesRecordBean) {
        return recordMapper.getRecordByStuIdQuesIdSetId(stuQuesRecordBean);
    }

    public QuesSetBean getStuSetRecord(int stuId, int quesSetId) {
        List<StuQuesRecordBean> list = recordMapper.getStuSetRecord(stuId, quesSetId);
        QuesSetBean quesSetBean = new QuesSetBean();
        List<BaseQuestionBean> set = new ArrayList<>();
        for (StuQuesRecordBean recordBean : list) {
            BaseQuestionBean baseQuestionBean = setService.getQuesByTypeAndId(recordBean.getQuesType(), recordBean.getQuesId());
            baseQuestionBean.setAnswer(recordBean.getStuAnswer());
            set.add(baseQuestionBean);
        }
        quesSetBean.setQuesSetId(quesSetId);
        quesSetBean.setQuesList(set);
        return quesSetBean;
    }

    public List<StuSetRecordBean> getStuSetRecordByClassIdAndSetId(int classId, int quesSetId) {
        return recordMapper.getStuSetRecordByClassIdAndSetId(classId, quesSetId);
    }

    public int updateQuesRecord(List<StuQuesRecordBean> list) {
        for (StuQuesRecordBean quesRecord : list) {
            recordMapper.updateQuesRecord(quesRecord);
        }
        return 1;
    }
}
