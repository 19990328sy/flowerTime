package com.ruoyi.web.controller.work;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.work.admin.Storage;
import com.ruoyi.work.service.StorageService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api("仓库表")
@RequestMapping(value = "/work/storage")
@RestController
public class StorageController extends BaseController {

    @Autowired
    private StorageService storageService;

    @Log(title = "新增仓库", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    public AjaxResult add(@Validated @RequestBody Storage storage)
    {
        return toAjax(storageService.add(storage));
    }

    @Log(title = "修改仓库", businessType = BusinessType.INSERT)
    @PostMapping("/update")
    public AjaxResult update(@Validated @RequestBody Storage storage)
    {
        return toAjax(storageService.update(storage));
    }

    @Log(title = "删除仓库", businessType = BusinessType.INSERT)
    @PostMapping("/del")
    public AjaxResult del(@Validated @RequestBody Long[] ids)
    {
        return toAjax(storageService.del(ids));
    }

    @Log(title = "仓库列表查询", businessType = BusinessType.INSERT)
    @PostMapping("/list")
    public AjaxResult storageList(@Validated @RequestBody Storage storage)
    {
        return AjaxResult.success(storageService.storageList(storage));
    }
}
