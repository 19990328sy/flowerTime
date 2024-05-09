package com.ruoyi.work.admin;

import com.baomidou.mybatisplus.annotation.TableName;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;

import java.util.Date;

/**
 * 客户信息表
 */
@Data
@TableName("s_customer")
public class StorageCustomer extends BaseEntity {
    /**
     * id
     */
    private Long id;

    /**
     * 客户编码
     */
    private String customerNo;

    /**
     * 客户名称
     */
    private String customerName;

    /**
     * 客户级别
     */
    private String customerLevel;

    /**
     * 联系人
     */
    private String customerPerson;

    /**
     * 地址
     */
    private String address;

    /**
     * 开户银行
     */
    private String bankName;

    /**
     * 银行卡号
     */
    private String bankAccount;

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
     * 删除标识
     */
    private String delFlag;
}
