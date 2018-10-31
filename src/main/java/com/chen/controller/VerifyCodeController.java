package com.chen.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chen.util.VerifyCodeUtils;

@Controller
public class VerifyCodeController {

	/**
	 * ������֤��
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	@RequestMapping("verifyCode")
	public void verifyCode(HttpServletRequest request, HttpServletResponse response) throws IOException{ 
        response.setHeader("Pragma", "No-cache"); 
        response.setHeader("Cache-Control", "no-cache"); 
        response.setDateHeader("Expires", 0); 
        response.setContentType("image/jpeg"); 
           
        //��������ִ� 
        String verifyCode = VerifyCodeUtils.generateVerifyCode(4); 
        //����Ựsession 
        HttpSession session = request.getSession(true); 
        //ɾ����ǰ��
        session.removeAttribute("verCode");
        session.setAttribute("verCode", verifyCode.toLowerCase()); 
        //����ͼƬ 
        int w = 100, h = 30; 
        VerifyCodeUtils.outputImage(w, h, response.getOutputStream(), verifyCode); 
        
	}
	
}
