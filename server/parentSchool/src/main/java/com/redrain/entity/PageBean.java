package com.redrain.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author student
 * @Description 分页实体类
 * @date 2020-02
 */

@Data
public class PageBean implements Serializable {

    private Integer page;

    private Integer limit;

}

