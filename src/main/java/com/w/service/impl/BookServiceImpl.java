package com.w.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.w.dao.BookDao;
import com.w.domain.Book;
import com.w.service.IBookService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author blue
 * @version 1.0
 */
@Service
public class BookServiceImpl extends ServiceImpl<BookDao, Book> implements IBookService {

    @Autowired
    private BookDao bookDao;

    @Override
    public boolean save(Book book) {
        return bookDao.insert(book) > 0;
    }

    @Override
    public boolean update(Book book) {
        return bookDao.updateById(book) > 0;
    }

    @Override
    public boolean delete(Integer id) {
        return bookDao.deleteById(id) > 0;
    }

    @Override
    public Book queryById(Integer id) {
        return bookDao.selectById(id);
    }

    @Override
    public List<Book> queryAll() {
        return bookDao.selectList(null);
    }

    @Override
    public IPage<Book> getPage(Integer current, Integer pageSize) {
        IPage<Book> page = new Page<>(current, pageSize);
        bookDao.selectPage(page, null);

        return page;
    }

    @Override
    public IPage<Book> getPage(Integer current, Integer pageSize, Book book) {
        IPage<Book> page = new Page<>(current, pageSize);
        LambdaQueryWrapper<Book> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(Strings.isNotEmpty(book.getName()), Book::getName, book.getName());
        wrapper.like(Strings.isNotEmpty(book.getType()), Book::getType, book.getType());
        wrapper.like(Strings.isNotEmpty(book.getDescription()), Book::getDescription, book.getDescription());
        bookDao.selectPage(page, wrapper);
        return page;
    }
}
