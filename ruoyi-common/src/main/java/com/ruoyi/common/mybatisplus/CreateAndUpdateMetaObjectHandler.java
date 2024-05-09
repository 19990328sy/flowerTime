package com.ruoyi.common.mybatisplus;

import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.utils.SecurityUtils;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import java.util.Date;

@Component
public class CreateAndUpdateMetaObjectHandler implements MetaObjectHandler{

	@Override
    public void insertFill(MetaObject metaObject) {
//region 处理创建人信息
        Object createBy = this.getFieldValByName("createBy", metaObject);
        Object createTime = this.getFieldValByName("createTime", metaObject);
        if (createBy == null) {
            createBy = getLoginUsername();
            this.setFieldValByName("createBy", createBy, metaObject);
        }
        if (createTime == null) {
            createTime = new Date();
            this.setFieldValByName("createTime", createTime, metaObject);
        }
        //endregion
        //region 处理修改人信息
        Object updateBy = this.getFieldValByName("updateBy", metaObject);
        Object updateTime = this.getFieldValByName("updateTime", metaObject);
        if (updateBy == null) {
            updateBy = createBy;
            this.setFieldValByName("updateBy", updateBy, metaObject);
        }
        if (updateTime == null) {
            updateTime = createTime;
            this.setFieldValByName("updateTime", updateTime, metaObject);
        }
        //endregion
    }

    /**
     * 获取登录用户名
     */
    private String getLoginUsername() {
        LoginUser loginUser;
        try {
            loginUser = SecurityUtils.getLoginUser();
        } catch (Exception e) {
            return null;
        }
        return loginUser.getUsername();
    }


    @Override
    public void updateFill(MetaObject metaObject) {
        //region 处理修改人信息
        Object updateBy = this.getFieldValByName("updateBy", metaObject);
        Object updateTime = this.getFieldValByName("updateTime", metaObject);
        if (updateBy == null) {
            updateBy = getLoginUsername();
            this.setFieldValByName("updateBy", updateBy, metaObject);
        }
        
        updateTime = new Date();
        this.setFieldValByName("updateTime", updateTime, metaObject);
        //endregion
    }

    @Override
    public boolean openInsertFill() {
        return true;
    }

    @Override
    public boolean openUpdateFill() {
        return true;
    }
}
