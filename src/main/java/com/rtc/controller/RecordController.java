package com.rtc.controller;

import com.rtc.bean.MyResponse;
import com.rtc.bean.StuQuesRecordBean;
import com.rtc.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class RecordController {
    @Autowired
    private RecordService recordService;

    /**
     * 添加一条学生做题记录
     *
     * @param stuQuesRecordBean 学生的做题记录，包括题目Id、题目类型、学生答案等
     */
    @ResponseBody
    @RequestMapping(value = "/record/stuQuesAnswer", method = RequestMethod.POST)
    public Map<String, Object> insertRecord(StuQuesRecordBean stuQuesRecordBean) {
        System.out.println(stuQuesRecordBean.toString());
        return MyResponse.sResponse(recordService.insertRecord(stuQuesRecordBean));
    }

    /**
     * 查询一条学生做题记录,通过 stuId、quesId、quesSetId 定位
     *
     * @param stuQuesRecordBean
     */
    @ResponseBody
    @RequestMapping(value = "/record/stuQuesAnswer", method = RequestMethod.GET)
    public Map<String, Object> getRecord(StuQuesRecordBean stuQuesRecordBean) {
        return MyResponse.sResponse(recordService.getRecordByStuIdQuesIdSetId(stuQuesRecordBean));
    }

    @ResponseBody
    @RequestMapping(value = "/record/stuQuesAnswer/quesSetId={quesSetId}/stuId={stuId}/quesId={quesId}", method = RequestMethod.GET)
    public Map<String, Object> getOneQuesRecord(@PathVariable int stuId, @PathVariable int quesSetId, @PathVariable int quesId) {
        StuQuesRecordBean recordBean = new StuQuesRecordBean();
        recordBean.setQuesId(quesId);
        recordBean.setStuId(stuId);
        recordBean.setSetId(quesSetId);
        return MyResponse.sResponse(recordService.getRecordByStuIdQuesIdSetId(recordBean));
    }

    /**
     * 查询学生某次作业的全部答题记录
     *
     * @param stuId     学生Id
     * @param quesSetId 题集Id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/record/stuSetAnswer/quesSetId={quesSetId}/stuId={stuId}", method = RequestMethod.GET)
    public Map<String, Object> getStuSetRecord(@PathVariable int stuId, @PathVariable int quesSetId) {
        return MyResponse.sResponse(recordService.getStuSetRecord(stuId, quesSetId));
    }
    /**
     * 查询学生的全部作业记录
     *
     * @param stuId     学生Id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/record/stuSetAnswer/stuId={stuId}", method = RequestMethod.GET)
    public Map<String, Object> getStuSetRecord(@PathVariable int stuId) {
        return MyResponse.sResponse(recordService.getStuSetRecordByStuId(stuId));
    }

    /**
     * 老师使用
     * 根据classId和quesSetId获取某班全部学生某次作业的情况
     *
     * @param classId   目标班级的Id
     * @param quesSetId 题集的Id
     */
    @RequestMapping(value = "/record/set/classId={classId}/quesSetId={quesSetId}", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getStuSetRecordByClassIdAndSetId(@PathVariable("classId") int classId, @PathVariable int quesSetId) {

        return MyResponse.sResponse(recordService.getStuSetRecordByClassIdAndSetId(classId, quesSetId));
    }

    /**
     * 添加学生一次作业的记录
     * 在set_ques_record表中添加纪录（每道题目的学生回答），在stu_set_record表中添加一条学生提交过作业的记录
     * @param list
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/record/stuSetRecord", method = RequestMethod.POST)
    public Map<String, Object> insertSetRecord(List<StuQuesRecordBean> list) {
        return MyResponse.sResponse(recordService.insertSetRecord(list));
    }

    /**
     * 老师使用
     * 批改学生作业，修改stu_ques_record表中每条记录的flag字段，1表示正确，2错误
     * @param list 传入要修改的记录，flag为有效字段，其他用于定位
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/record/updateQuesRecord", method = RequestMethod.PUT)
    public Map<String, Object> updateQuesRecord(List<StuQuesRecordBean> list) {
        return MyResponse.sResponse(recordService.updateQuesRecord(list));
    }
}
