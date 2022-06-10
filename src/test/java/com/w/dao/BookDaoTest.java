package com.w.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.w.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author blue
 * @version 1.0
 */
@SpringBootTest
public class BookDaoTest {

    @Autowired
    private BookDao bookDao;

    @Test
    public void testGetById(){

        Book book = bookDao.selectById(1);

        System.out.println(book);

    }

    @Test
    public void testGetAll(){

        Page<Book> page = new Page<>(1, 4);
        /*Page<Book> bookPage = */bookDao.selectPage(page, null);
        List<Book> bookList = page.getRecords();
        System.out.println(bookList);

//        System.out.println(bookDao.selectList(null));

    }

    @Test
    public void testGetByCondition(){

        LambdaQueryWrapper<Book> bookLambdaQueryWrapper = new LambdaQueryWrapper<>();
        LambdaQueryWrapper<Book> wrapper = bookLambdaQueryWrapper.like(Book::getName, "spring");
        List<Book> bookList = bookDao.selectList(wrapper);

        System.out.println(bookList);

    }

}
