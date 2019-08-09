package com.angular.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.angular.dao.UserDao;
import com.angular.entity.User;
import com.angular.pageutils.PageBean;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImpl implements IUserService{
    @Autowired
	private UserDao userDao;

	@Override
	public PageBean<User> queryUserInfoByName(User user, int currentPage, int pageSize) {
		PageBean<User> pageBean=new  PageBean<User>();;
		List<User> list=null;
		int allRow=0;//总条数
		int offset=0;//偏移量
			try {
				offset = (currentPage == 1 ? 0 : (currentPage-1)*pageSize);//开始页的索引，mysql 默认从零开始
				list=userDao.queryUserInfoByName(user.getName(),offset, pageSize);//分页查询
				allRow=userDao.countUserInfoByName(user.getName());//统计
				pageBean.setAllRow(allRow);//设置总条数数据
				pageBean.setCurrentPage(PageBean.countCurrentPage(currentPage));//当前页
				pageBean.setPageSize(pageSize);//页面大小
				pageBean.setTotalPage(pageBean.totalPage(pageSize, allRow));//计算总页数
				pageBean.setList(list);
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		   return	pageBean;
	}
    
	@Override
	public User loginUserInfo(User user) {
		User info=userDao.get(user);
		return info!=null?info:null;
	}
	@Transactional
	@Override
	public boolean saveUser(User user) {
		boolean bol=false;
		int a=userDao.insert(user);
		if(a>0){
			log.info("######insertUserResult:{}##########", a);
			bol=true;
		}
		return bol;
	}

	@Override
	public User getUserById(User user) {
		User info=userDao.get(user);
		return info!=null?info:null;
	}
	@Transactional
	@Override
	public boolean updateUserById(User user) {
		boolean bol=false;
		int a=userDao.update(user);
		if(a>0){
			log.info("######updateUserResult:{}##########", a);
			bol=true;
		}
		return bol;
	}
	@Transactional
	@Override
	public boolean deletUserById(User user) {
		boolean bol=false;
		int a=userDao.delete(user);
		if(a>0){
			log.info("######deleteUserResult:{}##########", a);
			bol=true;
		}
		return bol;
	}

	@Override
	public PageInfo<User> queryUser(User user,Integer page, Integer pageSize) {
		PageInfo<User> pageInfo=null;
	      List<User>	listUser=userDao.queryUserInfoByName(user.getName(), page, pageSize);
		  PageHelper.startPage(page, pageSize);//设置查询初始页面
		  pageInfo=new PageInfo<User>(listUser);
		return pageInfo;
	}
    
}
