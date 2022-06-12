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

    /**
     * 新增图书
     * @param book
     * @return
     */
    @Override
    public boolean save(Book book) {
        return bookDao.insert(book) > 0;
    }

    /**
     * 修改图书信息
     * @param book
     * @return
     */
    @Override
    public boolean update(Book book) {
        return bookDao.updateById(book) > 0;
    }

    /**
     * 删除图书
     * @param id
     * @return
     */
    @Override
    public boolean delete(Integer id) {
        return bookDao.deleteById(id) > 0;
    }

    /**
     * 根据id查询，用于修改时数据回显
     * @param id
     * @return
     */
    @Override
    public Book queryById(Integer id) {
        return bookDao.selectById(id);
    }

    /**
     * 查询全部 (不使用)
     * @return
     */
    @Override
    public List<Book> queryAll() {
        return bookDao.selectList(null);
    }

    /**
     * 分页查询 (不使用)
     * @param current
     * @param pageSize
     * @return
     */
    @Override
    public IPage<Book> getPage(Integer current, Integer pageSize) {
        IPage<Book> page = new Page<>(current, pageSize);
        bookDao.selectPage(page, null);

        return page;
    }

    /**
     * 按条件进行分页查询
     * @param current
     * @param pageSize
     * @param book
     * @return
     */
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
