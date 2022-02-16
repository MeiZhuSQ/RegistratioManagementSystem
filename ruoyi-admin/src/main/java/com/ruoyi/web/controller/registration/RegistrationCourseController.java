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
import com.ruoyi.system.domain.RegistrationCourse;
import com.ruoyi.system.service.IRegistrationCourseService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 报名课程Controller
 * 
 * @author ruoyi
 * @date 2022-02-16
 */
@Controller
@RequestMapping("/system/course")
public class RegistrationCourseController extends BaseController
{
    private String prefix = "system/course";

    @Autowired
    private IRegistrationCourseService registrationCourseService;

    @RequiresPermissions("system:course:view")
    @GetMapping()
    public String course()
    {
        return prefix + "/course";
    }

    /**
     * 查询报名课程列表
     */
    @RequiresPermissions("system:course:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(RegistrationCourse registrationCourse)
    {
        startPage();
        List<RegistrationCourse> list = registrationCourseService.selectRegistrationCourseList(registrationCourse);
        return getDataTable(list);
    }

    /**
     * 导出报名课程列表
     */
    @RequiresPermissions("system:course:export")
    @Log(title = "报名课程", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(RegistrationCourse registrationCourse)
    {
        List<RegistrationCourse> list = registrationCourseService.selectRegistrationCourseList(registrationCourse);
        ExcelUtil<RegistrationCourse> util = new ExcelUtil<RegistrationCourse>(RegistrationCourse.class);
        return util.exportExcel(list, "报名课程数据");
    }

    /**
     * 新增报名课程
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存报名课程
     */
    @RequiresPermissions("system:course:add")
    @Log(title = "报名课程", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(RegistrationCourse registrationCourse)
    {
        return toAjax(registrationCourseService.insertRegistrationCourse(registrationCourse));
    }

    /**
     * 修改报名课程
     */
    @RequiresPermissions("system:course:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        RegistrationCourse registrationCourse = registrationCourseService.selectRegistrationCourseById(id);
        mmap.put("registrationCourse", registrationCourse);
        return prefix + "/edit";
    }

    /**
     * 修改保存报名课程
     */
    @RequiresPermissions("system:course:edit")
    @Log(title = "报名课程", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(RegistrationCourse registrationCourse)
    {
        return toAjax(registrationCourseService.updateRegistrationCourse(registrationCourse));
    }

    /**
     * 删除报名课程
     */
    @RequiresPermissions("system:course:remove")
    @Log(title = "报名课程", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(registrationCourseService.deleteRegistrationCourseByIds(ids));
    }
}
