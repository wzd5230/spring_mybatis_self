package cn.wzd.mybatis.dao;

import cn.wzd.mybatis.po.User;

public interface UserDAO {
	
	//通过user id好查找user表
	public User findUserById(int id)throws Exception;

}
