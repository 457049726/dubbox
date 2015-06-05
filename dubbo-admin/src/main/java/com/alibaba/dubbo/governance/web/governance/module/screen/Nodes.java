package com.alibaba.dubbo.governance.web.governance.module.screen;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.governance.web.common.module.screen.Restful;
import com.alibaba.dubbo.registry.common.domain.Provider;

/**
 * 节点
 * 
 * @author Administrator
 *
 */
public class Nodes extends Restful {

	@Autowired
	private HttpServletResponse response;

	@Autowired
	private HttpServletRequest request;
	
	public void index( Map<String, Object> context) {
		System.out.println("来访问节点来了。。。");
	}

}
