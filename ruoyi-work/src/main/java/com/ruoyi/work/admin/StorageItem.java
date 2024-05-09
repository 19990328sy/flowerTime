package com.ruoyi.work.admin;

import com.baomidou.mybatisplus.annotation.TableName;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;

import java.util.Date;

@Data
@TableName("s_item")
public class StorageItem extends BaseEntity {
    /**
     * id
     */
    private Integer id;

    /**
     * 物料编码
     */
    private Integer itemNo;

    /**
     * 物料名称
     */
    private String itemName;

    /**
     * 物料类型
     */
    private String itemType;

    /**
     * 单位类别
     */
    private String unit;

    /**
     * 仓库id
     */
    private Integer warehouseId;

    /**
     * 仓库名称
     */
    private String warehouseName;

    /**
     * 有效期
     */
    private Date expiryDate;

    /**
     * 安全库存
     */
    private String quantity;

    /**
     * rack_id
     */
    private Integer rackId;

    /**
     * 删除标识
     */
    private String delFlag;

    /**
     * 库区id
     */
    private Integer areaid;

    /**
     * 库区名称
     */
    private String areaName;
}
