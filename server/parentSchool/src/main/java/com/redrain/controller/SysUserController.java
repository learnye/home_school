package com.redrain.controller;

import com.redrain.entity.SysUser;
import com.redrain.service.SysUserService;
import com.redrain.util.ReturnData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @author student
 * @Description SysUsercontroller实现类
 * @date 2020-03
 */

@Controller
public class SysUserController {

    @Autowired
    private SysUserService SysUserService;
	@RequestMapping("/Sregister")
    @ResponseBody
    public ReturnData add(SysUser sysUser, Long userId) {
        return SysUserService.addSysUser(sysUser);
    }
}

