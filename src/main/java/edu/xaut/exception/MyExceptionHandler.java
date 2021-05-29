package edu.xaut.exception;

import edu.xaut.po.Auser;
import edu.xaut.po.Buser;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class MyExceptionHandler implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(@NotNull HttpServletRequest arg0, @NotNull HttpServletResponse arg1, @NotNull Object arg2,
                                         @NotNull Exception arg3) {
        Map<String, Object> model = new HashMap<>();
        model.put("ex", arg3);
        // 根据不同错误转向不同页面  
        if (arg3 instanceof AdminLoginNoException) {
            //登录页面需要auser对象
            arg0.setAttribute("auser", new Auser());
            arg0.setAttribute("msg", "没有登录，请登录！");
            return new ModelAndView("/admin/login", model);
        } else if (arg3 instanceof UserLoginNoException) {
            arg0.setAttribute("buser", new Buser());
            arg0.setAttribute("msg", "没有登录，请登录！");
            return new ModelAndView("/before/login", model);
        } else {
            return new ModelAndView("/error/error", model);
        }
    }
}