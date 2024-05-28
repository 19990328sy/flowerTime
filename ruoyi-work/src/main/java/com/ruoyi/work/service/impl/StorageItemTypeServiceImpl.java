package com.ruoyi.work.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.work.admin.Storage;
import com.ruoyi.work.admin.StorageArea;
import com.ruoyi.work.admin.StorageItemtype;
import com.ruoyi.work.admin.StorageSupplier;
import com.ruoyi.work.mapper.StorageItemTypeMapper;
import com.ruoyi.work.service.StorageItemTypeService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
@Service
public class StorageItemTypeServiceImpl extends ServiceImpl<StorageItemTypeMapper, StorageItemtype> implements StorageItemTypeService {
    @Override
    public List<StorageItemtype> itemtypeList(StorageItemtype itemtype) {
        LambdaQueryWrapper<StorageItemtype> wrapper = new LambdaQueryWrapper<StorageItemtype>()
                .eq(StringUtils.isEmpty(itemtype.getTypeCode()), StorageItemtype::getTypeCode, itemtype.getTypeCode())
                .eq(StringUtils.isEmpty(itemtype.getTypeName()), StorageItemtype::getTypeName, itemtype.getTypeName());
        List<StorageItemtype> list = list(wrapper);
        return list;
    }

    /**
     * 新增物料类型信息
     *
     * @param itemtype
     * @return
     */
    @Override
    public int add(StorageItemtype itemtype) {
        //判断是否为空
        if (itemtype == null) {
            return 0;
        }
        boolean state = save(itemtype);
        if (state) {
            return 1;
        }
        return 0;
    }

    /**
     * 修改物料类型信息
     *
     * @param itemtype
     * @return
     */
    @Override
    public int update(StorageItemtype itemtype) {
        if (itemtype==null){
            return 1;
        }
        boolean save = updateById(itemtype);
        if (save){
            return 1;
        }
        return 0;
    }

    /**
     * 删除物料类型
     *
     * @param ids
     * @return
     */
    @Override
    public int del(Long[] ids) {
        if (StringUtils.isEmpty(ids)) {
            return 0;
        }
        List<StorageItemtype> list = listByIds(Arrays.asList(ids));
        if (list.size() > 0) {
            return baseMapper.deleteBatchIds(Arrays.asList(ids));
        }
        for (StorageItemtype itemtype: list) {
            itemtype.setDelFlag("2");
        }
        removeBatchByIds(list);
        return list.size();
    }
}
