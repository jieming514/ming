package com.ming.upms.common.exception;

import com.ming.common.utils.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class MainsiteErrorController implements ErrorController {
    Logger logger = LoggerFactory.getLogger(MainsiteErrorController.class);

    private final String ERROR_PATH ="/error";

    /**
     * 出现错误，跳转到如下映射中
     * @return
     */
    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }

    /**
     * Web页面错误处理
     */
    @RequestMapping(value = ERROR_PATH, produces = {"text/html"})
    public ModelAndView errorHtml(HttpServletRequest request, HttpServletResponse response) {
        int code = response.getStatus();
        if (404 == code) {
            return new ModelAndView("error/404");
        } else if (403 == code) {
            return new ModelAndView("error/403");
        } else if (401 == code) {
            return new ModelAndView("login");
        } else {
            return new ModelAndView("error/500");
        }
    }

    @RequestMapping(value =ERROR_PATH)
    public R handleError(HttpServletRequest request, HttpServletResponse response) {
        int code = response.getStatus();
        if (404 == code) {
            return R.error(404, "未找到资源");
        } else if (403 == code) {
            return R.error(403, "没有访问权限");
        } else if (401 == code) {
            return R.error(401, "登录过期");
        } else {
            return R.error(500, "服务器错误");
        }
    }

}
