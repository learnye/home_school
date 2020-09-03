package com.redrain.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author student
 * @Description answer实体类
 * @date 2020-03
 */

@Data
public class Answer extends PageBean {

    private Integer id;//

    private String name;//名称

    private String content;//通知内容

    private String coverImg;//图片

    private Integer classroomid;//所属班级

    private String classroomName;

    private String teacherName;

    private Integer teacherid;//所属教师

    private Integer state;//状态

    private Date createTime;//创建时间

    private Date updateTime;//更新时间

}
