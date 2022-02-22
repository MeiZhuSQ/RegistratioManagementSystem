package com.ruoyi.system.service.impl;

import java.util.List;

import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.ShiroUtils;
import com.ruoyi.system.domain.RegistrationUserCourse;
import com.ruoyi.system.mapper.RegistrationUserCourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.RegistrationCourseMapper;
import com.ruoyi.system.domain.RegistrationCourse;
import com.ruoyi.system.service.IRegistrationCourseService;
import com.ruoyi.common.core.text.Convert;

/**
 * 报名课程Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-02-22
 */
@Service
public class RegistrationCourseServiceImpl implements IRegistrationCourseService 
{
    @Autowired
    private RegistrationCourseMapper registrationCourseMapper;

    @Autowired
    private RegistrationUserCourseMapper registrationUserCourseMapper;

    /**
     * 查询报名课程
     * 
     * @param id 报名课程主键
     * @return 报名课程
     */
    @Override
    public RegistrationCourse selectRegistrationCourseById(Long id)
    {
        return registrationCourseMapper.selectRegistrationCourseById(id);
    }

    /**
     * 查询报名课程列表
     * 
     * @param registrationCourse 报名课程
     * @return 报名课程
     */
    @Override
    public List<RegistrationCourse> selectRegistrationCourseList(RegistrationCourse registrationCourse)
    {
        return registrationCourseMapper.selectRegistrationCourseList(registrationCourse);
    }

    /**
     * 新增报名课程
     * 
     * @param registrationCourse 报名课程
     * @return 结果
     */
    @Override
    public int insertRegistrationCourse(RegistrationCourse registrationCourse)
    {
        registrationCourse.setCreateTime(DateUtils.getNowDate());
        return registrationCourseMapper.insertRegistrationCourse(registrationCourse);
    }

    /**
     * 修改报名课程
     * 
     * @param registrationCourse 报名课程
     * @return 结果
     */
    @Override
    public int updateRegistrationCourse(RegistrationCourse registrationCourse)
    {
        registrationCourse.setUpdateTime(DateUtils.getNowDate());
        return registrationCourseMapper.updateRegistrationCourse(registrationCourse);
    }

    /**
     * 批量删除报名课程
     * 
     * @param ids 需要删除的报名课程主键
     * @return 结果
     */
    @Override
    public int deleteRegistrationCourseByIds(String ids)
    {
        return registrationCourseMapper.deleteRegistrationCourseByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除报名课程信息
     * 
     * @param id 报名课程主键
     * @return 结果
     */
    @Override
    public int deleteRegistrationCourseById(Long id)
    {
        return registrationCourseMapper.deleteRegistrationCourseById(id);
    }

    /**
     * 我要报名
     *
     * @param id
     * @return 结果
     */
    @Override
    public int signUpCourse(String id) {
        RegistrationUserCourse registrationUserCourse = new RegistrationUserCourse();
        registrationUserCourse.setCourseId(id);
        SysUser currentUser = ShiroUtils.getSysUser();
        registrationUserCourse.setUserId(String.valueOf(currentUser.getUserId()));
        registrationUserCourse.setCreateTime(DateUtils.getNowDate());
        registrationUserCourse.setCreateBy(currentUser.getLoginName());
        return registrationUserCourseMapper.insertRegistrationUserCourse(registrationUserCourse);
    }
}
