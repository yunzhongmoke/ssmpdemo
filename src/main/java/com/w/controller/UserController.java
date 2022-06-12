package com.w.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.w.domain.User;
import com.w.exception.BusinessException;
import com.w.service.IUserService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author blue
 * @version 1.0
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    private IUserService userService;

    @Autowired
    public UserController(IUserService userService) {
        this.userService = userService;
    }

    /**
     * 用户登录
     * @param user
     * @return
     */
    @GetMapping(value = "login")
    public Result login(User user){

        LambdaQueryWrapper<User> userLambdaQueryWrapper = new LambdaQueryWrapper<>();
        userLambdaQueryWrapper.eq(User::getName, user.getName());
        userLambdaQueryWrapper.eq(User::getPassword, user.getPassword());
        User u = userService.getOne(userLambdaQueryWrapper);
        if (u == null){
            //登录失败
            return new Result(Code.GET_ERR, null, "账号或密码错误");
        }

        //登录成功
        return new Result(Code.GET_OK, null, "登录成功");
    }

    /**
     * 用户注册
     * @param user
     * @return
     */
    @PostMapping(value = "/register")
    public Result register(@RequestBody User user){

        if ("".equals(user.getName()) || "".equals(user.getPassword())){
            throw new BusinessException(Code.BUSINESS_ERR, "请输入完整的信息");
        }

        //判断用户名是否存在
        LambdaQueryWrapper<User> userLambdaQueryWrapper = new LambdaQueryWrapper<>();
        userLambdaQueryWrapper.eq(User::getName, user.getName());
        User u = userService.getOne(userLambdaQueryWrapper);
        if (u != null){
            //用户名已存在
            return new Result(Code.SAVE_ERR, null, "用户名已存在");
        }

        //保存用户
        boolean flag = userService.save(user);

        return flag ? new Result(Code.SAVE_OK, null, "注册成功") : new Result(Code.SAVE_ERR, null, "注册失败");
    }

    /**
     * 判断用户名是否存在
     * @param name
     * @return
     */
    @GetMapping(value = "/getByName/{name}")
    public Result getByName(@PathVariable String name){

        //判断用户是否存在
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getName, name);
        User u = userService.getOne(queryWrapper);
        if (u != null){
            //用户已存在
            return new Result(Code.SAVE_ERR, null, "用户名已存在");
        }

        return new Result(Code.SAVE_OK, null, null);
    }

}
