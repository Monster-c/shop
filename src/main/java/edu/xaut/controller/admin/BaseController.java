package edu.xaut.controller.admin;

import edu.xaut.exception.AdminLoginNoException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class BaseController {
    @ModelAttribute
    /**
     * 登录权限控制，处理方法执行前执行该方法
     *
     * @throws AdminLoginNoException
     */
    public void isLogin(HttpSession session, HttpServletRequest request) throws AdminLoginNoException {
        if (session.getAttribute("auser") == null) {
            throw new AdminLoginNoException("没有登录");
        }
    }
}
