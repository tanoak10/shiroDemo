package com.tanoak.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.tanoak.pojo.Hello;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
public class HelloController {

	@RequestMapping("/t1")
	@ResponseBody
	@RequiresRoles("admin")
	public Hello toTest(HttpSession session){
		Hello hello = new Hello();
		hello.setId(1);
		hello.setName("abc");
		System.out.println("hello world");
		return hello ;
	}
	
	@RequestMapping("/t2")
	@ResponseBody
//	@RequiresRoles("admin")
	public Map<String,String> toTest2(){
		Map<String, String> map = new HashMap<>();
		map.put("abc", "abc");
		System.out.println("成功");
		return map ;
	}
	
}
