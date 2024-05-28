package com.ruoyi.work.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.work.admin.StorageArea;
import com.ruoyi.work.mapper.StorageAreaMapper;
import com.ruoyi.work.service.StorageAreaService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
@Service
public class StorageAreaServiceImpl extends ServiceImpl<StorageAreaMapper,StorageArea> implements StorageAreaService {
    @Override
    public List<StorageArea> areList(StorageArea storageArea) {
        LambdaQueryWrapper<StorageArea> wrapper = new LambdaQueryWrapper<StorageArea>()
                .eq(StringUtils.isEmpty(storageArea.getAreaName()), StorageArea::getAreaName, storageArea.getAreaName())
                .eq(StringUtils.isEmpty(storageArea.getAreaNo()), StorageArea::getAreaNo, storageArea.getAreaNo());
        List<StorageArea> list = list(wrapper);
        return list;
    }

    /**
     * 新增库区信息
     *
     * @param storageArea
     * @return
     */
    @Override
    public int add(StorageArea storageArea) {
        //判断是否为空
        if (storageArea == null) {
            return 0;
        }
        LambdaQueryWrapper<StorageArea> wrapper = new LambdaQueryWrapper<StorageArea>()
                .eq(StorageArea::getDelFlag, "0")
                .eq(StringUtils.isNotEmpty(storageArea.getAreaNo()),StorageArea::getAreaNo,storageArea.getAreaNo())
                ;
        List<StorageArea> list = list(wrapper);
        if (list.size()>0){
            throw new ServiceException("该库区编码重复，请重新添加！！！");
        }
        boolean state = save(storageArea);
        if (state) {
            return 1;
        }
        return 0;
    }

    /**
     * 修改库区信息
     *
     * @param storageArea
     */
    @Override
    public int update(StorageArea storageArea) {
        LambdaQueryWrapper<StorageArea> wrapper = new LambdaQueryWrapper<StorageArea>()
                .eq(StorageArea::getDelFlag, "0")
                .eq(StringUtils.isNotEmpty(storageArea.getAreaNo()),StorageArea::getAreaNo,storageArea.getAreaNo())
                ;
        List<StorageArea> list = list(wrapper);
        for (StorageArea storageProject : list) {
            if (!storageProject.getId().equals(storageArea.getId()) && storageProject.getAreaNo().equals(storageArea.getAreaNo())){
                throw new RuntimeException("该库区编码重复，请重新修改！！！");
            }
        }
        boolean state = updateById(storageArea);
        if (state) {
            return 1;
        }
        return 0;
    }

    /**
     * 删除库区
     *
     * @param ids
     * @return
     */
    @Override
    public int del(Long[] ids) {
        if (StringUtils.isEmpty(ids)) {
            return 0;
        }
        List<StorageArea> list = listByIds(Arrays.asList(ids));
        if (StringUtils.isEmpty(list)) {
            return 0;
        }
        for (StorageArea storageArea : list) {
            storageArea.setDelFlag("2");
        }
        removeBatchByIds(list);
        return list.size();
    }

}