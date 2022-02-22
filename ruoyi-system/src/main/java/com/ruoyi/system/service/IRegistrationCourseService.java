package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.RegistrationCourse;

/**
 * 报名课程Service接口
 * 
 * @author ruoyi
 * @date 2022-02-22
 */
public interface IRegistrationCourseService 
{
    /**
     * 查询报名课程
     * 
     * @param id 报名课程主键
     * @return 报名课程
     */
    public RegistrationCourse selectRegistrationCourseById(Long id);

    /**
     * 查询报名课程列表
     * 
     * @param registrationCourse 报名课程
     * @return 报名课程集合
     */
    public List<RegistrationCourse> selectRegistrationCourseList(RegistrationCourse registrationCourse);

    /**
     * 新增报名课程
     * 
     * @param registrationCourse 报名课程
     * @return 结果
     */
    public int insertRegistrationCourse(RegistrationCourse registrationCourse);

    /**
     * 修改报名课程
     * 
     * @param registrationCourse 报名课程
     * @return 结果
     */
    public int updateRegistrationCourse(RegistrationCourse registrationCourse);

    /**
     * 批量删除报名课程
     * 
     * @param ids 需要删除的报名课程主键集合
     * @return 结果
     */
    public int deleteRegistrationCourseByIds(String ids);

    /**
     * 删除报名课程信息
     * 
     * @param id 报名课程主键
     * @return 结果
     */
    public int deleteRegistrationCourseById(Long id);

    /**
     * 我要报名
     *
     * @param id
     * @return 结果
     */
    public int signUpCourse(String id);
}
