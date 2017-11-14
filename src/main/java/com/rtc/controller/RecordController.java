package com.rtc.controller;

import com.rtc.bean.MyResponse;
import com.rtc.bean.StuQuesRecordBean;
import com.rtc.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class RecordController {
    @Autowired
    private RecordService recordService;

    @ResponseBody
    @RequestMapping(value = "/record/stuQuesAnswer", method = RequestMethod.POST)
    public Map<String, Object> insertRecord(StuQuesRecordBean stuQuesRecordBean) {
        System.out.println(stuQuesRecordBean.toString());
        return MyResponse.sResponse(recordService.insertRecord(stuQuesRecordBean));
    }

    @ResponseBody
    @RequestMapping(value = "/record/stuQuesAnswer", method = RequestMethod.GET)
    public Map<String, Object> getRecord(StuQuesRecordBean stuQuesRecordBean) {
        System.out.println(stuQuesRecordBean.toString());
        return MyResponse.sResponse(recordService.getRecordByStuIdQuesIdSetId(stuQuesRecordBean));
    }

    @ResponseBody
    @RequestMapping(value = "/record/stuQuesAnswer",method = RequestMethod.PUT)
    public Map<String,Object> updateRecord(StuQuesRecordBean stuQuesRecordBean){
        return MyResponse.sResponse(0);
    }
}
