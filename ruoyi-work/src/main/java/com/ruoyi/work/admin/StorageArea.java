package com.ruoyi.work.admin;

import com.baomidou.mybatisplus.annotation.TableName;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;

import java.util.Date;

/**
 * 库区信息表
 */
@Data
@TableName("s_area")
public class StorageArea extends BaseEntity {

    /**
     * 库区id
     */
    private Long id;

    /**
     * 库区名称
     */
    private String areaName;

    /**
     * 库区编码
     */
    private String areaNo;

    /**
     * 仓库id
     */
    private Integer warehouseId;

    /**
     * 删除标识
     */
    private String delFlag;
}
