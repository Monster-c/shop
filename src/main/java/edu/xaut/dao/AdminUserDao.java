package edu.xaut.dao;

import edu.xaut.po.Buser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("adminUserDao")
@Mapper
public interface AdminUserDao {
    List<Buser> userInfo();

    int deleteuserManager(Integer id);
}
