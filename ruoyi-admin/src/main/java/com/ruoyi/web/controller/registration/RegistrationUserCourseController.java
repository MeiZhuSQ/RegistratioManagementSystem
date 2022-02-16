package com.ruoyi.web.controller.registration;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.RegistrationUserCourse;
import com.ruoyi.system.service.IRegistrationUserCourseService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 学生报名课程Controller
 * 
 * @author ruoyi
 * @date 2022-02-16
 */
@Controller
@RequestMapping("/system/userCourse")
public class RegistrationUserCourseController extends BaseController
{
    private String prefix = "system/userCourse";

    @Autowired
    private IRegistrationUserCourseService registrationUserCourseService;

    @RequiresPermissions("system:userCourse:view")
    @GetMapping()
    public String userCourse()
    {
        return prefix + "/userCourse";
    }

    @RequiresPermissions("system:signUpCourse:view")
    @GetMapping("/signUpCourse")
    public String toSignUp()
    {
        return prefix + "/signUpCourse";
    }

    /**
     * 查询学生报名课程列表
     */
    @RequiresPermissions("system:userCourse:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(RegistrationUserCourse registrationUserCourse)
    {
        startPage();
        List<RegistrationUserCourse> list = registrationUserCourseService.selectRegistrationUserCourseList(registrationUserCourse);
        return getDataTable(list);
    }

    /**
     * 导出学生报名课程列表
     */
    @RequiresPermissions("system:userCourse:export")
    @Log(title = "学生报名课程", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(RegistrationUserCourse registrationUserCourse)
    {
        List<RegistrationUserCourse> list = registrationUserCourseService.selectRegistrationUserCourseList(registrationUserCourse);
        ExcelUtil<RegistrationUserCourse> util = new ExcelUtil<RegistrationUserCourse>(RegistrationUserCourse.class);
        return util.exportExcel(list, "学生报名课程数据");
    }

    /**
     * 新增学生报名课程
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存学生报名课程
     */
    @RequiresPermissions("system:userCourse:add")
    @Log(title = "学生报名课程", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(RegistrationUserCourse registrationUserCourse)
    {
        return toAjax(registrationUserCourseService.insertRegistrationUserCourse(registrationUserCourse));
    }

    /**
     * 修改学生报名课程
     */
    @RequiresPermissions("system:userCourse:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        RegistrationUserCourse registrationUserCourse = registrationUserCourseService.selectRegistrationUserCourseById(id);
        mmap.put("registrationUserCourse", registrationUserCourse);
        return prefix + "/edit";
    }

    /**
     * 修改保存学生报名课程
     */
    @RequiresPermissions("system:userCourse:edit")
    @Log(title = "学生报名课程", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(RegistrationUserCourse registrationUserCourse)
    {
        return toAjax(registrationUserCourseService.updateRegistrationUserCourse(registrationUserCourse));
    }

    /**
     * 删除学生报名课程
     */
    @RequiresPermissions("system:userCourse:remove")
    @Log(title = "学生报名课程", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(registrationUserCourseService.deleteRegistrationUserCourseByIds(ids));
    }
}
