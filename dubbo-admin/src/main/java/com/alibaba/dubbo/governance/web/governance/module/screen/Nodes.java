package com.alibaba.dubbo.governance.web.governance.module.screen;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.governance.web.common.module.screen.Restful;
import com.alibaba.dubbo.registry.common.domain.DreamNode;
import com.dream.portal.dubboext.monitor.node.conf.NodeMonitorConf;
import com.dream.portal.dubboext.monitor.node.conf.NodeMonitorConfItem;
import com.dream.portal.model.nodemonitor.MonitorNode;
import com.dream.portal.model.nodemonitor.NodeMonitorResult;
import com.dream.portal.nodemonitor.NodemonitorService;

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
	
	@Autowired
	private NodeMonitorConf nodeMonitorConf;
	
	@Autowired
	private NodemonitorService nodemonitorService;
	
	private static Map<String,DreamNode>NODES=null;
	
	/**
	 * 节点监控应用的名字
	 */
	private static String NODE_MONITOR_NAME="newdream-portal-nodemonitor0";
	
	/**
	 * 查看节点
	 * @param id
	 * @param context
	 */
	public void queryById(Long id, Map<String, Object> context) {
//		if(StringUtils.isBlank(name)){
//			index(context);
//			return;
//		}
		logger.info("来查看了，节点:"+id);
		
	}
	
	
	public void index( Map<String, Object> context) {
//		name,ip,result,state,success,usedTime,monitorTime
		if(NODES==null){
			Map<String,DreamNode>nodes=new HashMap<String,DreamNode>();
			long i=0;
			for(NodeMonitorConfItem conf:nodeMonitorConf.getNodeMonitorMap().values()){
				DreamNode node=new DreamNode();
				node.setName(conf.getName());
				node.setIp(conf.getIp());
				node.setType(conf.getNodeType());
				node.setId(i++);
				nodes.put(conf.getName(),node);
				
				
			}
			NODES=nodes;
		}
		
		
		try {
			Map<String, NodeMonitorResult>map=nodemonitorService.queryResultByName(NODE_MONITOR_NAME);
			
			
			for(String key:map.keySet()){
				
				String name=key.split(NodeMonitorResult.SEPARATOR)[1];
				if(NODES.get(name)!=null){
					DreamNode n=NODES.get(name);
					NodeMonitorResult res=map.get(key);
					if(res!=null){
						n.setResult(res.getResult());
						n.setState(res.getState());
						n.setSuccess(res.isSuccess());
						n.setUsedTime(res.getUsedTime());
						n.setMonitorTime(res.getMonitorTime());
					}
				}
				
			}
		} catch (Throwable e) {
			logger.error("query node states error,mybe cann't connect to nodemonitor server,"+e.getMessage(),e);
		}
		
		context.put("nodes", NODES);
		
		
	}

}
