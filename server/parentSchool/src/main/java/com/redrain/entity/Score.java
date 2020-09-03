package com.redrain.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author student
 * @Description Score实体类
 * @date 2020-03
 */

@Data
public class Score extends PageBean {

    private Integer id;//

    private String name;//姓名

    private String content;//表现

    private String subject;//科目

    private Integer studentid;//学生

    private Integer teacherid;

    private String studentName;

    private String teacherName;

    private Integer score;//分数

    private Integer state;//状态

    private Date createTime;//创建时间

    private Date updateTime;//更新时间

}

