package com.chen.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

	/**
	 * 登录验证
	 * @param request
	 * @return
	 */
	@RequestMapping("login")
	public String home(HttpServletRequest request){
		
		HttpSession session = request.getSession(true);
		String checkCode = (String) session.getAttribute("verCode");
		//验证码
	    String paramsCheckCode = request.getParameter("checkCode").trim();
	        
		 if (checkCode.equalsIgnoreCase(paramsCheckCode)) {
            System.out.println("check code ok");
            
            request.setAttribute("success_1", "尊敬的admin用户，您的密码为：123456 <br/>验证码 OK");
		 } else {
        	
        	request.setAttribute("success_1", "尊敬的admin用户，您的密码为：123456 <br/>验证码 not OK");
		 }
		 
		String userName = request.getParameter("userName");
		String passWord = request.getParameter("passWord");
		if(userName.equals("admin") && passWord.equals("123456")){
			request.setAttribute("success", "登录成功！！");
		}
		return "home";
	}
	
	/**
	 * 忘记密码
	 */
	@RequestMapping("retrieve_pwd")
	public String retrieve_pwd(){
		
		return "retrieve_pwd";
	}
	
	/**
	 * 验证（验证码
	 * @param request
	 * @return
	 */
	@RequestMapping("register")
	public String register(HttpServletRequest request){
		
		HttpSession session = request.getSession(true);
		String checkCode = (String) session.getAttribute("verCode");
		//验证码
	    String paramsCheckCode = request.getParameter("checkCode").trim();
	        
		 if (checkCode.equalsIgnoreCase(paramsCheckCode)) {
	            System.out.println("check code ok");
	            
	            request.setAttribute("success_1", "尊敬的admin用户，您的密码为：123456 <br/>验证码 OK");
	        } else {
	        	
	        	request.setAttribute("success_1", "尊敬的admin用户，您的密码为：123456 <br/>验证码 not OK");
	        }
		
		String userName = request.getParameter("userName");
		String passWord = request.getParameter("passWord");
		if(userName.equals("admin") && passWord.equals("123456"))
		{
			request.setAttribute("success", "修改密码成功！！");
		}
		
		return "home";
	}
}
