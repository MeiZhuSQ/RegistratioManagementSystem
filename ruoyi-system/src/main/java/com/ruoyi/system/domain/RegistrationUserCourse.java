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

    /** 学生姓名 */
    @Excel(name = "用户id")
    private String userName;

    /** 课程id */
    @Excel(name = "课程id")
    private String courseId;

    /** 报名状态 0未报名 1已报名 */
    @Excel(name = "报名状态 0未报名 1已报名")
    private String registrationStatus;

    /** 课程名称 */
    @Excel(name = "课程名称")
    private String courseName;

    /** 课程学分 */
    @Excel(name = "课程学分")
    private String courseScore;

    /** 是否是必修课程 0选修 1必修 */
    @Excel(name = "是否是必修课程 0选修 1必修")
    private String courseRequired;

    /** 教师ID */
    @Excel(name = "教师ID")
    private Long teacherId;

    /** 教师姓名 */
    @Excel(name = "教师姓名")
    private String teacherName;

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

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseScore() {
        return courseScore;
    }

    public void setCourseScore(String courseScore) {
        this.courseScore = courseScore;
    }

    public String getCourseRequired() {
        return courseRequired;
    }

    public void setCourseRequired(String courseRequired) {
        this.courseRequired = courseRequired;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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
