package com.angular.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.angular.entity.User;
import com.angular.pageutils.PageBean;
import com.angular.service.IUserService;
import com.github.pagehelper.PageInfo;

@RestController
public class UserController {
   
	@Autowired
	private IUserService userService;
	
	
	/**
	 * 用户数据插入
	 * @param age
	 * @param name
	 * @param psw
	 * @return
	 */
	@RequestMapping(value="/insertUser.do")
	public Map<String, Object> insertUser(@RequestParam(value="age",defaultValue="",required=false)Integer age,
			@RequestParam(value="name",defaultValue="",required=false)String name,
			@RequestParam(value="psw",defaultValue="",required=false)String psw){
		Map<String, Object> map=new HashMap<String, Object>();
		User user=new User();
		user.setAge(age);user.setName(name);user.setPsw(psw);
	    boolean bol=userService.saveUser(user);
	    map.put("bol", bol);
		return map;
	}
	/**
	 * pageHelp分页插件
	 * 127.0.0.1:9091/queryUserPageHelp.do
	 * 用户数据查询
	 * @param user
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	@RequestMapping(value="/queryUserPageHelp.do")
	public PageInfo<User> queryUserPageHelp(
			User user,
			@RequestParam(value="name",required=false,defaultValue="") String name,
			@RequestParam(value="pageNum",required=false,defaultValue="0") int pageNum,
    		@RequestParam(value="pageSize",required=false,defaultValue="6") int pageSize){
		user.setName(name);
		PageInfo<User> pageUserList=userService.queryUser(user, pageNum, pageSize);
		for (int i = 0; i < pageUserList.getList().size(); i++) {
			 System.out.println(pageUserList.getList().get(i).getName());
		}
		
		return pageUserList;
	}
	/**
	 * 127.0.0.1:9091/queryUser.do
	 * 192.168.43.186:9091/queryUser.do
	 * @param user
	 * @return
	 */
	/**
	 * 用户数据查询
	 * @param user
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	@RequestMapping(value="/queryUser.do")
	public Map<String, Object> queryUser(
			User user,
			@RequestParam(value="name",required=false,defaultValue="") String name,
			@RequestParam(value="pageNum",required=false,defaultValue="1") int pageNum,
    		@RequestParam(value="pageSize",required=false,defaultValue="12") int pageSize){
		user.setName(name);
		PageBean<User> userList=userService.queryUserInfoByName(user, pageNum, pageSize);
		Map<String, Object> map=new HashMap<String, Object>();
		/*for (int i = 0; i < userList.getList().size(); i++) {
			 System.out.println(userList.getList().get(i).getName());
		}
		*/
		map.put("userList", userList.getList());
		map.put("total", userList.getAllRow());
		return map;
	}
	/**
	 * 根据id 删除用户信息
	 * @param user
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/removeUserById.do")
    public Map<String, Object>  removeUserById(User user,
			@RequestParam(value="id",required=false,defaultValue="") Integer id){
    	user.setId(id);
    	Map<String, Object> map=new HashMap<String, Object>();
    	boolean bol=userService.deletUserById(user);
    	map.put("bol", bol);
    	return map;
    	
    }
	/**http://192.168.0.112:9091/getUserById.do?id=32&callback=JSON_CALLBACK
	 * 根据id找到用户信息
	 * @param user
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/getUserById.do")
	public Map<String, Object> getUserById(User user,
			@RequestParam(value="id",required=false,defaultValue="") Integer id){
		Map<String, Object> map=new HashMap<String, Object>();
		user.setId(id);
	    User userInfo= userService.getUserById(user);
		map.put("userInfo", userInfo);
    	return map;
	}
	
	/**
	 * 用户数据修改
	 * @param age
	 * @param name
	 * @param psw
	 * @return
	 */
	@RequestMapping(value="/updateUserById.do")
	public Map<String, Object> updateUserById(
			@RequestParam(value="id",required=false,defaultValue="") Integer id,
			@RequestParam(value="age",defaultValue="",required=false)Integer age,
			@RequestParam(value="name",defaultValue="",required=false)String name,
			@RequestParam(value="psw",defaultValue="",required=false)String psw){
		Map<String, Object> map=new HashMap<String, Object>();
		User user=new User();
		user.setAge(age);user.setName(name);user.setPsw(psw);user.setId(id);
	    boolean bol=userService.updateUserById(user);
	    map.put("bol", bol);
		return map;
	}
	
}
