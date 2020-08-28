package com.caidapao.bizmodule.mvc.action;



import com.caidapao.bizmodule.service.IDemoService;
import com.caidapao.bizmodule.service.impl.DemoService;
import com.caidapao.mvcspringframework.annotation.DPAutowired;
import com.caidapao.mvcspringframework.annotation.DPController;
import com.caidapao.mvcspringframework.annotation.DPRequestMapping;
import com.caidapao.mvcspringframework.annotation.DPRequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


//虽然，用法一样，但是没有功能
@DPController
@DPRequestMapping("/demo")
public class DemoAction {

  	@DPAutowired
	private DemoService demoService;

	@DPRequestMapping("/query")
	public void query(HttpServletRequest req, HttpServletResponse resp,
					  @DPRequestParam("name") String name){
		String result = demoService.get(name);
//		String result = "My name is " + name;
		try {
			resp.getWriter().write(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@DPRequestMapping("/add")
	public void add(HttpServletRequest req, HttpServletResponse resp,
					@DPRequestParam("a") Integer a, @DPRequestParam("b") Integer b){
		try {
			resp.getWriter().write(a + "+" + b + "=" + (a + b));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@DPRequestMapping("/sub")
	public void add(HttpServletRequest req, HttpServletResponse resp,
					@DPRequestParam("a") Double a, @DPRequestParam("b") Double b){
		try {
			resp.getWriter().write(a + "-" + b + "=" + (a - b));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@DPRequestMapping("/remove")
	public String  remove(@DPRequestParam("id") Integer id){
		return "" + id;
	}

}
