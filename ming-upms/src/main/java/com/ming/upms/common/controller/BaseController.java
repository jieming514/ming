package com.ming.upms.common.controller;

import com.ming.upms.common.util.ShiroUtils;
import com.ming.upms.system.domain.UpmsUserDO;
import org.springframework.stereotype.Controller;

/**
 * 控制器基类
 */
@Controller
public class BaseController {

    /**
     * 获取用户信息
     * @return
     */
    public UpmsUserDO getUser() {
        return ShiroUtils.getUser();
    }

    /**
     * 获取用户ID
     * @return
     */
    public Long getUserId() {
        return getUser().getUserId();
    }

    /**
     * 获取用户姓名
     * @return
     */
    public String getUserName() {
        return getUser().getUsername();
    }

}
