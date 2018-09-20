package com.ifourthwall.dbm.user.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component
public class RedisFactoryHelper {

    private Logger logger = LoggerFactory.getLogger(RedisFactoryHelper.class);

    @Autowired
    private RedisConnectionFactory redisConnectionFactory;

    public void put(String key, String value) {
        RedisConnection conn = this.getConnection();
        conn.set(key.getBytes(), value.getBytes());
        conn.close();
    }

    public void putWithExpireSeconds(String key, String value, long seconds) {
        RedisConnection conn = this.getConnection();
        conn.setEx(key.getBytes(), seconds, value.getBytes());
        conn.close();
    }

    public void refresh(String key, long seconds) {
        RedisConnection conn = this.getConnection();
        conn.expire(key.getBytes(), seconds);
        conn.close();
    }

    public long delete(String key) {
        long count = 0;
        RedisConnection conn = this.getConnection();
        count = conn.del(key.getBytes());
        conn.close();
        return count;
    }

    public String get(String key) {
        String result = null;
        RedisConnection conn = null;
        try {
            conn = this.getConnection();
            byte[] bs = conn.get(key.getBytes());
            if (bs != null) {
                result = new String(bs, "utf-8");
            }
        } catch (Exception e) {
            this.logger.error("Can't find redis key:{}", key);
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
        return result;
    }

    public long lPush(String key, String value) {
        RedisConnection conn = this.getConnection();
        long result = conn.lPush(key.getBytes(), value.getBytes());
        conn.close();
        return result;
    }

    public List<String> rPop(String key) {
        RedisConnection conn = this.getConnection();
        long count = conn.lLen(key.getBytes());
        List<String> resultList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            byte[] bytes = conn.rPop(key.getBytes());
            resultList.add(new String(bytes));
        }
        conn.close();
        return resultList;
    }

    /**
     * 根据正则表达式匹配所有key
     *
     * @param pattern
     * @return
     * @author gaozhibiao
     * Date: 2017年4月19日 下午6:41:54
     */
    public List<String> getKeys(String pattern) {
        RedisConnection conn = null;
        List<String> result = new ArrayList<String>();
        try {
            conn = this.getConnection();
            Set<byte[]> keys = conn.keys(pattern.getBytes());
            for (byte[] key : keys) {
                result.add(new String(key, "utf-8"));
            }
        } catch (Exception e) {
            this.logger.error("Error regular expression:{}", pattern);
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
        return result;
    }

    public void deleteKeys(String pattern) {
        for (String key : this.getKeys(pattern)) {
            this.delete(key);
        }
    }

    private RedisConnection getConnection() {
        return this.redisConnectionFactory.getConnection();
    }
}
