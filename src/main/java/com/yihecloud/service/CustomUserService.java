package com.yihecloud.service;

import com.yihecloud.entity.SysUser;
import com.yihecloud.entity.SysUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.util.Assert;

/**
 * Created by jyb on 17-9-3.
 */
public class CustomUserService implements UserDetailsService {

    @Autowired
    SysUserRepository sysUserRepository;

    @Override
    public UserDetails loadUserByUsername(String s)  {//重写 loadUserByUsername
        System.out.println("user name :" + s);
        SysUser user = sysUserRepository.findByUsername(s);
        System.out.println("user info:" + user.toString());
        if(user == null){
            throw new UsernameNotFoundException("user name not found. ");
        }
        return user;
    }
}
