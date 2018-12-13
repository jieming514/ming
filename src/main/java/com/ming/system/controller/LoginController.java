package com.ming.system.controller;

import com.ming.common.controller.BaseController;
import com.ming.common.domain.Tree;
import com.ming.common.util.MD5Utils;
import com.ming.common.util.R;
import com.ming.system.domain.MenuDO;
import com.ming.system.service.MenuService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 用户登录
 */
@Controller
public class LoginController extends BaseController {

    private final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private MenuService menuService;


    @GetMapping({ "/", "" })
    String welcome(Model model) {
        return "redirect:/index";
    }

    /**
     * 主页
     * @return
     */
    @GetMapping(value ={"/index"})
    public String index(Model model) {

        List<Tree<MenuDO>> menus = menuService.getlistSysMenuTree(getUserId());

        model.addAttribute("menus",menus);
        model.addAttribute("picUrl","/img/photo_s.jpg");
        model.addAttribute("username",getUser().getName());
        return "index";
    }

    /**
     *
     */
    @GetMapping(value = "/main")
    public String main() {
        return "main";
    }

    /**
     * 登录页面
     * @return
     */
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    /**
     * 用户登录
     * @param username  用户名
     * @param password  密码
     * @return
     */
    @PostMapping("/login")
    @ResponseBody
    public R loginSubmit(String username, String password) {

        //1. 对密码进行加密
        password = MD5Utils.encrypt(username,password);
        //2. 校验
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            return R.ok();
        } catch (AuthenticationException e) {
            logger.error("login error:"+e.getMessage(),e);
            return R.error(e.getMessage());
        }
    }

    /**
     * 退出
     */
    @GetMapping("/logout")
    public String logout() {
        SecurityUtils.getSubject().logout();
        return "redirect:/login";
    }

}
