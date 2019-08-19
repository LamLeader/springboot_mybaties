package com.angular.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.angular.dao.basedao.CrudDao;
import com.angular.entity.User;

@Repository("userDao")
public interface UserDao extends CrudDao<User>{
	   /**
	    * 根据用户名进行用户查询
	    * @param user
	    * @param currentPage
	    * @param pageSize
	    * @return
	    */
	   public List<User> queryUserInfoByName(@Param("name")String name,
			   @Param("currentPage") int currentPage,
			   @Param("pageSize") int pageSize);
	   /**
	    * 用户查询统计
	    * @param user
	    * @param currentPage
	    * @param pageSize
	    * @return
	    */
	   public int countUserInfoByName(@Param("name")String name);
	   
	   
	   /**
	    * 用户登录
	    * @param user
	    * @return
	    */
	   public User loginUserInfo(User user);
	   
	   
	   
}
