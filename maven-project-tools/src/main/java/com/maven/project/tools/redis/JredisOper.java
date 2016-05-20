package com.maven.project.tools.redis;

public interface JredisOper {
	
//	public int get
	
	public boolean isExists(String key);
	
	public boolean setValue_str(String key,String value);
	
	public boolean setValue_str_expire(String key,String value,long second);
	
	public boolean setValue_str_expireAt(String key,String value,long ten_timestamp);
	
	public String getValue_str(String key);
	
	
	public boolean delData(String key);
	
	
	public boolean setValue_hs(String key,String field,String value);
	
	public boolean setValue_hs_expire(String key,String field,String value,long second);
	
	public boolean setValue_hs_expireAt(String key,String field,String value,long ten_timestamp);
	
	public String getValue_hs(String key,String field);
	
	public boolean delData_hs(String key,String field);
	
	public int getHlen_hs(String key);
	
	
	public boolean startRpush_list(String key,String value);
	
	public boolean startRpush_list_expire(String key,String value,long second);
	
	public boolean startRpush_list_expireAt(String key,String value,long ten_timestamp);
	
	public boolean endLpush_list(String key,String value);
	
	public boolean endLpush_list_expire(String key,String value,long second);
	
	public boolean endLpush_list_expireAt(String key,String value,long ten_timestamp);
	
	public String getValue_list_lpop(String key);
	
	public String getValue_list_rpop(String key);
	
	public boolean delData_list_lrem(String key,String value);
	
	public int getLlen_list(String key);
	
	
}
