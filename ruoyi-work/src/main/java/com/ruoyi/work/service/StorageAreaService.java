package com.ruoyi.work.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ruoyi.work.admin.Storage;
import com.ruoyi.work.admin.StorageArea;

import java.util.List;

public interface StorageAreaService extends IService<StorageArea> {
    List<StorageArea> areList(StorageArea storageArea);

    /**
     * 新增库区信息
     * @param storageArea
     * @return
     */
    int add(StorageArea storageArea);

    /**
     * 修改库区信息
     * @param storageArea
     * @return
     */
    int update(StorageArea storageArea);

    /**
     * 删除库区
     * @param ids
     * @return
     */
    int del(Long[] ids);

}
