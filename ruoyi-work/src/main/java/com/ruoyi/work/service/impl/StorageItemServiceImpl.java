package com.ruoyi.work.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.work.admin.Storage;
import com.ruoyi.work.admin.StorageArea;
import com.ruoyi.work.admin.StorageItem;
import com.ruoyi.work.mapper.StorageItemMapper;
import com.ruoyi.work.service.StorageItemService;
import org.springframework.stereotype.Service;
import com.ruoyi.common.utils.StringUtils;

import java.util.Arrays;
import java.util.List;

@Service
public class StorageItemServiceImpl extends ServiceImpl<StorageItemMapper, StorageItem> implements StorageItemService {
    @Override
    public List<StorageItem> itemList(StorageItem item) {
        LambdaQueryWrapper<StorageItem> wrapper = new LambdaQueryWrapper<StorageItem>()
                .eq(StringUtils.isEmpty(item.getItemName()), StorageItem::getItemName, item.getItemName())
                .eq(StringUtils.isEmpty(item.getItemType()),StorageItem::getItemType,item.getItemType());
        List<StorageItem> list = list(wrapper);
        return list;
    }

    /**
     * 新增物料信息
     *
     * @param item
     * @return
     */
    @Override
    public int add(StorageItem item) {
        //判断是否为空
        if (item == null) {
            return 0;
        }
        boolean state = save(item);
        if (state) {
            return 1;
        }
        return 0;
    }

    /**
     * 修改物料信息
     *
     * @param item
     * @return
     */
    @Override
    public int update(StorageItem item) {
        if (item==null){
            return 1;
        }
        boolean save = updateById(item);
        if (save){
            return 1;
        }
        return 0;
    }

    /**
     * 删除物料
     *
     * @param ids
     * @return
     */
    @Override
    public int del(Long[] ids) {
        if (StringUtils.isEmpty(ids)) {
            return 0;
        }
        List<StorageItem> list = listByIds(Arrays.asList(ids));
        if (list.size() > 0) {
            return baseMapper.deleteBatchIds(Arrays.asList(ids));
        }
        for (StorageItem item : list) {
            item.setDelFlag("2");
        }
        removeBatchByIds(list);
        return list.size();
    }
}
