package com.redrain.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author student
 * @Description Chat实体类
 * @date 2020-03
 */

@Data
public class Chat extends PageBean {

	private Integer id;//

	private String content;//内容

	private String fromName;//发送人昵称

	private String toName;//接收人昵称

	private String fromAvatarUrl;//发送人头像

	private String toAvatarUrl;//接收人头像

	private Integer tuid;//教师

	private Integer parentid;//家长

	private Integer state;//状态

	private Integer type;//

	private Date createTime;//创建时间

	private Date updateTime;//更新时间

}

