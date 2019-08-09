package com.angular.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * @author: MaoJiaBin
 * @date: 2018/7/16
 * @description: 解决Axios跨域问题
 */
public class AxiosOptionsInterceptor extends HandlerInterceptorAdapter {

	private final Logger logger = LoggerFactory.getLogger(AxiosOptionsInterceptor.class);

	/**
	 * 服务器支持的所有跨域请求的方法源（发起方），暂时配置为* 允许全部--必填
	 */
	@Value("${cors.Access-Control-Allow-Origin}")
	private String accessControlAllowOrigin;

	/**
	 * 服务器支持的所有跨域请求的方法--必填
	 */
	@Value("${cors.Access-Control-Allow-Methods}")
	private String accessControlAllowMethods;

	/**
	 * 服务器支持的所有头信息字段--如果请求头包含Access-Control-Request-Headers 则必填
	 */
	@Value("${cors.Access-Control-Allow-Headers}")
	private String accessControlAllowHeaders;

	/**
	 * 该字段可选，用来指定本次预检请求的有效期, 单位为秒--可选
	 */
	@Value("${cors.Access-Control-Max-Age}")
	private String accessControlMaxAge;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

		logger.debug("accessControlAllowOrigin:{}", accessControlAllowOrigin);

		String method = request.getMethod();
		response.setHeader("Access-Control-Allow-Origin", accessControlAllowOrigin);
		response.setHeader("Access-Control-Allow-Methods", accessControlAllowMethods);
		if (request.getHeader("Access-Control-Request-Headers") != null) {
			response.setHeader("Access-Control-Allow-Headers", accessControlAllowHeaders);
		}
		response.setHeader("Access-Control-Max-Age", accessControlMaxAge);

		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");
		response.setDateHeader("Expires", -1);

		if (method.equals("OPTIONS")){
			response.setStatus(204);// 204: 成功，但是没有返回数据。浏览器不用刷新页面，也不用导向新的页面
			return false;
		}

		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

	}
}
