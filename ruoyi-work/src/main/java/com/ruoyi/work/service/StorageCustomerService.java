package com.ruoyi.work.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ruoyi.work.admin.Storage;

import java.util.List;

public interface StorageCustomerService extends IService<Storage> {
    List<Storage> storageList(Storage storage);

    /**
     * 新增仓库信息
     * @param storage
     * @return
     */
    int add(Storage storage);

    /**
     * 修改仓库信息
     * @param storage
     * @return
     */
    int update(Storage storage);

    /**
     * 删除仓库
     * @param ids
     * @return
     */
    int del(Long[] ids);

}
