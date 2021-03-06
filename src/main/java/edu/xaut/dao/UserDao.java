package edu.xaut.dao;

import edu.xaut.po.Buser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userDao")
@Mapper
public interface UserDao {
    int register(Buser buser);

    List<Buser> login(Buser buser);
}
