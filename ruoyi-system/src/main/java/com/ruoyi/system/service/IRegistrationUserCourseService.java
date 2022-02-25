package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.RegistrationUserCourse;

/**
 * 学生报名课程Service接口
 * 
 * @author ruoyi
 * @date 2022-02-16
 */
public interface IRegistrationUserCourseService 
{
    /**
     * 查询学生报名课程
     * 
     * @param id 学生报名课程主键
     * @return 学生报名课程
     */
    public RegistrationUserCourse selectRegistrationUserCourseById(Long id);

    /**
     * 查询学生报名课程列表
     * 
     * @param registrationUserCourse 学生报名课程
     * @return 学生报名课程集合
     */
    public List<RegistrationUserCourse> selectRegistrationUserCourseList(RegistrationUserCourse registrationUserCourse);

    /**
     * 查询我的报名课程列表
     *
     * @param registrationUserCourse 学生报名课程
     * @return 学生报名课程集合
     */
    public List<RegistrationUserCourse> selectMyCourseList(RegistrationUserCourse registrationUserCourse);
    /**
     * 新增学生报名课程
     * 
     * @param registrationUserCourse 学生报名课程
     * @return 结果
     */
    public int insertRegistrationUserCourse(RegistrationUserCourse registrationUserCourse);

    /**
     * 修改学生报名课程
     * 
     * @param registrationUserCourse 学生报名课程
     * @return 结果
     */
    public int updateRegistrationUserCourse(RegistrationUserCourse registrationUserCourse);

    /**
     * 批量删除学生报名课程
     * 
     * @param ids 需要删除的学生报名课程主键集合
     * @return 结果
     */
    public int deleteRegistrationUserCourseByIds(String ids);

    /**
     * 删除学生报名课程信息
     * 
     * @param id 学生报名课程主键
     * @return 结果
     */
    public int deleteRegistrationUserCourseById(Long id);
}
