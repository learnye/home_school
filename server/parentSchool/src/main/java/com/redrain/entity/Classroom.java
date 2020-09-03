package com.redrain.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author student
 * @Description Classroom实体类
 * @date 2020-03
 */

@Data
public class Classroom extends PageBean {

	private Integer id;//

	private String name;//班级名称

	private Integer state;//状态

	private Date createTime;//创建时间

	private Date updateTime;//更新时间

}

