package com.ruoyi.work.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ruoyi.work.admin.Storage;
import com.ruoyi.work.admin.StorageCarrier;

import java.util.List;

/**
 * 供应商信息
 */
public interface StorageCarrierService extends IService<StorageCarrier> {
    List<StorageCarrier> carrierList(StorageCarrier carrier);

    /**
     * 新增供应商
     * @param carrier
     * @return
     */
    int add(StorageCarrier carrier);

    /**
     * 修改供应商信息
     * @param carrier
     * @return
     */
    int update(StorageCarrier carrier);

    /**
     * 删除供应商
     * @param ids
     * @return
     */
    int del(Long[] ids);

}
