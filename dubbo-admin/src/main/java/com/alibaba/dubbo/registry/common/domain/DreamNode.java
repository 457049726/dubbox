package com.alibaba.dubbo.registry.common.domain;

import java.util.Date;

public class DreamNode extends Entity {

	/**
	 * 节点名
	 */
	private String name;

	/**
	 * 节点ip
	 */
	private String ip;


	/**
	 * 监控结果描述
	 */
	private String result;

	/**
	 * 节点状态 -1 不通，0末知，1正常，2停用
	 */
	private String state;

	/**
	 * 监控是否通过
	 */
	private boolean success;

	/**
	 * 监控耗时
	 */
	private long usedTime;

	/**
	 * 最近一次监控时间
	 */
	private String monitorTime;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public long getUsedTime() {
		return usedTime;
	}

	public void setUsedTime(long usedTime) {
		this.usedTime = usedTime;
	}

	public String getMonitorTime() {
		return monitorTime;
	}

	public void setMonitorTime(String monitorTime) {
		this.monitorTime = monitorTime;
	}

	
	

}
