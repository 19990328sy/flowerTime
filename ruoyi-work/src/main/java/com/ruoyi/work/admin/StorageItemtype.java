package com.ruoyi.work.admin;

import com.baomidou.mybatisplus.annotation.TableName;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;

import java.util.Date;

/**
 * 物料类型表
 */
@Data
@TableName("s_itemtype")
public class StorageItemtype extends BaseEntity {
    /**
     * id
     */
    private Long id;

    /**
     * 物料类型
     */
    private String typeCode;

    /**
     * 类型名称
     */
    private String typeName;

    /**
     * 父级id
     */
    private Integer parentid;

    /**
     * 父级名称
     */
    private String parantName;

    /**
     * 状态
     */
    private String status;

    /**
     * 排序
     */
    private Integer orderNum;

    /**
     * 删除标识
     */
    private String delFlag;
}
