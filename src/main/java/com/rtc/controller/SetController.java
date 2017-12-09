package com.rtc.controller;

import com.rtc.bean.BaseQuestionBean;
import com.rtc.bean.MyResponse;
import com.rtc.bean.QuesSetBean;
import com.rtc.service.SetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 题集相关（或称为作业）
 */
@Controller
public class SetController {
    @Autowired
    private SetService setService;

    /**
     * 创建一个题目集
     *
     * @param list 题目的集合
     * @return HashMap 返回创建成功的题集
     */
    @RequestMapping(value = "/set", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> createQuestionSet(List<BaseQuestionBean> list) {
        QuesSetBean quesSetBean = new QuesSetBean();
        quesSetBean.setQuesList(list);
        return MyResponse.sResponse(setService.createQuesSet(quesSetBean));
    }

    /**
     * 获取指定Id的题集（包括题目）
     *
     * @param quesSetId
     */
    @RequestMapping(value = "/set/{quesSetId}", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getSetAndQuesById(@PathVariable("quesSetId") int quesSetId) {

        return MyResponse.sResponse(setService.getSetAndQuesById(quesSetId));
    }

    /**
     * 将题集（作业）布置给指定Id的班级
     *
     * @param classIds  int数组，目标班级Id的数组
     * @param quesSetId 题集的Id
     */
    @RequestMapping(value = "/set/class", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> assignSetToClasses(@RequestParam("classIds") int[] classIds, @RequestParam("quesSetId") int quesSetId) {
        return MyResponse.sResponse(setService.assignSetToClasses(classIds, quesSetId));
    }

    /**
     * 获取留给指定班级的所有题集（作业）列表
     *
     * @param classId 目标班级的Id
     */
    @RequestMapping(value = "/set/class/{classId}", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getSetListByClassId(@PathVariable("classId") int classId) {
        return MyResponse.sResponse(setService.getSetListByClassId(classId));
    }

}
