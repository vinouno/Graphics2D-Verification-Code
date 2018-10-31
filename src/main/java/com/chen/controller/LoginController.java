package com.chen.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

	/**
	 * ��¼��֤
	 * @param request
	 * @return
	 */
	@RequestMapping("login")
	public String home(HttpServletRequest request){
		
		HttpSession session = request.getSession(true);
		String checkCode = (String) session.getAttribute("verCode");
		//��֤��
	    String paramsCheckCode = request.getParameter("checkCode").trim();
	        
		 if (checkCode.equalsIgnoreCase(paramsCheckCode)) {
            System.out.println("check code ok");
            
            request.setAttribute("success_1", "�𾴵�admin�û�����������Ϊ��123456 <br/>��֤�� OK");
		 } else {
        	
        	request.setAttribute("success_1", "�𾴵�admin�û�����������Ϊ��123456 <br/>��֤�� not OK");
		 }
		 
		String userName = request.getParameter("userName");
		String passWord = request.getParameter("passWord");
		if(userName.equals("admin") && passWord.equals("123456")){
			request.setAttribute("success", "��¼�ɹ�����");
		}
		return "home";
	}
	
	/**
	 * ��������
	 */
	@RequestMapping("retrieve_pwd")
	public String retrieve_pwd(){
		
		return "retrieve_pwd";
	}
	
	/**
	 * ��֤����֤��
	 * @param request
	 * @return
	 */
	@RequestMapping("register")
	public String register(HttpServletRequest request){
		
		HttpSession session = request.getSession(true);
		String checkCode = (String) session.getAttribute("verCode");
		//��֤��
	    String paramsCheckCode = request.getParameter("checkCode").trim();
	        
		 if (checkCode.equalsIgnoreCase(paramsCheckCode)) {
	            System.out.println("check code ok");
	            
	            request.setAttribute("success_1", "�𾴵�admin�û�����������Ϊ��123456 <br/>��֤�� OK");
	        } else {
	        	
	        	request.setAttribute("success_1", "�𾴵�admin�û�����������Ϊ��123456 <br/>��֤�� not OK");
	        }
		
		String userName = request.getParameter("userName");
		String passWord = request.getParameter("passWord");
		if(userName.equals("admin") && passWord.equals("123456"))
		{
			request.setAttribute("success", "�޸�����ɹ�����");
		}
		
		return "home";
	}
}
