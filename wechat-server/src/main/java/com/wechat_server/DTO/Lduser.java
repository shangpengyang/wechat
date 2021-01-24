package com.wechat_server.DTO;

import com.baomidou.mybatisplus.annotations.TableName;

import lombok.Data;

@Data
@TableName
public class Lduser {
	
 // id	
 private int UserCode;
 //用户名
 private String UserName;
 //密码
 private String Password;
}
