package com.w.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
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
public class BookServiceTest {

    @Autowired
    private IBookService IBookService;

    @Test
    public void save(){

        Book book = new Book();
        book.setName("天龙八部22");
        book.setType("武侠");
        book.setDescription("6666");

        boolean flag = IBookService.save(book);

        System.out.println(flag);

    }

    @Test
    public void update(){
        Book book = new Book();
        book.setId(14);
        book.setName("天龙八部666666");
        book.setType("武侠");
        book.setDescription("6666");
        boolean flag = IBookService.update(book);
        System.out.println(flag);
    }

    @Test
    public void delete(){
        boolean flag = IBookService.delete(15);
        System.out.println(flag);
    }

    @Test
    public void queryById(){
        Book book = IBookService.queryById(1);
        System.out.println(book);

    }

    @Test
    public void queryAll(){
        List<Book> bookList = IBookService.queryAll();
        System.out.println(bookList);
    }

    @Test
    public void getPage(){
        IPage<Book> page = IBookService.getPage(1, 3);
        List<Book> bookList = page.getRecords();
        System.out.println(page.getCurrent());
        System.out.println(page.getSize());
        System.out.println(page.getTotal());
        System.out.println(page.getPages());
        System.out.println(bookList);
    }


}
