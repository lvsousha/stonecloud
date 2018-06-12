package com.stone.webapp.util.ignite;

import javax.cache.CacheException;

import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.IgniteException;
import org.apache.ignite.Ignition;

public class IgniteUtil {

    private static IgniteCache<String, Object> cache;

    private static String cacheName = "stoneCache";

    public IgniteUtil() {
    }

    static {
        try {
            Ignite ignite = Ignition.ignite();
            cache = ignite.cache(cacheName);
        }catch (IgniteException e){
            throw new IgniteException("ignite: Configuration file read failure....", e);
        }
    }

    public static void putCacheObj(String key,String obj){
        try {
            cache.put(key,obj);
        }catch (IgniteException | IllegalStateException | CacheException e){
            throw new IgniteException("ignite: Cache put failure....", e);
        }
    }

    public static Object getCacheObj(String key){
        try {
            return cache.get(key);
        }catch (IgniteException | IllegalStateException | CacheException e){
            throw new IgniteException("ignite: Cache get failure....", e);
        }
    }

    public static void removeCacheObj(String key){
        try {
            cache.remove(key);
        }catch (IgniteException | IllegalStateException | CacheException e){
            throw new IgniteException("ignite: Cache remove failure....", e);
        }
    }

    public static void updateCacheObj(String key,String obj){
        try {
            cache.replace(key,obj);
        }catch (IgniteException | IllegalStateException | CacheException e){
            throw new IgniteException("ignite: Cache update failure....", e);
        }
    }

}
