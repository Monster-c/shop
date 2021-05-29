package edu.xaut.service.admin;

import org.springframework.ui.Model;

public interface AdminUserService {
    String userInfo(Model model);

    String deleteuserManager(Integer id, Model model);
}
