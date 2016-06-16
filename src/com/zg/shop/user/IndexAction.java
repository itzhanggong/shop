package com.zg.shop.user;

import com.opensymphony.xwork2.ActionSupport;

public class IndexAction extends ActionSupport{
	
	@Override
	public String execute() throws Exception {
		
		return "indexSuccess";
	}
}
