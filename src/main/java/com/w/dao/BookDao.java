package com.w.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.w.domain.Book;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author blue
 * @version 1.0
 */
@Mapper
public interface BookDao extends BaseMapper<Book> {



}
