package com.zg.shop.user;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.zg.shop.common.Constant;
import com.zg.shop.utils.MailUtils;
import com.zg.shop.utils.Md5Utils;
import com.zg.shop.utils.UUIDUtils;


@Transactional
public class UserService{
	private UserDao userDao;
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public void regist(User user) {
		//保存用户
		user.setState(Constant.UNACTIVE);
		user.setCode(UUIDUtils.getUUID());
		String md5Password = Md5Utils.md5(user.getPassword());
		user.setPassword(md5Password);
		userDao.save(user);
		
		//发送邮件
		try {
			MailUtils.sendMail(user.getEmail(), user.getCode());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 根据激活码查用户
	 * @return
	 */
	public User findByCode(String code) {
		User user = userDao.findByCode(code);
		return user;
	}

	public void update(User existUser) {
		userDao.update(existUser);
	}

	public User login(User user) {
		String md5Password = Md5Utils.md5(user.getPassword());
		user.setPassword(md5Password);
		return userDao.login(user);
	}

	public User findByUsername(String username) {
		return userDao.findByUsername(username);
	}
	
	
}
