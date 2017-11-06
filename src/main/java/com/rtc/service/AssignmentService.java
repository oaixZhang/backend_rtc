package com.rtc.service;

import com.rtc.dao.AssignmentMapper;
import com.rtc.utils.LogUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssignmentService {
    @Autowired
    private AssignmentMapper assignmentMapper;

    public int assignToClasses(int[] classIds) {
        for (int classId : classIds) {
            if (assignmentMapper.assignToClass(classId) == 1) {
                LogUtils.info("insert succeed");
            } else {
                LogUtils.info("insert failed");
            }
        }
        return 0;
    }

}
