package com.rtc.service.impl;

import com.rtc.bean.BaseQuestionBean;
import com.rtc.bean.QuesSetBean;
import com.rtc.bean.StuQuesRecordBean;
import com.rtc.bean.StuSetRecordBean;
import com.rtc.dao.RecordMapper;
import com.rtc.service.RecordService;
import com.rtc.service.SetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service("recordSerivice")
public class RecordServiceImpl implements RecordService {
    @Autowired
    private RecordMapper recordMapper;
    @Autowired
    private SetService setService;

    @Override
    public int insertRecord(StuQuesRecordBean stuQuesRecordBean) {
        return recordMapper.insertRecord(stuQuesRecordBean);
    }

    @Override
    public int insertSetRecord(List<StuQuesRecordBean> list) {

        for (StuQuesRecordBean quesRecord : list) {
            recordMapper.insertRecord(quesRecord);
        }
        return recordMapper.insertSetRecord(list.get(0).getStuId(), list.get(0).getSetId(), new Date());
    }

    @Override
    public StuQuesRecordBean getRecordByStuIdQuesIdSetId(StuQuesRecordBean stuQuesRecordBean) {
        return recordMapper.getRecordByStuIdQuesIdSetId(stuQuesRecordBean);
    }

    @Override
    public QuesSetBean getStuSetRecord(int stuId, int quesSetId) {
        List<StuQuesRecordBean> list = recordMapper.getStuSetRecord(stuId, quesSetId);
        QuesSetBean quesSetBean = new QuesSetBean();
        List<BaseQuestionBean> set = new ArrayList<>();
        for (StuQuesRecordBean recordBean : list) {
            BaseQuestionBean baseQuestionBean = setService.getQuesByTypeAndId(recordBean.getType(), recordBean.getQuesId());
            baseQuestionBean.setAnswer(recordBean.getContent());
            set.add(baseQuestionBean);
        }
        quesSetBean.setSetId(quesSetId);
        quesSetBean.setQuesList(set);
        return quesSetBean;
    }

    @Override
    public List<StuSetRecordBean> getStuSetRecordByStuId(int stuId) {
        List<StuSetRecordBean> list = recordMapper.getStuSetRecordByStuId(stuId);
        return list;
    }

    @Override
    public List<StuSetRecordBean> getStuSetRecordByClassIdAndSetId(int classId, int quesSetId) {
        return recordMapper.getStuSetRecordByClassIdAndSetId(classId, quesSetId);
    }

    @Override
    public int updateQuesRecord(List<StuQuesRecordBean> list) {
        for (StuQuesRecordBean quesRecord : list) {
            recordMapper.updateQuesRecord(quesRecord);
        }
        return 1;
    }
}
