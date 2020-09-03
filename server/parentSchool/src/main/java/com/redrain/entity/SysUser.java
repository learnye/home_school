package com.redrain.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author student
 * @Description SysUser实体类
 * @date 2020-02
 */

@Data
public class SysUser extends PageBean {

	private Integer id;//主键id

	private String username;//登陆名

	private String password;//密码

	private String name;//用户名

	private Integer sex;//性别

	private Integer age;//年龄

	private Date createTime;//创建时间

	private Date updateTime;//更新时间

}

