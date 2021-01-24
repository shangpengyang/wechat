/**
 * 
 */
package com.wechat_server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/** @version:1.0
* @Description:
* @author:spy
* @date: 
*/
@RestController
public class AcceptController {

	@GetMapping("/article/infos")
	public String ruleDemo() {
		System.out.println("002");
		return "succ";
		
	}
}
