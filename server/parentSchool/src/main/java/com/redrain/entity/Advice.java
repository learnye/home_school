package com.redrain.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author student
 * @Description Advice实体类
 * @date 2020-03
 */

@Data
public class Advice extends PageBean {

    private Integer id;//

    private String name;//标题

    private String content;//内容

    private String reply;//回复

    private Integer parentid;

    private String patentName;

    private Integer state;//状态

    private Date createTime;//创建时间

    private Date updateTime;//更新时间

}

