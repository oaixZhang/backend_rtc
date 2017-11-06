package com.rtc.controller;

import com.rtc.bean.MyResponse;
import com.rtc.service.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Map;

@Controller
public class AssignmentController {
    @Autowired
    private AssignmentService assignmentService;

    public Map<String, Object> assignToClasses(int[] classIds) {
        return MyResponse.sResponse(assignmentService.assignToClasses(classIds));
    }
}
