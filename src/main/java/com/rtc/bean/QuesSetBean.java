package com.rtc.bean;

import java.util.Date;
import java.util.List;

public class QuesSetBean {
    private int setId;
    private int teacherId;
    private String remark;
    private Date createtime;

    private List<BaseQuestionBean> quesList;

    public QuesSetBean() {
    }

    public int getSetId() {
        return setId;
    }

    public void setSetId(int setId) {
        this.setId = setId;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public List<BaseQuestionBean> getQuesList() {
        return quesList;
    }

    public void setQuesList(List<BaseQuestionBean> quesList) {
        this.quesList = quesList;
    }
}
