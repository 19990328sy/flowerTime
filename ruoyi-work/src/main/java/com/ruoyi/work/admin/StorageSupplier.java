package com.ruoyi.work.admin;

import com.baomidou.mybatisplus.annotation.TableName;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;

@Data
@TableName("s_supplier")
public class StorageSupplier extends BaseEntity {
    /**
     * 供应商id
     */
    private Long id;

    /**
     * 供应商编码
     */
    private String supplierNo;

    /**
     * 供应商名称
     */
    private String supplierName;

    /**
     * 联系人
     */
    private String contact;

    /**
     * 级别
     */
    private String level;

    /**
     * 地址
     */
    private String address;

    /**
     * 手机号
     */
    private Integer mobileNo;

    /**
     * 开户银行
     */
    private String bankName;

    /**
     * 银行卡号
     */
    private String bankAccount;

    /**
     * 座机号
     */
    private Integer telNo;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 删除表示
     */
    private String delFlag;
}
