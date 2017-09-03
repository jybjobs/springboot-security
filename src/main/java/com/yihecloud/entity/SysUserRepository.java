package com.yihecloud.entity;

import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface SysUserRepository extends CrudRepository<SysUser, Long> {

    SysUser findByUsername(String userName);
}