package org.anyway.controller;


import java.io.IOException;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.anyway.infrastructure.TrainingMemberRepo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
//@Api(value="MVC Access",authorizations= {})
@Controller
public class MvcController {

	@Resource
	private TrainingMemberRepo repo;
	
//	@ApiOperation(httpMethod="get", value = "index access")
	@RequestMapping(value ="/index", method=RequestMethod.GET)
	public ModelAndView show (HttpServletRequest request) {
		
		ModelAndView modelAndView = new ModelAndView();
		
		//模拟数据库获取信息和list
		modelAndView.addObject("name","zhangsan");
		List<String> list =Arrays.asList(new String[] {"sanyue","siyue","wuyue"});
		modelAndView.addObject("list", list);
		//todo:
		//重定向根据ｐｒｏｐｅｒｔｉｅｓ文件获取真实完整资源路径
		modelAndView.setViewName("inside");
		return modelAndView;
	}
	@RequestMapping(value ="/index2", method=RequestMethod.GET)

	public ModelAndView show2 (HttpServletRequest request , HttpServletResponse response) throws IOException {
		
		ModelAndView modelAndView = new ModelAndView();
		String first = request.getParameter("first");
		String second = request.getParameter("second");
		String third = request.getParameter("third");
		//模拟数据库获取信息和list
		modelAndView.addObject("name","zhangsan");
		String suffix = LocalTime.now()+"===>>>modelFromDatabase";
		List<String> list =Arrays.asList(new String[] {first+suffix,second+suffix,third+suffix});
		modelAndView.addObject("list", list);
		//todo:
		//重定向根据ｐｒｏｐｅｒｔｉｅｓ文件获取真实完整资源路径
		modelAndView.setViewName("inside");
	//	response.getWriter().append(list.toString());
		response.getWriter().append("<!-- "+list.toString()+" -->");
		response.getWriter().flush();
		return modelAndView;
	}
	
	@RequestMapping(value="/fourth",method=RequestMethod.POST)
	public ModelAndView querySome(@RequestBody List<String> list) {
		ModelAndView modelAndView = new ModelAndView();

		//todo:[codesContents ;title]
		modelAndView.addObject("title","codes number is :" +list.size());
		modelAndView.addObject("codesContents",repo.findByMemberCodeIn(list));
		
		modelAndView.setViewName("behind");
		return modelAndView;
	}
}
