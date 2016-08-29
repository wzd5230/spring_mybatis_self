package cn.wzd.mybatis.mapper;

import java.util.List;

import cn.wzd.mybatis.po.User;

public interface UserMapper {
	
	//通过用户id获取user表
	public User findUserByIdMapper(int id)throws Exception;
	
	//查询用户表，关联查询订单表，使用嵌套查询，延迟加载的方式。
	public List<User> findUserAndOrdersResultMapper() throws Exception;

}
