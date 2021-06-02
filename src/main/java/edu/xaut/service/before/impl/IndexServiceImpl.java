package edu.xaut.service.before.impl;

import edu.xaut.dao.AdminNoticeDao;
import edu.xaut.dao.AdminTypeDao;
import edu.xaut.dao.IndexDao;
import edu.xaut.po.Buser;
import edu.xaut.po.Goods;
import edu.xaut.po.Notice;
import edu.xaut.service.before.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service("indexService")
@Transactional
public class IndexServiceImpl implements IndexService {
    @Qualifier("indexDao")
    @Autowired
    private IndexDao indexDao;
    @Qualifier("adminTypeDao")
    @Autowired
    private AdminTypeDao adminTypeDao;
    @Qualifier("adminNoticeDao")
    @Autowired
    private AdminNoticeDao adminNoticeDao;

    @Override
    public String before(Model model, HttpSession session, Goods goods) {
        session.setAttribute("goodsType", adminTypeDao.selectGoodsType());
        model.addAttribute("salelist", indexDao.getSaleOrder());
        model.addAttribute("focuslist", indexDao.getFocusOrder());
        model.addAttribute("noticelist", indexDao.selectNotice());
        if (goods.getId() == null)
            goods.setId(0);
        model.addAttribute("lastedlist", indexDao.getLastedGoods(goods));
        return "before/index";
    }

    @Override
    public String toRegister(Model model) {
        model.addAttribute("rbuser", new Buser());
        return "before/register";
    }

    @Override
    public String toLogin(Model model) {
        model.addAttribute("lbuser", new Buser());
        return "before/login";
    }

    @Override
    public String goodsDetail(Model model, Integer id) {
        Goods goods = indexDao.selectGoodsById(id);
        model.addAttribute("goods", goods);
        return "before/goodsdetail";
    }

    @Override
    public String selectANotice(Model model, Integer id) {
        Notice notice = adminNoticeDao.selectANotice(id);
        model.addAttribute("notice", notice);
        return "admin/noticeDetail";
    }

    @Override
    public String search(Model model, String mykey) {
        List<Goods> list = indexDao.search(mykey);
        model.addAttribute("searchlist", list);
        return "before/searchResult";
    }

}
