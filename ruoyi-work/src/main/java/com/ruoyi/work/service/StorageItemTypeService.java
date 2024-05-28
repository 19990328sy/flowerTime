package com.ruoyi.work.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ruoyi.work.admin.Storage;
import com.ruoyi.work.admin.StorageItemtype;

import java.util.List;

public interface StorageItemTypeService extends IService<StorageItemtype> {
    List<StorageItemtype> itemtypeList(StorageItemtype itemtype);

    /**
     * 新增物料类型信息
     * @param itemtype
     * @return
     */
    int add(StorageItemtype itemtype);

    /**
     * 修改物料类型信息
     * @param itemtype
     * @return
     */
    int update(StorageItemtype itemtype);

    /**
     * 删除物料类型
     * @param ids
     * @return
     */
    int del(Long[] ids);

}
