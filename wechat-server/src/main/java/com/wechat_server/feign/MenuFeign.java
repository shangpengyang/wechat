package com.wechat_server.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.wechat_server.menu.Menu;

@FeignClient(name="wechat-server",url = "https://api.weixin.qq.com")
public interface MenuFeign {
    //获取access_token
	@RequestMapping(value="/cgi-bin/token" ,method=RequestMethod.GET)
	String getToken(@RequestParam String grant_type, @RequestParam String appid,@RequestParam String secret);
		 
	@RequestMapping(value="/cgi-bin/menu/create" ,method=RequestMethod.POST)
	String createMenu(@RequestParam String access_token,@RequestBody Menu menu );

}
