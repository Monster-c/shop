package edu.xaut.controller.before;

import edu.xaut.po.Buser;
import edu.xaut.service.before.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/register")
    public String register(@ModelAttribute Buser buser, Model model, HttpSession session, String code) {
        return userService.register(buser, model, session, code);
    }

    @RequestMapping("/login")
    public String login(@ModelAttribute Buser buser, Model model, HttpSession session, String code) {
        return userService.login(buser, model, session, code);
    }

    @RequestMapping("/exit")
    public String exit(HttpSession session) {
        session.invalidate();
        return "forward:/before";
    }
}
