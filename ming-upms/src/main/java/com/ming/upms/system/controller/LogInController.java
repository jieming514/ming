package com.ming.upms.system.controller;

import com.ming.common.utils.MD5Utils;
import com.ming.common.utils.R;
import com.ming.upms.common.util.RandomValidateCodeUtil;
import com.ming.upms.common.util.ShiroUtils;
import com.ming.upms.system.service.UpmsUserService;
import org.apache.commons.lang3.StringUtils;
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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LogInController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UpmsUserService upmsUserService;

    @GetMapping(value = {"", "/index"})
    String index(Model model) {
        return "index_v1";
    }

    @GetMapping("/main")
    String main() {
        return "main";
    }

    /**
     * 登录页面
     * @return
     */
    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

    /**
     * 登录
     * @param username
     * @param password
     * @param verify
     * @param request
     * @return
     */
    @PostMapping("/login")
    @ResponseBody
    public R ajaxLogin(String username, String password,String verify,HttpServletRequest request) {
        //检验验证码
        try {
            String random = (String) request.getSession().getAttribute(RandomValidateCodeUtil.RANDOMCODEKEY);
            if (StringUtils.isBlank(verify)) {
                return R.error("请输入验证码！");
            }
            if(!random.equalsIgnoreCase(verify)) {
                return R.error("验证码不正确！");
            }
        } catch (Exception e) {
            logger.error("get verify is error:", e);
            return R.error("验证码校验失败");
        }
        //验证用户信息
        password = MD5Utils.encrypt(username, password);
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            return R.ok();
        } catch (AuthenticationException e) {
            return R.error("用户名密码错误");
        }
    }

    @GetMapping("/logout")
    public String logout() {
        ShiroUtils.logout();
        return "redirect:/login";
    }

    /**
     * 获取验证码
     * @return
     */
    @GetMapping("/getVerify")
    public void getVerify(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("image/jpeg");
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        RandomValidateCodeUtil validateCodeUtil = new RandomValidateCodeUtil();
        validateCodeUtil.getRandcode(request, response);
    }

}
