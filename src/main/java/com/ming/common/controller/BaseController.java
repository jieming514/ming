package com.ming.common.controller;


import com.ming.common.util.ShiroUtils;
import com.ming.system.domain.UserDO;
import org.springframework.stereotype.Controller;

@Controller
public class BaseController {

    /**
     * 获取用户
     * @return
     */
    public UserDO getUser() {
        return ShiroUtils.getUser();
    }

    /**
     * 获取用户ID
     * @return
     */
    public Long getUserId(){
        return getUser().getUserId();
    }

    /**
     * 获取用户名
     * @return
     */
    public String getUsername() {
        return getUser().getUserName();
    }



}
