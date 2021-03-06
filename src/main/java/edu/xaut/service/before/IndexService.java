package edu.xaut.service.before;

import edu.xaut.po.Goods;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;

public interface IndexService {
    String before(Model model, HttpSession session, Goods goods);

    String toRegister(Model model);

    String toLogin(Model model);

    String goodsDetail(Model model, Integer id);

    String selectANotice(Model model, Integer id);

    String search(Model model, String mykey);
}
