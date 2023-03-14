package com.zjt.project03mybatis.mapper;

import com.zjt.project03mybatis.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserXmlMapper {

    public List<User> findAll();
}
