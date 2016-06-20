package com.zg.shop.user;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.interceptor.annotations.InputConfig;

/**
 * 用户的Action
 * @author Administrator
 *
 */
public class UserAction extends ActionSupport implements ModelDriven<User>{
	private User user = new User();
	private UserService userService;
	private String checkImgCode;
	@Override
	public User getModel() {
		return user;
	}
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	public void setCheckImgCode(String checkImgCode) {
		this.checkImgCode = checkImgCode;
	}

	/**
	 * 注册页面跳转
	 * @return
	 */
	public String registPage(){
		return "registPageSuccess";
	}
	
	/**
	 * 登录页面跳转
	 */
	public  String loginPage(){
		return "loginPageSuccess";
	}
	
	/**
	 * 用户的注册
	 * @return
	 */
	@InputConfig(resultName="registInput")
	public String regist(){
		String checkcode = (String) ServletActionContext.getRequest().getSession().getAttribute("checkcode");
		if(checkImgCode == null || !checkImgCode.equalsIgnoreCase(checkcode) ){
			this.addActionError("验证码错误");
			return "registInput";
		}
		userService.regist(user);
		this.addActionMessage("注册成功，请去邮箱激活！");
		return "registSuccess";
	} 
	
	/**
	 * 激活用户
	 * @return
	 */
	public String active(){
		User existUser = userService.findByCode(user.getCode());
		if(existUser != null){
			existUser.setState("2");
			userService.update(existUser);
			this.addActionMessage("激活成功，请登录！");
		}else{
			this.addActionMessage("激活失败，激活码有误！");			
		}
		return "activeMsg";
	}
	
	/**
	 * 用户登录
	 * @return
	 */
	@InputConfig(resultName="loginInput")
	public String login(){
		User existUser = userService.login(user);
		if(existUser == null){
			this.addActionError("用户名或密码错误，或用户未激活！");
			return "loginInput";
		}else{
			ServletActionContext.getRequest().getSession().setAttribute("existUser", existUser);
			return "loginSuccess";		
		}
	}
	
	public String checkUserName() throws IOException{
		System.out.println("=========================");
		User existUser = userService.findByUsername(user.getUsername());
		HttpServletResponse response =  ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		if(existUser == null){
			//用户名可以使用
			response.getWriter().print("<font color='green'>用户名可以使用</font>");
		}else {
			//用户名已存在
			response.getWriter().print("<font color='red'>用户名已经存在</font>");
		}
		return NONE;
	}
	
	public String loginOut(){
		ServletActionContext.getRequest().getSession().invalidate();
		return "loginOutSuccess";
	}
}
