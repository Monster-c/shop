package edu.xaut.service.before;

import edu.xaut.po.Buser;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;

public interface UserService {
    String register(Buser buser, Model model, HttpSession session, String code);

    String login(Buser buser, Model model, HttpSession session, String code);
}
