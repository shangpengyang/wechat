package com.wechat_server.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.DispatcherServlet;

import com.wechat_server.feign.MenuFeign;
import com.wechat_server.menu.Menu;
import com.wechat_server.menu.MenuManager;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class UserController {
	//注册的公众号appId,第三方用户唯一凭证
	private static String appId = "wxeb976e00d7b2ea24";
	//注册的公众号appsecret,第三方用户唯一凭证密钥，即appsecret
	private static String secret = "ab4b3a36e8141c6dba9b24b0e50e6f75";
	//获取access_token填写client_credential
	private static String grant_type="client_credential";
	//token
	private String access_token="33_xOATSP_OWK6a_XgbBF-maeJpNM4lgSTVL0FTvLgRzGsoF1xV8V8Q0MAdkUlGD6mAY4ksn8ROCfITyT1eFyGUHSFch7hbpVJAjP2ZAQjQje8DZGHtsdHue_HIflpAPtxKkyXRWJQZAGBMDYpJOUOdAGAGMG";

	@Autowired
	MenuFeign menuFeign;
  //微信绑定url验证接口
  @RequestMapping("/signToken")
  public String checkToken(@RequestParam String signature,String timestamp,String nonce,String echostr) {

	  return echostr;
  }
  //获取access_token
  @RequestMapping("/getToken")
  public String getToken() {
	  return menuFeign.getToken(grant_type, appId, secret);
  }
  
  //创建微信菜单栏
  @RequestMapping("/createMenu")
  public String createMenu() {
	  MenuManager tMenuManager=new MenuManager();
	  Menu tMenu=tMenuManager.getMenu();
	  return menuFeign.createMenu(access_token,tMenu);
  }
}
