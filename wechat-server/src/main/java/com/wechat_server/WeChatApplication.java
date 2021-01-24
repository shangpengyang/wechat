package com.wechat_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * Hello world!
 *
 */
@EnableFeignClients
@SpringBootApplication
public class WeChatApplication {
	public static void main(String[] args) {
		SpringApplication.run(WeChatApplication.class, args);
	}


}
