package com.ruoyi.web.controller.work;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.work.admin.StorageCustomer;
import com.ruoyi.work.service.StorageCustomerService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Api("客户表")
@RestController
@RequestMapping("/work/customer")
public class StorageCustomerController extends BaseController {
    @Autowired
    private StorageCustomerService customerService;

    @Log(title = "新增客户", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    public AjaxResult add(@RequestBody StorageCustomer customer)
    {
        return toAjax(customerService.add(customer));
    }

    @Log(title = "修改客户", businessType = BusinessType.UPDATE)
    @PostMapping("/update")
    public AjaxResult update(@RequestBody StorageCustomer customer)
    {
        return toAjax(customerService.update(customer));
    }

    @Log(title = "删除客户", businessType = BusinessType.DELETE)
    @PostMapping("/del")
    public AjaxResult del(Long[] ids)
    {
        return toAjax(customerService.del(ids));
    }

    @Log(title = "客户列表查询", businessType = BusinessType.EXPORT)
    @GetMapping("/list")
    public AjaxResult storageList(StorageCustomer customer)
    {
        return AjaxResult.success(customerService.customerList(customer));
    }
}
