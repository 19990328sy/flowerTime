package com.ruoyi.web.controller.work;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.work.admin.StorageSupplier;
import com.ruoyi.work.service.StorageSupplierService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Api("供应商表")
@RestController
@RequestMapping("/work/supplier")
public class StorageSupplierController extends BaseController {
    @Autowired
    private StorageSupplierService supplierService;

    @Log(title = "新增供应商", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    public AjaxResult add(@RequestBody StorageSupplier supplier)
    {
        return toAjax(supplierService.add(supplier));
    }

    @Log(title = "修改供应商", businessType = BusinessType.UPDATE)
    @PostMapping("/update")
    public AjaxResult update(@RequestBody StorageSupplier supplier)
    {
        return toAjax(supplierService.update(supplier));
    }

    @Log(title = "删除供应商", businessType = BusinessType.DELETE)
    @PostMapping("/del")
    public AjaxResult del(Long[] ids)
    {
        return toAjax(supplierService.del(ids));
    }

    @Log(title = "供应商列表查询", businessType = BusinessType.EXPORT)
    @GetMapping("/list")
    public AjaxResult storageList(StorageSupplier supplier)
    {
        return AjaxResult.success(supplierService.supplierList(supplier));
    }
}
