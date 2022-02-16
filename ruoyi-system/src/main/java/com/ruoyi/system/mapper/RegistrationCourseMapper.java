package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.RegistrationCourse;

/**
 * 报名课程Mapper接口
 * 
 * @author ruoyi
 * @date 2022-02-16
 */
public interface RegistrationCourseMapper 
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
     * 删除报名课程
     * 
     * @param id 报名课程主键
     * @return 结果
     */
    public int deleteRegistrationCourseById(Long id);

    /**
     * 批量删除报名课程
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteRegistrationCourseByIds(String[] ids);
}
