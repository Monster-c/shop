package edu.xaut.service.admin;

import org.springframework.ui.Model;

public interface AdminOrderService {
    String orderInfo(Model model);

    String deleteorderManager(Integer id);
}
