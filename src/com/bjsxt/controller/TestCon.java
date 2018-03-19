package com.bjsxt.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.InternalResourceView;
import org.springframework.web.servlet.view.RedirectView;

import com.bjsxt.pojo.User;

@Controller
public class TestCon {
	
	@RequestMapping("show")
	public String demo(){
		System.out.println("我是配置方式二");
		return "index.jsp";
	}
	
	/**
	 * 紧藕方式：
	 * 	在控制单元方法上直接声明servlet的参数即可
	 * 	HttpServletRequest
	 *  HttpServletResponse
	 * 缺点：
	 * 	需要手动获取请求参数
	 *  参数需要手动强转类型
	 * @param req
	 * @return
	 */
	@RequestMapping("show1")
	public String demo1(HttpServletRequest req){
		//获取用户参数
			String name=req.getParameter("uname");
			int age=Integer.parseInt(req.getParameter("age"));
		//处理请求数据
			System.out.println("TestCon.demo1()"+name+":"+age);
		//响应处理结果
		return "index.jsp";
	}
	
	/**
	 * 解耦方式一:普通变量
	 * 	注意：
	 * 		单元方法的变量名必须和表单提交数据的键名相同才会自动注入。
	 * @param uname11
	 * @param age
	 * @return
	 */
	@RequestMapping("show2")
	public String demo2(String uname,int age){
		//处理请求数据
			System.out.println("TestCon.demo2()"+uname+":"+age);
		//响应处理结果
		return "index.jsp";
	}
	/**
	 * 解耦方式二:普通变量,变量名和表单提交键名不一致
	 * 	注意：
	 * 		在变量名前使用@RequestParam("表单键名")
	 * 			value：表单提交的键名
	 * 			defaultValue:默认值，如果表单中没有想要的数据则将默认值作为实参传递给单元方法。
	 * 			required:
	 * 				false代表可以没有值
	 * 				true代表形参必须有值，如果没有则报错
	 * 			注意：
	 * 				required和defaultValue不要一起使用
	 * @param uname11
	 * @param age
	 * @return
	 */
	@RequestMapping("show3")
	public String demo3(@RequestParam(value="uname11",required=true) String uname,int age){
		//处理请求数据
			System.out.println("TestCon.demo3()"+uname+":"+age);
		//响应处理结果
		return "index.jsp";
	}
	
	/**
	 * 解耦方式三:获取同名不同值的表单数据
	 * 	注意：
	 * 		变量类型为集合
	 * 		@RequestParam("键名")
	 * @param uname11
	 * @param age
	 * @return
	 */
	@RequestMapping("show4")
	public String demo4(@RequestParam("fav") ArrayList<String> favs,String uname,int age){
		//处理请求数据
			System.out.println("TestCon.demo4()"+uname+":"+age+":"+favs);
		//响应处理结果
		return "index.jsp";
	}
	/**
	 * 解耦方式四:变量类型为对象
	 * 	注意：
	 * 		对象中的属性名和表单数据提交的键名一致，数据才会自动填充到对象中。
	 * 		@RequestParam("键名")
	 * @param uname11
	 * @param age
	 * @return
	 */
	@RequestMapping("show5/66")
	public String demo5(User u){
		//处理请求数据
			System.out.println("TestCon.demo5()"+u);
		//响应处理结果
		return "index.jsp";
	}
	/**
	 * 解耦方式五:使用restful
	 * 	注意：
	 * 		数据提交格式为 :方法别名/数据/数据/……/数据
	 * 		后台方法的别名格式：别名/{占位}/{占位}/……/{占位}
	 * 		单元方法参数名前必须使用@PathVariable("占位名")
	 *路径注意：
	 *		请求转发中的资源前加/  /代表项目根目录
	 *		jsp页面中静态资源路径 /项目名/资源路径      /代表服务器根目录
	 * 		@RequestParam("键名")
	 * @param uname11
	 * @param age
	 * @return
	 */
	
	@RequestMapping("show6/{name}/{age}")
	public String demo6(@PathVariable("name") String uname,@PathVariable("age") int age){
		//处理请求数据
			System.out.println("TestCon.demo6()"+uname+":"+age);
		//响应处理结果
		return "/index.jsp";
	}
	
	/**
	 * 解耦方式五:使用ajax
	 * 	 和以前一样，只不过后台获取的方式比较方便。
	 * 	使用:
	 * 		前端使用ajax进行数据的发送
	 * 		后台使用解耦方式获取数据即可
	 * 		响应
	 * 			导入jackson的jar包
	 * 			在单元方法上使用@ResponseBody注解
	 * 			直接返回要响应的java对象即可，前端接受的是java对象转换好的js对象。
	 * @param uname11
	 * @param age
	 * @return
	 */
	
	@RequestMapping("show7")
	@ResponseBody
	public User demo7(String uname,int age){
		//处理请求数据
			System.out.println("TestCon.demo7()"+uname+":"+age);
			User u=new User("zhangsan", 18,null);
		//响应处理结果
		return u;
	}
	

	/**
	 * 	Springmvc的作用域传值
	 * 		紧藕方式
	 * 			在单元方法上声明request形参
	 * 			在单元方法中使用req.setAttribute("键名",值);
	 * 		解耦方式
	 * 			Map方式：
	 * 				在单元方法上声明map形参
	 * 				在单元方法内使用map.put()方法添加作用域数据即可。
	 * 			Model方式
	 * 				在单元方法上使用model形参
	 * 				在单元方法内使用model.addAttributo("键名",值);	
	 * 		注意：基于request的作用域的。
	 * @param uname11
	 * @param age
	 * @return
	 */
	
	@RequestMapping("show8")
	public String demo8(HttpServletRequest req){
		//处理请求数据
			System.out.println("TestCon.demo8()");
			User u=new User("zhangsan", 18,null);
			req.setAttribute("u", u);
		//响应处理结果
		return "/index.jsp";
	}
	
	@RequestMapping("show9")
	public String demo9(Map<String,Object> map){
		//处理请求数据
			System.out.println("TestCon.demo9()");
			User u=new User("zhangsan", 18,null);
			map.put("str","我是map方式");
			map.put("u",u);
		//响应处理结果
		return "/index.jsp";
	}
	
	@RequestMapping("show10")
	public String demo10(Model md){
		//处理请求数据
			System.out.println("TestCon.demo10()");
			User u=new User("zhangsan", 18,null);
			md.addAttribute("str","我是model方式");
			md.addAttribute("u", u);
		//响应处理结果
		return "/index.jsp";
	}
	/*
	 * Spring mvc的响应：
	 * 		直接响应
	 * 			将单元方法置为无返回值，也就是void类型
	 * 			形参中声明HttpServletResponse resp
	 * 			单元方法内容使用resp.getWriter().write("响应内容");即可
	 * 		请求转发
	 * 			单元方法返回值为String
	 * 			返回值为 return "forward:资源路径";
	 * 			注意：
	 * 				"forward:"可以省略不写
	 * 		重定向
	 * 			单元方法返回值为String
	 * 			返回值为 return "redirecte:资源路径";
	 */
	@RequestMapping("show11")
	public void demo11(HttpServletResponse resp) throws IOException{
		//处理请求数据
			System.out.println("TestCon.demo11()");
			User u=new User("zhangsan", 18,null);
		//响应处理结果
			resp.getWriter().write("I am resp");
	}
	
	
	
	@RequestMapping("show12")
	public String demo12() throws IOException{
		//处理请求数据
			System.out.println("TestCon.demo12()");
			User u=new User("zhangsan", 18,null);
		//响应处理结果
			return "forward:/index.jsp";
	}
	
	
	@RequestMapping("show13")
	public String demo13() throws IOException{
		//处理请求数据
			System.out.println("TestCon.demo13()");
			User u=new User("zhangsan", 18,null);
		//响应处理结果
			return "redirect:/index.jsp";
	}
	
	/**
	 * spring mvc的三种响应方式
	 * 		String
	 * 			forward:/index.jsp 请求转发
	 * 			redirect:/index.jsp 重定向
	 * 		View
	 * 			new InternalResourceView("/index.jsp");//请求转发
	 * 			new RedirectView("/01-02-springmvc/index.jsp");//重定向
	 * 		ModelAndView
	 * 			ModelAndView mav=new ModelAndView("redirect:/index.jsp");
				mav.addObject("aa", "haha");
				mav.addObject("u", u);
	 * 
	 */
	@RequestMapping("show14")
	public View demo14() throws IOException{
		//处理请求数据
			System.out.println("TestCon.demo14()");
			User u=new User("zhangsan", 18,null);
		//响应处理结果
			//View v=new InternalResourceView("/index.jsp");//请求转发
			View v=new RedirectView("/01-02-springmvc/index.jsp");//重定向
			return v;
	}
	
	@RequestMapping("show15")
	public ModelAndView demo15() throws IOException{
		//处理请求数据
			System.out.println("TestCon.demo15()");
			User u=new User("zhangsan", 18,null);
		//响应处理结果
			ModelAndView mav=new ModelAndView("redirect:/index.jsp");
			mav.addObject("aa", "haha");
			mav.addObject("u", u);
			return mav;
	}
	/**
	 * 自定义视图解析器
	 * 		在springmvc.xml中配置bean
	 * 		<bean id="in" class="org.springframework.web.servlet.view.InternalResourceViewResolver">
				<property name="prefix" value="/WEB-INF/page/"></property>
				<property name="suffix" value=".jsp"></property>
	 *  	</bean>
	 * 	注意：
	 * 			如果配置了自定义视图解析器，会优先使用自定义视图解析器解析之后再进行转发。
	 * 	注意：
	 * 		在返回值前加上
	 * 			forward:     请求转发
	 * 			redirect:	  重定向
	 * 			会使用默认视图解析器进行跳转。
	 * 
	 */
	@RequestMapping("show16")
	public String demo16(){
		System.out.println("TestCon.demo16()");
		return "page";
	}
	@RequestMapping("show17")
	public String demo17(){
		System.out.println("TestCon.demo17()");
		return "forward:show16";
	}
	
}
