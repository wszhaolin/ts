package com.baizhi.cache;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;

public class MyCacheManager implements CacheManager {

    private MyCache myCatch;

    public MyCacheManager(MyCache myCatch){
        this.myCatch = myCatch;
    }

    @Override
    public <K, V> Cache<K, V> getCache(String s) throws CacheException {
        return myCatch;
    }
}
