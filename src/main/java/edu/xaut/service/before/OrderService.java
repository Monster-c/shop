package edu.xaut.service.before;

import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;

public interface OrderService {
    String orderSubmit(Model model, HttpSession session, Double amount);

    String pay(Integer ordersn);
}
