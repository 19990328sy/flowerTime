package com.ruoyi.work.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.work.admin.StorageCustomer;
import com.ruoyi.work.mapper.StorageCustomerMapper;
import com.ruoyi.work.service.StorageCustomerService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
@Service
public class StorageCustomerServiceImpl extends ServiceImpl<StorageCustomerMapper, StorageCustomer> implements StorageCustomerService {
    @Override
    public List<StorageCustomer> customerList(StorageCustomer customer) {
        LambdaQueryWrapper<StorageCustomer> wrapper = new LambdaQueryWrapper<StorageCustomer>()
                .eq(StringUtils.isEmpty(customer.getCustomerNo()), StorageCustomer::getCustomerNo, customer.getCustomerNo())
                .eq(StringUtils.isEmpty(customer.getCustomerName()), StorageCustomer::getCustomerName, customer.getCustomerName())
                ;
        List<StorageCustomer> list = list(wrapper);
        return list;
    }

    /**
     * 新增客户信息
     *
     * @param customer
     * @return
     */
    @Override
    public int add(StorageCustomer customer) {
        //判断是否为空
        if (customer == null) {
            return 0;
        }
        boolean state = save(customer);
        if (state) {
            return 1;
        }
        return 0;
    }

    /**
     * 修改客户信息
     *
     * @param customer
     * @return
     */
    @Override
    public int update(StorageCustomer customer) {
        if (customer==null){
            return 1;
        }
        boolean save = updateById(customer);
        if (save){
            return 1;
        }
        return 0;
    }

    /**
     * 删除客户
     *
     * @param ids
     * @return
     */
    @Override
    public int del(Long[] ids) {
        if (StringUtils.isEmpty(ids)) {
            return 0;
        }
        List<StorageCustomer> list = listByIds(Arrays.asList(ids));
        if (list.size() > 0) {
            System.out.println();
            return baseMapper.deleteBatchIds(Arrays.asList(ids));
        }
        for (StorageCustomer customer: list) {
            customer.setDelFlag("2");
        }
        removeBatchByIds(list);
        return list.size();
    }
}
