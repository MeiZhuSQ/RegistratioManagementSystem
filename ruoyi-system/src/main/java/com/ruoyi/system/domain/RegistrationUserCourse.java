package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 学生报名课程对象 registration_user_course
 * 
 * @author ruoyi
 * @date 2022-02-16
 */
public class RegistrationUserCourse extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 参数主键 */
    private Long id;

    /** 用户id */
    @Excel(name = "用户id")
    private String userId;

    /** 课程id */
    @Excel(name = "课程id")
    private String courseId;

    /** 报名状态 0未报名 1已报名 */
    @Excel(name = "报名状态 0未报名 1已报名")
    private String registrationStatus;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setUserId(String userId) 
    {
        this.userId = userId;
    }

    public String getUserId() 
    {
        return userId;
    }
    public void setCourseId(String courseId) 
    {
        this.courseId = courseId;
    }

    public String getCourseId() 
    {
        return courseId;
    }
    public void setRegistrationStatus(String registrationStatus) 
    {
        this.registrationStatus = registrationStatus;
    }

    public String getRegistrationStatus() 
    {
        return registrationStatus;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userId", getUserId())
            .append("courseId", getCourseId())
            .append("registrationStatus", getRegistrationStatus())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
