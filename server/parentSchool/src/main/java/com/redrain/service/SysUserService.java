package com.redrain.service;


import com.redrain.util.ReturnData;

import javax.servlet.http.HttpServletRequest;

import com.redrain.entity.SysUser;
/**
 * @Author student【000】
 */
public interface SysUserService {
    ReturnData login(SysUser user, HttpServletRequest request);

    ReturnData addSysUser(SysUser sysUser);
}
