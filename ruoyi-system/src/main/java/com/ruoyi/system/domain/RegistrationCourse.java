package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 报名课程对象 registration_course
 * 
 * @author ruoyi
 * @date 2022-02-22
 */
public class RegistrationCourse extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 参数主键 */
    private Long id;

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

    /** 教师ID */
    @Excel(name = "教师姓名")
    private String teacherName;

    /** 课程状态（0正常 1停用） */
    @Excel(name = "课程状态", readConverterExp = "0=正常,1=停用")
    private String status;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setCourseName(String courseName) 
    {
        this.courseName = courseName;
    }

    public String getCourseName() 
    {
        return courseName;
    }
    public void setCourseScore(String courseScore) 
    {
        this.courseScore = courseScore;
    }

    public String getCourseScore() 
    {
        return courseScore;
    }
    public void setCourseRequired(String courseRequired) 
    {
        this.courseRequired = courseRequired;
    }

    public String getCourseRequired() 
    {
        return courseRequired;
    }
    public void setTeacherId(Long teacherId) 
    {
        this.teacherId = teacherId;
    }

    public Long getTeacherId() 
    {
        return teacherId;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("courseName", getCourseName())
            .append("courseScore", getCourseScore())
            .append("courseRequired", getCourseRequired())
            .append("teacherId", getTeacherId())
            .append("status", getStatus())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .append("createBy", getCreateBy())
            .toString();
    }
}
