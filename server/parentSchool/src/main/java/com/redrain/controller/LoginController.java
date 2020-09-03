package com.redrain.controller;

import com.redrain.entity.SysUser;
import com.redrain.service.SysUserService;
import com.redrain.util.ReturnData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
public class LoginController {
    @Autowired
    private SysUserService sysUserService;

    @RequestMapping("/")
    public String rootUrl() {
        return "redirect:login";
    }

    @RequestMapping("index")
    public ModelAndView index(ModelAndView modelAndView, HttpServletRequest request) {
        HttpSession session = request.getSession();
        SysUser sysUser = (SysUser) session.getAttribute("userInfo");
        if (sysUser == null) {
            modelAndView.setViewName("login");
        } else {
            modelAndView.addObject("name", sysUser.getName());
            modelAndView.setViewName("index");
        }
        return modelAndView;
    }

    @RequestMapping("login")
    public String login(HttpServletRequest request) {
        SysUser sysUser = (SysUser) request.getSession().getAttribute("userInfo");
        if (sysUser != null) {
            return "redirect:index";
        }
        return "login";
    }
    @RequestMapping("register")
    public String register(HttpServletRequest request) {
        SysUser sysUser = (SysUser) request.getSession().getAttribute("userInfo");
        return "register";
    }

    @RequestMapping("logout")
    public String logout(HttpServletRequest request) {
        request.getSession().setAttribute("userInfo", null);
        return "redirect:login";
    }

    @RequestMapping("requestLogin")
    @ResponseBody
    public ReturnData requestLogin(HttpServletRequest request, SysUser loginSysUser) {
        HttpSession session = request.getSession();
        SysUser sysUser = (SysUser) session.getAttribute("userInfo");
        if (sysUser != null) {
            return ReturnData.success("登陆成功");
        }
        return sysUserService.login(loginSysUser, request);
    }
}
