package com.rtc.controller;

import com.rtc.bean.MyResponse;
import com.rtc.service.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class AssignmentController {
    @Autowired
    private AssignmentService assignmentService;

    @RequestMapping(value ="/assignment/class")
    @ResponseBody
    public Map<String, Object> assignSetToClasses(int[] classIds) {
        return MyResponse.sResponse(assignmentService.assignSetToClasses(classIds));
    }
}
