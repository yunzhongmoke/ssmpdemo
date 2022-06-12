package com.w.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.w.dao.UserDao;
import com.w.domain.User;
import com.w.service.IUserService;
import org.springframework.stereotype.Service;

/**
 * @author blue
 * @version 1.0
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements IUserService {
}
