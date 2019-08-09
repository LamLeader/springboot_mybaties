package com.angular.service;


import com.angular.entity.User;
import com.angular.pageutils.PageBean;
import com.github.pagehelper.PageInfo;

public interface IUserService {
	 /**
	    * 根据用户名进行用户查询
	    * @param user
	    * @param currentPage
	    * @param pageSize
	    * @return
	    */
	   public PageBean<User> queryUserInfoByName(User user,
			  int currentPage,
			  int pageSize);
	   
	   /**
	    * 用户登录
	    * @param user
	    * @return
	    */
	   public User loginUserInfo(User user);
	   
	   /**
	    * 用户新增
	    * @param user
	    * @return
	    */
	   public boolean saveUser(User user);
	   
	   /**
	    * 获取单个用户信息
	    * @param user
	    * @return
	    */
	   public User getUserById(User user);
	   
	   
	   /**
	    * 用户修改
	    * @param user
	    * @return
	    */
	   public boolean updateUserById(User user);
	   
	   /**
	    * 用户删除
	    * @param user
	    * @return
	    */
	   public boolean deletUserById(User user);
       
	   /**
	    * PageInfo分页插件
	    * @param user
	    * @return
	    */
	   public PageInfo<User> queryUser(User user,Integer page, Integer pageSize);
   
   
}
