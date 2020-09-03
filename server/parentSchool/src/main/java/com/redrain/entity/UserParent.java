package com.redrain.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author student
 * @Description UserParent实体类
 * @date 2020-03
 */

@Data
public class UserParent extends PageBean {

    private Integer id;//

    private String username;//登录名

    private String password;//密码

    private String name;//用户昵称

    private Integer gender;//性别

    private Integer age;//年龄

    private String avatarUrl;//头像

    private String phone;//电话

    private Integer studentid;//连接学生

    private Integer classroomid;

    private String studentName;//连接学生

    private Integer state;//状态

    private Date createTime;//创建时间

    private Date updateTime;//更新时间

}

