package com.maven.project.tools.redis.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.maven.project.tools.redis.JredisOper;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Service
public class JredisOperImp implements JredisOper {

	@Autowired
	private JedisPool jedisPool;
	
	@Override
	public long getTtl(String key) {
		Jedis jedis = jedisPool.getResource();
		try{
			return jedis.ttl(key);
		}finally{
			jedisPool.returnResource(jedis);
		}
	}

	@Override
	public boolean isExists(String key) {
		Jedis jedis = jedisPool.getResource();
		try{
			return jedis.exists(key);
		}finally{
			jedisPool.returnResource(jedis);
		}
	}

	@Override
	public boolean delData(String key) {
		Jedis jedis = jedisPool.getResource();
		try{
			jedis.del(key);
			return Boolean.TRUE;
		}finally{
			jedisPool.returnResource(jedis);
		}
	}

	@Override
	public boolean setValue_str(String key, String value) {
		Jedis jedis = jedisPool.getResource();
		try{
			String result = jedis.set(key, value);
			if(StringUtils.isEmpty(result) || !result.toLowerCase().equals("ok")){
				return Boolean.FALSE;
			}
		}finally{
			jedisPool.returnResource(jedis);
		}
		return Boolean.TRUE;
	}

	@Override
	public boolean setValue_str_expire(String key, String value, int second) {
		Jedis jedis = jedisPool.getResource();
		try{
			String result = jedis.set(key, value);
			if(StringUtils.isEmpty(result) || !result.toLowerCase().equals("ok")){
				return Boolean.FALSE;
			}
			jedis.expire(key, second);
		}finally{
			jedisPool.returnResource(jedis);
		}
		return Boolean.TRUE;
	}

	@Override
	public boolean setValue_str_expireAt(String key, String value, long ten_timestamp) {
		Jedis jedis = jedisPool.getResource();
		try{
			String result = jedis.set(key, value);
			if(StringUtils.isEmpty(result) || !result.toLowerCase().equals("ok")){
				return Boolean.FALSE;
			}
			jedis.expireAt(key, ten_timestamp);
		}finally{
			jedisPool.returnResource(jedis);
		}
		return Boolean.TRUE;
	}

	@Override
	public String getValue_str(String key) {
		Jedis jedis = jedisPool.getResource();
		try{
			return jedis.get(key);
		}finally{
			jedisPool.returnResource(jedis);
		}
	}

	@Override
	public boolean setValue_hs(String key, String field, String value) {
		Jedis jedis = jedisPool.getResource();
		try{
			long result = jedis.hset(key, field, value);
			if(result<=0){
				return Boolean.FALSE;
			}
		}finally{
			jedisPool.returnResource(jedis);
		}
		return Boolean.TRUE;
	}

	@Override
	public boolean setValue_hs_expire(String key, String field, String value, int second) {
		Jedis jedis = jedisPool.getResource();
		try{
			long result = jedis.hset(key, field, value);
			if(result<=0){
				return Boolean.FALSE;
			}
			jedis.expire(key, second);
		}finally{
			jedisPool.returnResource(jedis);
		}
		return Boolean.TRUE;
	}

	@Override
	public boolean setValue_hs_expireAt(String key, String field, String value, long ten_timestamp) {
		Jedis jedis = jedisPool.getResource();
		try{
			long result = jedis.hset(key, field, value);
			if(result<=0){
				return Boolean.FALSE;
			}
			jedis.expireAt(key, ten_timestamp);
		}finally{
			jedisPool.returnResource(jedis);
		}
		return Boolean.TRUE;
	}

	@Override
	public String getValue_hs(String key, String field) {
		Jedis jedis = jedisPool.getResource();
		try{
			return jedis.hget(key, field);
		}finally{
			jedisPool.returnResource(jedis);
		}
	}

	@Override
	public boolean delData_hs(String key, String field) {
		Jedis jedis = jedisPool.getResource();
		try{
			jedis.hdel(key, field);
			return Boolean.TRUE;
		}finally{
			jedisPool.returnResource(jedis);
		}
	}

	@Override
	public int getHlen_hs(String key) {
		Jedis jedis = jedisPool.getResource();
		try{
			return jedis.hlen(key).intValue();
		}finally{
			jedisPool.returnResource(jedis);
		}
	}

	@Override
	public boolean Rpush_list(String key, String value) {
		Jedis jedis = jedisPool.getResource();
		try{
			long queuelength = jedis.rpush(key, value);
			if(queuelength<=0){
				return Boolean.FALSE;
			}
		}finally{
			jedisPool.returnResource(jedis);
		}
		return Boolean.TRUE;
	}

	@Override
	public boolean Rpush_list_expire(String key, String value, int second) {
		Jedis jedis = jedisPool.getResource();
		try{
			long queuelength = jedis.rpush(key, value);
			if(queuelength<=0){
				return Boolean.FALSE;
			}
			jedis.expire(key, second);
		}finally{
			jedisPool.returnResource(jedis);
		}
		return Boolean.TRUE;
	}

	@Override
	public boolean Rpush_list_expireAt(String key, String value, long ten_timestamp) {
		Jedis jedis = jedisPool.getResource();
		try{
			long queuelength = jedis.rpush(key, value);
			if(queuelength<=0){
				return Boolean.FALSE;
			}
			jedis.expireAt(key, ten_timestamp);
		}finally{
			jedisPool.returnResource(jedis);
		}
		return Boolean.TRUE;
	}

	@Override
	public String getValue_list_rpop(String key) {
		Jedis jedis = jedisPool.getResource();
		try{
			return jedis.rpop(key);
		}finally{
			jedisPool.returnResource(jedis);
		}
	}

	@Override
	public boolean Lpush_list(String key, String value) {
		Jedis jedis = jedisPool.getResource();
		try{
			long queuelength = jedis.lpush(key, value);
			if(queuelength<=0){
				return Boolean.FALSE;
			}
		}finally{
			jedisPool.returnResource(jedis);
		}
		return Boolean.TRUE;
	}

	@Override
	public boolean Lpush_list_expire(String key, String value, int second) {
		Jedis jedis = jedisPool.getResource();
		try{
			long queuelength = jedis.lpush(key, value);
			if(queuelength<=0){
				return Boolean.FALSE;
			}
			jedis.expire(key, second);
		}finally{
			jedisPool.returnResource(jedis);
		}
		return Boolean.TRUE;
	}

	@Override
	public boolean Lpush_list_expireAt(String key, String value, long ten_timestamp) {
		Jedis jedis = jedisPool.getResource();
		try{
			long queuelength = jedis.lpush(key, value);
			if(queuelength<=0){
				return Boolean.FALSE;
			}
			jedis.expireAt(key, ten_timestamp);
		}finally{
			jedisPool.returnResource(jedis);
		}
		return Boolean.TRUE;
	}

	@Override
	public String getValue_list_lpop(String key) {
		Jedis jedis = jedisPool.getResource();
		try{
			return jedis.lpop(key);
		}finally{
			jedisPool.returnResource(jedis);
		}
	}

	@Override
	public boolean delData_list_lrem(String key, String value) {
		Jedis jedis = jedisPool.getResource();
		try{
			jedis.lrem(key, 0, value);
			return Boolean.TRUE;
		}finally{
			jedisPool.returnResource(jedis);
		}
	}

	@Override
	public int getLlen_list(String key) {
		Jedis jedis = jedisPool.getResource();
		try{
			return jedis.llen(key).intValue();
		}finally{
			jedisPool.returnResource(jedis);
		}
	}

	@Override
	public List<String> getLrange_list(String key) {
		Jedis jedis = jedisPool.getResource();
		try{
			return jedis.lrange(key, 0, -1);
		}finally{
			jedisPool.returnResource(jedis);
		}
	}

	@Override
	public boolean pubLish_Message(String channel, String message) {
		Jedis jedis = jedisPool.getResource();
		try{
			long result= jedis.publish(channel, message);
			if(result <= 0){
				return Boolean.FALSE;
			}
		}finally{
			jedisPool.returnResource(jedis);
		}
		return Boolean.TRUE;
	}
}
