package com.ruoyi.web.controller.work;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.work.admin.StorageItem;
import com.ruoyi.work.admin.StorageItemtype;
import com.ruoyi.work.service.StorageItemService;
import com.ruoyi.work.service.StorageItemTypeService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Api("物料类型")
@RestController
@RequestMapping("/work/itemType")
public class StorageItemTypeController extends BaseController {
    @Autowired
    private StorageItemTypeService itemTypeService;

    @Log(title = "新增物料类型", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    public AjaxResult add(@RequestBody StorageItemtype itemtype)
    {
        return toAjax(itemTypeService.add(itemtype));
    }

    @Log(title = "修改物料类型", businessType = BusinessType.UPDATE)
    @PostMapping("/update")
    public AjaxResult update(@RequestBody StorageItemtype itemtype)
    {
        return toAjax(itemTypeService.update(itemtype));
    }

    @Log(title = "删除物料类型", businessType = BusinessType.DELETE)
    @PostMapping("/del")
    public AjaxResult del(Long[] ids)
    {
        return toAjax(itemTypeService.del(ids));
    }

    @Log(title = "物料类型列表查询", businessType = BusinessType.EXPORT)
    @GetMapping("/list")
    public AjaxResult storageList(StorageItemtype itemtype)
    {
        return AjaxResult.success(itemTypeService.itemtypeList(itemtype));
    }
}
