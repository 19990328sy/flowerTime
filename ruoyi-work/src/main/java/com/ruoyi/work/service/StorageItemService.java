package com.ruoyi.work.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ruoyi.work.admin.Storage;
import com.ruoyi.work.admin.StorageItem;

import java.util.List;

public interface StorageItemService extends IService<StorageItem> {
    List<StorageItem> itemList(StorageItem item);

    /**
     * 新增物料信息
     * @param item
     * @return
     */
    int add(StorageItem item);

    /**
     * 修改物料信息
     * @param item
     * @return
     */
    int update(StorageItem item);

    /**
     * 删除物料
     * @param ids
     * @return
     */
    int del(Long[] ids);

}
