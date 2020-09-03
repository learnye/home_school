package com.redrain.mapper;


import com.redrain.entity.SysUser;
import org.springframework.stereotype.Repository;


@Repository
public interface SysUserMapper {

    SysUser getUserByUserName(String username);

    int addSysUser(SysUser sysUser);
}