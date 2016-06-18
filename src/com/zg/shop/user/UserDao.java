package com.zg.shop.user;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.zg.shop.common.Constant;
import com.zg.shop.utils.Md5Utils;

public class UserDao extends HibernateDaoSupport {

	/**
	 * DAO层保存用户
	 * 
	 * @param user
	 */
	public void save(User user) {
		this.getHibernateTemplate().save(user);
	}

	public User findByCode(String code) {
		List<User> users = this.getHibernateTemplate().find("from User where code = ?", code);
		if(users.size() > 0){			
			return users.get(0);
		}
		return null;
	}

	public void update(User existUser) {
		this.getHibernateTemplate().update(existUser);
	}

	public User login(User user) {
		List<User> users = this.getHibernateTemplate().find("from User where username = ? and password = ? and state = ?", user.getUsername(),
				user.getPassword(), Constant.ACTIVE);
		if(users.size() != 0){			
			return users.get(0);
		}
		return null;
	}

	public User findByUsername(String username) {
		List<User> users = this.getHibernateTemplate().find("from User where username = ?", username);
		if(users.size() > 0){			
			return users.get(0);
		}
		return null;
	}

}
