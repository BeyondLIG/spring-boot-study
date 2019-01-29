package com.beyondlcg.springshirotest.dao;

import com.beyondlcg.springshirotest.model.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: licg
 * @Date: 2019/1/25
 * @Description：
 */
@Mapper
public interface UserRoleMapper {
    List<Role> findByUserName(String userName);
}