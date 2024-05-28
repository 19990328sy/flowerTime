package com.ruoyi.work.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ruoyi.work.admin.Storage;
import com.ruoyi.work.admin.StorageCustomer;

import java.util.List;

public interface StorageCustomerService extends IService<StorageCustomer> {
    List<StorageCustomer> customerList(StorageCustomer customer);

    /**
     * 新增客户信息
     * @param customer
     * @return
     */
    int add(StorageCustomer customer);

    /**
     * 修改客户信息
     * @param customer
     * @return
     */
    int update(StorageCustomer customer);

    /**
     * 删除客户
     * @param ids
     * @return
     */
    int del(Long[] ids);

}
