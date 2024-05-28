package com.ruoyi.work.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.work.admin.Storage;
import com.ruoyi.work.admin.StorageArea;
import com.ruoyi.work.admin.StorageSupplier;
import com.ruoyi.work.mapper.StorageSupplierMapper;
import com.ruoyi.work.service.StorageSupplierService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
@Service
public class StorageSupplierServiceImpl extends ServiceImpl<StorageSupplierMapper, StorageSupplier> implements StorageSupplierService {
    @Override
    public List<StorageSupplier> supplierList(StorageSupplier supplier) {
        LambdaQueryWrapper<StorageSupplier> wrapper = new LambdaQueryWrapper<StorageSupplier>()
                .eq(StringUtils.isEmpty(supplier.getSupplierName()), StorageSupplier::getSupplierName, supplier.getSupplierName())
                .eq(StringUtils.isEmpty(supplier.getSupplierNo()), StorageSupplier::getSupplierNo, supplier.getSupplierNo());
        List<StorageSupplier> list = list(wrapper);
        return list;
    }

    /**
     * 新增供应商信息
     *
     * @param supplier
     * @return
     */
    @Override
    public int add(StorageSupplier supplier) {
        if (supplier==null){
            return 1;
        }
        int insert = baseMapper.insert(supplier);
        if (insert>0){
            return 1;
        }
        return 0;
    }

    /**
     * 修改供应商信息
     *
     * @param supplier
     * @return
     */
    @Override
    public int update(StorageSupplier supplier) {
        if (supplier==null){
            return 1;
        }
        boolean save = updateById(supplier);
        if (save){
            return 0;
        }
        return 0;
    }

    /**
     * 删除供应商
     *
     * @param ids
     * @return
     */
    @Override
    public int del(Long[] ids) {
        if (StringUtils.isEmpty(ids)) {
            return 0;
        }
        List<StorageSupplier> list = listByIds(Arrays.asList(ids));
        if (list.size() > 0) {
            return baseMapper.deleteBatchIds(Arrays.asList(ids));
        }
        for (StorageSupplier supplier: list) {
            supplier.setDelFlag("2");
        }
        removeBatchByIds(list);
        return list.size();
    }
}
