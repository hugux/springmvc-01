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
		System.out.println("�������÷�ʽ��");
		return "index.jsp";
	}
	
	/**
	 * ��ź��ʽ��
	 * 	�ڿ��Ƶ�Ԫ������ֱ������servlet�Ĳ�������
	 * 	HttpServletRequest
	 *  HttpServletResponse
	 * ȱ�㣺
	 * 	��Ҫ�ֶ���ȡ�������
	 *  ������Ҫ�ֶ�ǿת����
	 * @param req
	 * @return
	 */
	@RequestMapping("show1")
	public String demo1(HttpServletRequest req){
		//��ȡ�û�����
			String name=req.getParameter("uname");
			int age=Integer.parseInt(req.getParameter("age"));
		//������������
			System.out.println("TestCon.demo1()"+name+":"+age);
		//��Ӧ������
		return "index.jsp";
	}
	
	/**
	 * ���ʽһ:��ͨ����
	 * 	ע�⣺
	 * 		��Ԫ�����ı���������ͱ��ύ���ݵļ�����ͬ�Ż��Զ�ע�롣
	 * @param uname11
	 * @param age
	 * @return
	 */
	@RequestMapping("show2")
	public String demo2(String uname,int age){
		//������������
			System.out.println("TestCon.demo2()"+uname+":"+age);
		//��Ӧ������
		return "index.jsp";
	}
	/**
	 * ���ʽ��:��ͨ����,�������ͱ��ύ������һ��
	 * 	ע�⣺
	 * 		�ڱ�����ǰʹ��@RequestParam("������")
	 * 			value�����ύ�ļ���
	 * 			defaultValue:Ĭ��ֵ���������û����Ҫ��������Ĭ��ֵ��Ϊʵ�δ��ݸ���Ԫ������
	 * 			required:
	 * 				false�������û��ֵ
	 * 				true�����βα�����ֵ�����û���򱨴�
	 * 			ע�⣺
	 * 				required��defaultValue��Ҫһ��ʹ��
	 * @param uname11
	 * @param age
	 * @return
	 */
	@RequestMapping("show3")
	public String demo3(@RequestParam(value="uname11",required=true) String uname,int age){
		//������������
			System.out.println("TestCon.demo3()"+uname+":"+age);
		//��Ӧ������
		return "index.jsp";
	}
	
	/**
	 * ���ʽ��:��ȡͬ����ֵͬ�ı�����
	 * 	ע�⣺
	 * 		��������Ϊ����
	 * 		@RequestParam("����")
	 * @param uname11
	 * @param age
	 * @return
	 */
	@RequestMapping("show4")
	public String demo4(@RequestParam("fav") ArrayList<String> favs,String uname,int age){
		//������������
			System.out.println("TestCon.demo4()"+uname+":"+age+":"+favs);
		//��Ӧ������
		return "index.jsp";
	}
	/**
	 * ���ʽ��:��������Ϊ����
	 * 	ע�⣺
	 * 		�����е��������ͱ������ύ�ļ���һ�£����ݲŻ��Զ���䵽�����С�
	 * 		@RequestParam("����")
	 * @param uname11
	 * @param age
	 * @return
	 */
	@RequestMapping("show5/66")
	public String demo5(User u){
		//������������
			System.out.println("TestCon.demo5()"+u);
		//��Ӧ������
		return "index.jsp";
	}
	/**
	 * ���ʽ��:ʹ��restful
	 * 	ע�⣺
	 * 		�����ύ��ʽΪ :��������/����/����/����/����
	 * 		��̨�����ı�����ʽ������/{ռλ}/{ռλ}/����/{ռλ}
	 * 		��Ԫ����������ǰ����ʹ��@PathVariable("ռλ��")
	 *·��ע�⣺
	 *		����ת���е���Դǰ��/  /������Ŀ��Ŀ¼
	 *		jspҳ���о�̬��Դ·�� /��Ŀ��/��Դ·��      /�����������Ŀ¼
	 * 		@RequestParam("����")
	 * @param uname11
	 * @param age
	 * @return
	 */
	
	@RequestMapping("show6/{name}/{age}")
	public String demo6(@PathVariable("name") String uname,@PathVariable("age") int age){
		//������������
			System.out.println("TestCon.demo6()"+uname+":"+age);
		//��Ӧ������
		return "/index.jsp";
	}
	
	/**
	 * ���ʽ��:ʹ��ajax
	 * 	 ����ǰһ����ֻ������̨��ȡ�ķ�ʽ�ȽϷ��㡣
	 * 	ʹ��:
	 * 		ǰ��ʹ��ajax�������ݵķ���
	 * 		��̨ʹ�ý��ʽ��ȡ���ݼ���
	 * 		��Ӧ
	 * 			����jackson��jar��
	 * 			�ڵ�Ԫ������ʹ��@ResponseBodyע��
	 * 			ֱ�ӷ���Ҫ��Ӧ��java���󼴿ɣ�ǰ�˽��ܵ���java����ת���õ�js����
	 * @param uname11
	 * @param age
	 * @return
	 */
	
	@RequestMapping("show7")
	@ResponseBody
	public User demo7(String uname,int age){
		//������������
			System.out.println("TestCon.demo7()"+uname+":"+age);
			User u=new User("zhangsan", 18,null);
		//��Ӧ������
		return u;
	}
	

	/**
	 * 	Springmvc��������ֵ
	 * 		��ź��ʽ
	 * 			�ڵ�Ԫ����������request�β�
	 * 			�ڵ�Ԫ������ʹ��req.setAttribute("����",ֵ);
	 * 		���ʽ
	 * 			Map��ʽ��
	 * 				�ڵ�Ԫ����������map�β�
	 * 				�ڵ�Ԫ������ʹ��map.put()����������������ݼ��ɡ�
	 * 			Model��ʽ
	 * 				�ڵ�Ԫ������ʹ��model�β�
	 * 				�ڵ�Ԫ������ʹ��model.addAttributo("����",ֵ);	
	 * 		ע�⣺����request��������ġ�
	 * @param uname11
	 * @param age
	 * @return
	 */
	
	@RequestMapping("show8")
	public String demo8(HttpServletRequest req){
		//������������
			System.out.println("TestCon.demo8()");
			User u=new User("zhangsan", 18,null);
			req.setAttribute("u", u);
		//��Ӧ������
		return "/index.jsp";
	}
	
	@RequestMapping("show9")
	public String demo9(Map<String,Object> map){
		//������������
			System.out.println("TestCon.demo9()");
			User u=new User("zhangsan", 18,null);
			map.put("str","����map��ʽ");
			map.put("u",u);
		//��Ӧ������
		return "/index.jsp";
	}
	
	@RequestMapping("show10")
	public String demo10(Model md){
		//������������
			System.out.println("TestCon.demo10()");
			User u=new User("zhangsan", 18,null);
			md.addAttribute("str","����model��ʽ");
			md.addAttribute("u", u);
		//��Ӧ������
		return "/index.jsp";
	}
	/*
	 * Spring mvc����Ӧ��
	 * 		ֱ����Ӧ
	 * 			����Ԫ������Ϊ�޷���ֵ��Ҳ����void����
	 * 			�β�������HttpServletResponse resp
	 * 			��Ԫ��������ʹ��resp.getWriter().write("��Ӧ����");����
	 * 		����ת��
	 * 			��Ԫ��������ֵΪString
	 * 			����ֵΪ return "forward:��Դ·��";
	 * 			ע�⣺
	 * 				"forward:"����ʡ�Բ�д
	 * 		�ض���
	 * 			��Ԫ��������ֵΪString
	 * 			����ֵΪ return "redirecte:��Դ·��";
	 */
	@RequestMapping("show11")
	public void demo11(HttpServletResponse resp) throws IOException{
		//������������
			System.out.println("TestCon.demo11()");
			User u=new User("zhangsan", 18,null);
		//��Ӧ������
			resp.getWriter().write("I am resp");
	}
	
	
	
	@RequestMapping("show12")
	public String demo12() throws IOException{
		//������������
			System.out.println("TestCon.demo12()");
			User u=new User("zhangsan", 18,null);
		//��Ӧ������
			return "forward:/index.jsp";
	}
	
	
	@RequestMapping("show13")
	public String demo13() throws IOException{
		//������������
			System.out.println("TestCon.demo13()");
			User u=new User("zhangsan", 18,null);
		//��Ӧ������
			return "redirect:/index.jsp";
	}
	
	/**
	 * spring mvc��������Ӧ��ʽ
	 * 		String
	 * 			forward:/index.jsp ����ת��
	 * 			redirect:/index.jsp �ض���
	 * 		View
	 * 			new InternalResourceView("/index.jsp");//����ת��
	 * 			new RedirectView("/01-02-springmvc/index.jsp");//�ض���
	 * 		ModelAndView
	 * 			ModelAndView mav=new ModelAndView("redirect:/index.jsp");
				mav.addObject("aa", "haha");
				mav.addObject("u", u);
	 * 
	 */
	@RequestMapping("show14")
	public View demo14() throws IOException{
		//������������
			System.out.println("TestCon.demo14()");
			User u=new User("zhangsan", 18,null);
		//��Ӧ������
			//View v=new InternalResourceView("/index.jsp");//����ת��
			View v=new RedirectView("/01-02-springmvc/index.jsp");//�ض���
			return v;
	}
	
	@RequestMapping("show15")
	public ModelAndView demo15() throws IOException{
		//������������
			System.out.println("TestCon.demo15()");
			User u=new User("zhangsan", 18,null);
		//��Ӧ������
			ModelAndView mav=new ModelAndView("redirect:/index.jsp");
			mav.addObject("aa", "haha");
			mav.addObject("u", u);
			return mav;
	}
	/**
	 * �Զ�����ͼ������
	 * 		��springmvc.xml������bean
	 * 		<bean id="in" class="org.springframework.web.servlet.view.InternalResourceViewResolver">
				<property name="prefix" value="/WEB-INF/page/"></property>
				<property name="suffix" value=".jsp"></property>
	 *  	</bean>
	 * 	ע�⣺
	 * 			����������Զ�����ͼ��������������ʹ���Զ�����ͼ����������֮���ٽ���ת����
	 * 	ע�⣺
	 * 		�ڷ���ֵǰ����
	 * 			forward:     ����ת��
	 * 			redirect:	  �ض���
	 * 			��ʹ��Ĭ����ͼ������������ת��
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
