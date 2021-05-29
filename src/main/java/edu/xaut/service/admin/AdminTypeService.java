package edu.xaut.service.admin;

import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;

public interface AdminTypeService {
    String toAddType(Model model);

    String addType(String typename, Model model, HttpSession session);

    String toDeleteType(Model model);

    String deleteType(Integer id, Model model);
}
