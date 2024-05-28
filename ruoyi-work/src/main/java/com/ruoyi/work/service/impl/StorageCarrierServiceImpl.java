package com.ruoyi.work.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.work.admin.StorageCarrier;
import com.ruoyi.work.mapper.StorageCarrierMapper;
import com.ruoyi.work.service.StorageCarrierService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
@Service
public class StorageCarrierServiceImpl extends ServiceImpl<StorageCarrierMapper, StorageCarrier> implements StorageCarrierService {
    @Override
    public List<StorageCarrier> carrierList(StorageCarrier carrier) {
        LambdaQueryWrapper<StorageCarrier> wrapper = new LambdaQueryWrapper<StorageCarrier>()
                .eq(StringUtils.isEmpty(carrier.getCarrierNo()), StorageCarrier::getCarrierNo, carrier.getCarrierNo())
                .like(StringUtils.isEmpty(carrier.getCarrierName()), StorageCarrier::getCarrierName, carrier.getCarrierName())
                .like(StringUtils.isEmpty(carrier.getAddress()), StorageCarrier::getAddress, carrier.getAddress())
                .like(StringUtils.isEmpty(carrier.getTel()), StorageCarrier::getTel, carrier.getTel())
                .like(StringUtils.isEmpty(carrier.getContact()), StorageCarrier::getContact, carrier.getContact())
                .like(StringUtils.isEmpty(carrier.getLevel()), StorageCarrier::getLevel, carrier.getLevel())
                ;
        List<StorageCarrier> list = list(wrapper);
        return list;
    }

    /**
     * 新增供应商
     *
     * @param carrier
     * @return
     */
    @Override
    public int add(StorageCarrier carrier) {
        //判断是否为空
        if (carrier == null) {
            return 0;
        }
        boolean state = save(carrier);
            if (state) {
                return 1;
            }
        return 0;
    }

    /**
     * 修改供应商信息
     *
     * @param carrier
     * @return
     */
    @Override
    public int update(StorageCarrier carrier) {
        if (carrier==null){
            return 1;
        }
        boolean save = updateById(carrier);
        if (save){
            return 1;
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
        List<StorageCarrier> list = listByIds(Arrays.asList(ids));
        if (StringUtils.isEmpty(list)) {
            return 0;
        }
        for (StorageCarrier carrier : list) {
            carrier.setDelFlag("2");
        }
        removeBatchByIds(list);
        return list.size();
    }
}
