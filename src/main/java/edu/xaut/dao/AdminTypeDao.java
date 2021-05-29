package edu.xaut.dao;

import edu.xaut.po.Goods;
import edu.xaut.po.GoodsType;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("adminTypeDao")
@Mapper
public interface AdminTypeDao {
    List<GoodsType> selectGoodsType();

    int addType(String typename);

    int deleteType(Integer id);

    List<Goods> selectGoodsByType(Integer id);
}
