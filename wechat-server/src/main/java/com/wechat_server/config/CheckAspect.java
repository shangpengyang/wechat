/**
 * 
 */
package com.wechat_server.config;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/** @version:1.0
* @Description:构造切面
* @author:spy
* @date: 
*/
@Component
@Aspect
public class CheckAspect {
	
	@Before("execution(* com.wechat_server.controller.AcceptController.*(..))")
	public void ruleEngine(JoinPoint jp) {
	//获取切入点方法名称
	String methodName=	jp.getSignature().getName();
	//根据方法名称获取规则列表
	//初始化参数
	//调用执行引擎
	System.out.println(methodName);
		System.out.println("001");
		ScriptEngineManager tScriptEngineManager=new ScriptEngineManager();
		ScriptEngine engine=tScriptEngineManager.getEngineByName("js");
	}

}
