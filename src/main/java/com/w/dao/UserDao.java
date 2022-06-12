package com.w.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.w.domain.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author blue
 * @version 1.0
 */
@Mapper
public interface UserDao extends BaseMapper<User> {
}
