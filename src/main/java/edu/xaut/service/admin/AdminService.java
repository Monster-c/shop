package edu.xaut.service.admin;

import edu.xaut.po.Auser;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;

public interface AdminService {
    String login(Auser auser, Model model, HttpSession session);
}
