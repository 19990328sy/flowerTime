package com.ruoyi.web.controller.work;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.work.admin.Storage;
import com.ruoyi.work.admin.StorageCarrier;
import com.ruoyi.work.service.StorageCarrierService;
import com.ruoyi.work.service.StorageService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Api("供应商")
@RestController
@RequestMapping("/work/carrier")
public class StorageCarrierController extends BaseController {
    @Autowired
    private StorageCarrierService carrierService;

    @Log(title = "新增供应商", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    public AjaxResult add(@RequestBody StorageCarrier carrier)
    {
        return toAjax(carrierService.add(carrier));
    }

    @Log(title = "修改供应商", businessType = BusinessType.UPDATE)
    @PostMapping("/update")
    public AjaxResult update(@RequestBody StorageCarrier carrier)
    {
        return toAjax(carrierService.update(carrier));
    }

    @Log(title = "删除供应商", businessType = BusinessType.DELETE)
    @PostMapping("/del")
    public AjaxResult del(Long[] ids)
    {
        return toAjax(carrierService.del(ids));
    }

    @Log(title = "供应商列表查询", businessType = BusinessType.EXPORT)
    @GetMapping("/list")
    public AjaxResult storageList(StorageCarrier carrier)
    {
        return AjaxResult.success(carrierService.carrierList(carrier));
    }
}
