package com.ruoyi.web.controller.work;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.work.admin.StorageCustomer;
import com.ruoyi.work.admin.StorageItem;
import com.ruoyi.work.service.StorageCustomerService;
import com.ruoyi.work.service.StorageItemService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Api("物料表")
@RestController
@RequestMapping("/work/item")
public class StorageItemController extends BaseController {
    @Autowired
    private StorageItemService itemService;

    @Log(title = "新增物料", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    public AjaxResult add(@RequestBody StorageItem item)
    {
        return toAjax(itemService.add(item));
    }

    @Log(title = "修改物料", businessType = BusinessType.UPDATE)
    @PostMapping("/update")
    public AjaxResult update(@RequestBody StorageItem item)
    {
        return toAjax(itemService.update(item));
    }

    @Log(title = "删除物料", businessType = BusinessType.DELETE)
    @PostMapping("/del")
    public AjaxResult del(Long[] ids)
    {
        return toAjax(itemService.del(ids));
    }

    @Log(title = "物料列表查询", businessType = BusinessType.EXPORT)
    @GetMapping("/list")
    public AjaxResult storageList(StorageItem item)
    {
        return AjaxResult.success(itemService.itemList(item));
    }
}
