package com.w.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.w.domain.Book;
import com.w.exception.BusinessException;
import com.w.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.w.controller.Code;

import java.util.List;

/**
 * @author blue
 * @version 1.0
 */
@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private IBookService bookService;

    /**
     * 新增数据
     * @param book
     * @return
     */
    @PostMapping
    public Result save(@RequestBody Book book){


        boolean flag = bookService.save(book);

        return new Result(flag ? Code.SAVE_OK : Code.SAVE_ERR, flag, flag ? "添加成功" : "添加失败");

    }

    /**
     * 修改数据
     * @param book
     * @return
     */
    @PutMapping
    public Result update(@RequestBody Book book){

        boolean flag = bookService.update(book);

        return new Result(flag ? Code.UPDATE_OK : Code.UPDATE_ERR, flag, flag ? "修改成功" : "修改失败");

    }

    /**
     * 删除数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}")
    public Result deleteById(@PathVariable Integer id){

        boolean flag = bookService.delete(id);

        return new Result(flag ? Code.DELETE_OK : Code.DELETE_ERR, flag, flag ? "删除成功" : "删除失败");

    }

    /**
     * 根据id获取数据,用于数据修改数据时回显数据
     * @param id
     * @return
     */
    @GetMapping(value = "/{id}")
    public Result findById(@PathVariable Integer id){

        Book book = bookService.getById(id);

        Integer code = book != null ? Code.GET_OK : Code.GET_ERR;
        String message = book != null ? "" : "数据查询失败，请重试！";
        return new Result(code, book, message);
    }

    /*@GetMapping
    public Result findAll(){
        List<Book> bookList = bookService.queryAll();

        Integer code = bookList != null ? Code.GET_OK : Code.GET_ERR;
        String message = bookList != null ? "" : "数据查询失败，请重试！";
        return new Result(code, bookList, message);
    }*/

    /**
     * 按条件分页显示数据
     * @param current
     * @param pageSize
     * @param book
     * @return
     */
    @GetMapping("/{current}/{pageSize}")
    public Result getPage(@PathVariable int current, @PathVariable int pageSize, Book book){
        IPage<Book> page = bookService.getPage(current, pageSize, book);

        Integer code = page != null ? Code.GET_OK : Code.GET_ERR;
        String message = page != null ? "" : "数据查询失败，请重试！";

        return new Result(code, page, message);
    }




}
