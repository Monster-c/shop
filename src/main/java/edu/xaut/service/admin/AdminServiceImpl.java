package edu.xaut.service.admin;

import edu.xaut.dao.AdminDao;
import edu.xaut.dao.AdminTypeDao;
import edu.xaut.po.Auser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpSession;

@Service("adminService")
@Transactional
public class AdminServiceImpl implements AdminService {
    @Qualifier("adminDao")
    @Autowired
    private AdminDao adminDao;

    @Qualifier("adminTypeDao")
    @Autowired
    private AdminTypeDao adminTypeDao;

    @Override
    public String login(@ModelAttribute("auser") Auser auser, Model model, HttpSession session) {
        if (adminDao.login(auser) != null && adminDao.login(auser).size() > 0) {
            session.setAttribute("auser", auser);
            //添加商品与修改商品页面使用
            //防止初次加载时类型不显示
            session.setAttribute("goodsType", adminTypeDao.selectGoodsType());
            return "admin/main";
        }
        model.addAttribute("msg", "用户名或密码错误！");
        return "admin/login";
    }

}
