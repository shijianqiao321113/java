package com.maven.project.tools.redis;

import java.util.List;

/**
 * redis 操作类，方法汇总
 */
public interface JredisOper {
	
	/** 通用方法 */
	public long getTtl(String key);
	
	public boolean isExists(String key);
	
	public boolean delData(String key);
	
	
	/** string 相关方法 */
	public boolean setValue_str(String key,String value);
	
	public boolean setValue_str_expire(String key,String value,int second);
	
	public boolean setValue_str_expireAt(String key,String value,long ten_timestamp);
	
	public String getValue_str(String key);
	
	
	/** hash 相关方法  */
	public boolean setValue_hs(String key,String field,String value);
	
	public boolean setValue_hs_expire(String key,String field,String value,int second);
	
	public boolean setValue_hs_expireAt(String key,String field,String value,long ten_timestamp);
	
	public String getValue_hs(String key,String field);
	
	public boolean delData_hs(String key,String field);
	
	public int getHlen_hs(String key);
	
	
	/** list 相关方法  */
	public boolean Rpush_list(String key,String value);
	
	public boolean Rpush_list_expire(String key,String value,int second);
	
	public boolean Rpush_list_expireAt(String key,String value,long ten_timestamp);
	
	public String getValue_list_rpop(String key);
	
	public boolean Lpush_list(String key,String value);
	
	public boolean Lpush_list_expire(String key,String value,int second);
	
	public boolean Lpush_list_expireAt(String key,String value,long ten_timestamp);
	
	public String getValue_list_lpop(String key);
	
	public boolean delData_list_lrem(String key,String value);
	
	public int getLlen_list(String key);
	
	public List<String> getLrange_list(String key);
	
	/** redis 消息发布 */
	public boolean pubLish_Message(String channel,String message);
	
}
