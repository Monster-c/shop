package edu.xaut.dao;

import edu.xaut.po.Auser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("adminDao")
@Mapper
public interface AdminDao {
    List<Auser> login(Auser auser);
}
