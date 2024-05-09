package com.ruoyi.work.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.work.admin.Storage;
import com.ruoyi.work.mapper.StorageMapper;
import com.ruoyi.work.service.StorageService;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;

@Service
public class StorageServiceImpl extends ServiceImpl<StorageMapper,Storage> implements StorageService {


    @Override
    public List<Storage> storageList(Storage storage) {
        LambdaQueryWrapper<Storage> wrapper = new LambdaQueryWrapper<Storage>()
                .eq(Storage::getDelFlag,"0")
                .eq(StringUtils.isEmpty(storage.getWarehouseno()),Storage::getWarehouseno,storage.getWarehouseno())
                .like(StringUtils.isEmpty(storage.getWarehousename()), Storage::getWarehousename, storage.getWarehousename());
        List<Storage> list = list(wrapper);
        return list;
    }

    @Override
    public int add(Storage storage) {
        //判断是否为空
        if (storage == null) {
            return 0;
        }
        LambdaQueryWrapper<Storage> wrapper = new LambdaQueryWrapper<Storage>()
                .eq(Storage::getDelFlag, "0")
                .eq(StringUtils.isNotEmpty(storage.getWarehouseno()),Storage::getWarehouseno,storage.getWarehouseno())
                ;
        List<Storage> list = list(wrapper);
        if (list.size()>0){
            throw new ServiceException("该仓库编码重复，请重新添加！！！");
        }
        boolean state = save(storage);
        if (state) {
            return 1;
        }
        return 0;
    }

    @Override
    public int update(Storage storage) {
        LambdaQueryWrapper<Storage> wrapper = new LambdaQueryWrapper<Storage>()
                .eq(Storage::getDelFlag, "0")
                .eq(StringUtils.isNotEmpty(storage.getWarehouseno()),Storage::getWarehouseno,storage.getWarehouseno())
                ;
        List<Storage> list = list(wrapper);
        for (Storage newStorage : list) {
            if (!newStorage.getId().equals(storage.getId()) && newStorage.getWarehouseno().equals(storage.getWarehouseno())){
                throw new RuntimeException("该仓库编码重复，请重新修改！！！");
            }
        }
        boolean state = updateById(storage);
        if (state) {
            return 1;
        }
        return 0;
    }

    @Override
    public int del(Long[] ids) {
        if (StringUtils.isEmpty(ids)) {
            return 0;
        }
        List<Storage> list = listByIds(Arrays.asList(ids));
        //todo 后续业务关联
//        List<String> codeList = list.stream().map(StorageProject::getCode).collect(Collectors.toList());
//        // 判断项目是否有关联
//        List<StorageOut> storageOuts = storageOutMapper.listOut(new StorageOut());
//        List<String> outCodeList = storageOuts.stream().map(StorageOut::getProjectCode).collect(Collectors.toList());
//        for (String code : outCodeList) {
//            for (String outCode : codeList) {
//                boolean b = code.equals(outCode);
//                if (b){
//                    throw new ServiceException("该项目已在使用，不可删除！！！");
//                }
//            }
//        }
        if (StringUtils.isEmpty(list)) {
            return 0;
        }
        for (Storage storage: list) {
            storage.setDelFlag("2");
        }
        removeBatchByIds(list);
        return list.size();
    }
}
