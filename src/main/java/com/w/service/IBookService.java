package com.w.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.w.domain.Book;

import java.util.List;

/**
 * @author blue
 * @version 1.0
 */
public interface IBookService extends IService<Book> {

    boolean save(Book book);

    boolean update(Book book);

    boolean delete(Integer id);

    Book queryById(Integer id);

    List<Book> queryAll();

    IPage<Book> getPage(Integer current, Integer pageSize);

    IPage<Book> getPage(Integer current, Integer pageSize, Book book);

}
