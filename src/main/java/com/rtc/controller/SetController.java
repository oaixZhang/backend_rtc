package com.rtc.controller;

import com.rtc.bean.BaseQuestionBean;
import com.rtc.bean.MyResponse;
import com.rtc.bean.QuesSetBean;
import com.rtc.service.SetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Map;

@Controller
public class SetController {
    @Autowired
    private SetService setService;

    @RequestMapping(value = "/set", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> createQuestionSet(HashSet<BaseQuestionBean> set) {
        QuesSetBean quesSetBean = new QuesSetBean();
        quesSetBean.setQuesSet(set);
        return MyResponse.sResponse(setService.createQuesSet(quesSetBean));
    }

    @RequestMapping(value = "/set/{quesSetId}", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getQuesSetById(@PathVariable("quesSetId") int quesSetId) {

        return MyResponse.sResponse(setService.getQuesSetById(quesSetId));
    }

    @RequestMapping(value = "/set/class", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> assignSetToClasses(@RequestParam("classIds") int[] classIds,@RequestParam("quesSetId") int quesSetId) {
        return MyResponse.sResponse(setService.assignSetToClasses(classIds, quesSetId));
    }

    @RequestMapping(value = "/set/class/{classId}", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getSetByClassId(@PathVariable("classId") int classId) {
        return MyResponse.sResponse(setService.getSetByClassId(classId));
    }

}
