package edu.xaut.service.admin;

import edu.xaut.dao.AdminTypeDao;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;

@Service("adminTypeService")
@Transactional
public class AdminTypeServiceImpl implements AdminTypeService {
    @Autowired
    @Qualifier("adminTypeDao")
    private AdminTypeDao adminTypeDao;

    @Override
    public String toAddType(Model model) {
        model.addAttribute("allTypes", adminTypeDao.selectGoodsType());
        return "admin/addType";
    }

    @Override
    public String addType(String typename, Model model, @NotNull HttpSession session) {
        adminTypeDao.addType(typename);
        //添加商品与修改商品页面使用
        session.setAttribute("goodsType", adminTypeDao.selectGoodsType());
        return "forward:/adminType/toAddType";
    }

    @Override
    public String toDeleteType(Model model) {
        model.addAttribute("allTypes", adminTypeDao.selectGoodsType());
        return "admin/deleteType";
    }

    @Override
    public String deleteType(Integer id, Model model) {
        //类型有关联
        if (adminTypeDao.selectGoodsByType(id).size() > 0) {
            model.addAttribute("msg", "类型有关联，不允许删除！");
            return "forward:/adminType/toDeleteType";
        }
        if (adminTypeDao.deleteType(id) > 0)
            model.addAttribute("msg", "类型成功删除！");
        //回到删除页面
        return "forward:/adminType/toDeleteType";
    }

}
