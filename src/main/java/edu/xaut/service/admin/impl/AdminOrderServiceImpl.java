package edu.xaut.service.admin.impl;

import edu.xaut.dao.AdminOrderDao;
import edu.xaut.service.admin.AdminOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Map;

@Service("adminOrderService")
@Transactional
public class AdminOrderServiceImpl implements AdminOrderService {
    @Autowired
    @Qualifier("adminOrderDao")
    private AdminOrderDao adminOrderDao;

    @Override
    public String orderInfo(Model model) {
        List<Map<String, Object>> list = adminOrderDao.orderInfo();
        model.addAttribute("orderList", list);
        return "admin/orderManager";
    }

    @Override
    public String deleteorderManager(Integer id) {
        //先删除明细
        adminOrderDao.deleteOrderDetail(id);
        //再删除订单基础
        adminOrderDao.deleteOrderBase(id);
        return "forward:/adminOrder/orderInfo";
    }

}