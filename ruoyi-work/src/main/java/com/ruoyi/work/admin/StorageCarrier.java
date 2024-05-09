package com.ruoyi.work.admin;

import com.baomidou.mybatisplus.annotation.TableName;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;

import java.util.Date;

/**
 * 承运商信息表
 */
@Data
@TableName("s_carrier")
public class StorageCarrier extends BaseEntity {
    /**
     * id
     */
    private Integer id;

    /**
     * 物流编码
     */
    private Integer carrierNo;

    /**
     * 物流名称
     */
    private String carrierName;

    /**
     * 联系人
     */
    private String contact;

    /**
     * 级别
     */
    private String level;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 座机
     */
    private String tel;

    /**
     * 地址
     */
    private String address;

    /**
     * 删除标识
     */
    private String delFlag;
}
