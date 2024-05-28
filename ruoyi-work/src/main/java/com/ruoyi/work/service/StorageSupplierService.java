package com.ruoyi.work.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ruoyi.work.admin.Storage;
import com.ruoyi.work.admin.StorageSupplier;

import java.util.List;

public interface StorageSupplierService extends IService<StorageSupplier> {
    List<StorageSupplier> supplierList(StorageSupplier supplier);

    /**
     * 新增供应商信息
     * @param supplier
     * @return
     */
    int add(StorageSupplier supplier);

    /**
     * 修改供应商信息
     * @param supplier
     * @return
     */
    int update(StorageSupplier supplier);

    /**
     * 删除供应商
     * @param ids
     * @return
     */
    int del(Long[] ids);

}
