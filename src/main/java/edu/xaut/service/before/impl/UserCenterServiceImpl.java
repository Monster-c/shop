package edu.xaut.service.before.impl;

import edu.xaut.dao.UserCenterDao;
import edu.xaut.service.before.UserCenterService;
import edu.xaut.util.MyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;

@Service("userCenterService")
@Transactional
public class UserCenterServiceImpl implements UserCenterService {
    @Autowired
    @Qualifier("userCenterDao")
    private UserCenterDao userCenterDao;

    @Override
    public String userCenter(HttpSession session, Model model) {
        model.addAttribute("myOrder", userCenterDao.myOrder(MyUtil.getUserId(session)));
        model.addAttribute("myFocus", userCenterDao.myFocus(MyUtil.getUserId(session)));
        return "before/userCenter";
    }

    @Override
    public String orderDetail(Model model, Integer ordersn) {
        model.addAttribute("myOrderDetail", userCenterDao.orderDetail(ordersn));
        return "before/userOrderDetail";
    }

}
