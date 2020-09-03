package com.redrain.service.impl;

import com.redrain.entity.SysUser;
import com.redrain.mapper.SysUserMapper;
import com.redrain.service.SysUserService;
import com.redrain.util.ReturnData;
import com.redrain.util.TextUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.redrain.util.UpdateOrInsertResultDeal;

import javax.servlet.http.HttpServletRequest;

@Service
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    SysUserMapper sysUserMapper;

    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    @Override
    public ReturnData login(SysUser sysUser, HttpServletRequest request) {
        ReturnData returnData = ReturnData.fail("登录失败");
        if (TextUtils.isEmpty(sysUser.getUsername())) {
            returnData = ReturnData.fail("用户名不能为空");
        } else if (TextUtils.isEmpty(sysUser.getPassword())) {
            returnData = ReturnData.fail("密码不能为空");
        } else {
            //管理员
            //数据库查询
            SysUser dbUser = sysUserMapper.getUserByUserName(sysUser.getUsername());
            if (dbUser == null) {
                returnData = ReturnData.fail("用户不存在");
            } else if (!dbUser.getPassword().equals(sysUser.getPassword())) {
                returnData = ReturnData.fail("密码有误");
            } else {
                request.getSession().setAttribute("userInfo", dbUser);
                returnData = ReturnData.success("登录成功");
            }
        }
        return returnData;
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @Override
    public ReturnData addSysUser(SysUser sysUser) {
        int i = sysUserMapper.addSysUser(sysUser);
        return UpdateOrInsertResultDeal.dealWith(i);
    }
}
