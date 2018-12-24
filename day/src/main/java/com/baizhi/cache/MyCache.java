package com.baizhi.cache;

import org.apache.commons.lang3.SerializationUtils;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import redis.clients.jedis.Jedis;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

/**
 * shiro的自定义缓存实现
 */
public class MyCache implements Cache {

    private Jedis jedis;

    public MyCache(String host,int port) {
        this.jedis = new Jedis(host,port);
    }

    @Override
    public Object get(Object k) throws CacheException {
        byte[] bytes = jedis.get(SerializationUtils.serialize((Serializable) k));
        // 反序列化
        if (bytes != null) {
            Object obj = SerializationUtils.deserialize(bytes);
            return obj;
        }
        return null;
    }

    /**
     * 存储缓存数据的方法
     *
     * @param k
     * @param v
     * @return
     * @throws CacheException
     */
    @Override
    public Object put(Object k, Object v) throws CacheException {
        // kv 必须序列化为byte[]
        return jedis.set(SerializationUtils.serialize((Serializable) k), SerializationUtils.serialize((Serializable) v));
    }

    @Override
    public Object remove(Object k) throws CacheException {
        return jedis.del(SerializationUtils.serialize((Serializable) k));
    }

    @Override
    public void clear() throws CacheException {
        jedis.flushDB();
    }

    @Override
    public int size() {
        Long size = jedis.dbSize();
        int count = size.intValue();
        return count;
    }

    @Override
    public Set keys() {
        Set<String> keys = jedis.keys("*");
        return keys;
    }

    @Override
    public Collection values() {
        Set<String> keys = jedis.keys("*");
        ArrayList<String> values = new ArrayList<String>();
        keys.forEach(k -> {
            String v = jedis.get(k);
            values.add(v);
        });
        return values;
    }
}
