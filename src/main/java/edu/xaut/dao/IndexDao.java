package edu.xaut.dao;

import edu.xaut.po.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("indexDao")
@Mapper
public interface IndexDao {
    List<Map<String, Object>> getSaleOrder();

    List<Map<String, Object>> getFocusOrder();

    List<Map<String, Object>> selectNotice();

    List<Map<String, Object>> getLastedGoods(Goods goods);

    Goods selectGoodsById(Integer id);

    List<Goods> search(String mykey);
}
