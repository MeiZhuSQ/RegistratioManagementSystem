package com.ruoyi.system.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.ShiroUtils;
import com.ruoyi.system.domain.RegistrationCourse;
import com.ruoyi.system.mapper.RegistrationCourseMapper;
import com.ruoyi.system.mapper.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.RegistrationUserCourseMapper;
import com.ruoyi.system.domain.RegistrationUserCourse;
import com.ruoyi.system.service.IRegistrationUserCourseService;
import com.ruoyi.common.core.text.Convert;

/**
 * 学生报名课程Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-02-16
 */
@Service
public class RegistrationUserCourseServiceImpl implements IRegistrationUserCourseService 
{
    @Autowired
    private RegistrationUserCourseMapper registrationUserCourseMapper;

    @Autowired
    private RegistrationCourseMapper registrationCourseMapper;

    @Autowired
    private SysUserMapper userMapper;

    /**
     * 查询学生报名课程
     * 
     * @param id 学生报名课程主键
     * @return 学生报名课程
     */
    @Override
    public RegistrationUserCourse selectRegistrationUserCourseById(Long id)
    {
        return registrationUserCourseMapper.selectRegistrationUserCourseById(id);
    }

    /**
     * 查询学生报名课程列表
     * 
     * @param registrationUserCourse 学生报名课程
     * @return 学生报名课程
     */
    @Override
    public List<RegistrationUserCourse> selectRegistrationUserCourseList(RegistrationUserCourse registrationUserCourse)
    {
        RegistrationCourse registrationCourse = new RegistrationCourse();
        Long userId = ShiroUtils.getUserId();
        registrationCourse.setTeacherId(userId);
        List<RegistrationCourse> registrationCourses = registrationCourseMapper.selectRegistrationCourseList(registrationCourse);
        List<Long> courseIds = registrationCourses.stream().map(RegistrationCourse::getId).collect(Collectors.toList());
        List<RegistrationUserCourse> registrationUserCourses = registrationUserCourseMapper.selectRegistrationUserCourseList(registrationUserCourse);
        List<RegistrationUserCourse> userCourses = registrationUserCourses.stream().filter(m -> courseIds.contains(Long.valueOf(m.getCourseId()))).collect(Collectors.toList());
        for (RegistrationUserCourse userCourse : userCourses) {
            for (RegistrationCourse course : registrationCourses) {
                if (userCourse.getCourseId().equals(String.valueOf(course.getId()))){
                    userCourse.setCourseName(course.getCourseName());
                    userCourse.setCourseScore(course.getCourseScore());
                    userCourse.setCourseRequired(course.getCourseRequired());
                    userCourse.setTeacherId(course.getTeacherId());
                    SysUser sysUser = userMapper.selectUserById(course.getTeacherId());
                    userCourse.setTeacherName(sysUser.getUserName());
                    SysUser user = userMapper.selectUserById(Long.parseLong(userCourse.getUserId()));
                    userCourse.setUserName(user.getUserName());
                }
            }
        }
        return userCourses;
    }

    /**
     * 新增学生报名课程
     * 
     * @param registrationUserCourse 学生报名课程
     * @return 结果
     */
    @Override
    public int insertRegistrationUserCourse(RegistrationUserCourse registrationUserCourse)
    {
        registrationUserCourse.setCreateTime(DateUtils.getNowDate());
        return registrationUserCourseMapper.insertRegistrationUserCourse(registrationUserCourse);
    }

    /**
     * 修改学生报名课程
     * 
     * @param registrationUserCourse 学生报名课程
     * @return 结果
     */
    @Override
    public int updateRegistrationUserCourse(RegistrationUserCourse registrationUserCourse)
    {
        registrationUserCourse.setUpdateTime(DateUtils.getNowDate());
        return registrationUserCourseMapper.updateRegistrationUserCourse(registrationUserCourse);
    }

    /**
     * 批量删除学生报名课程
     * 
     * @param ids 需要删除的学生报名课程主键
     * @return 结果
     */
    @Override
    public int deleteRegistrationUserCourseByIds(String ids)
    {
        return registrationUserCourseMapper.deleteRegistrationUserCourseByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除学生报名课程信息
     * 
     * @param id 学生报名课程主键
     * @return 结果
     */
    @Override
    public int deleteRegistrationUserCourseById(Long id)
    {
        return registrationUserCourseMapper.deleteRegistrationUserCourseById(id);
    }
}
