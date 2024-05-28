package com.ruoyi.work.admin;

import com.baomidou.mybatisplus.annotation.TableName;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;

/**
 * 仓库表
 */
@Data
@TableName("s_storage")
public class Storage extends BaseEntity {

    /**
     * id
     */
    private Long id;

    /**
     * 仓库编码
     */
    private String warehouseNo;

    /**
     * 仓库名称
     */
    private String warehouseName;

    /**
     * del_falg
     */
    private String delFlag;
}
