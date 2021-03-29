package com.example.demo.utils;

import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.spring.SpringUtil;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @author {曹炳全}
 * @Description
 * @date 2020/9/23 16:57
 */
public class RedisUtil {

    private static RedisTemplate redisTemplate;
    /**
     * 设置过期时间
     * @param key 键 时间 秒
     * @return boolean
     */
    public static boolean expire(String key, long time) {
        try {
            if (time > 0) {
                getRedisTemplate().expire(key, time, TimeUnit.SECONDS);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    /**
     * 普通缓存获取
     * @param key 键
     * @return 值
     */
    public static Object get(String key) {
        return key == null ? null :  getRedisTemplate().opsForValue().get(key);
    }


    /**
     * 普通缓存放入
     * @param key 键
     * @param value 值
     * @return true成功 false失败
     */
    public static boolean set(String key, Object value) {
        try {
            if (null == key) {
                return false;
            }
            getRedisTemplate().opsForValue().set(key, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 普通缓存放入并设置时间
     * @param key 键
     * @param value 值
     * @param time 时间(秒) time要大于0 如果time小于等于0 将设置无限期
     * @return true成功 false 失败
     */
    public static boolean set(String key, Object value, long time) {
        try {
            if (time > 0) {
                getRedisTemplate().opsForValue().set(key, value, time, TimeUnit.SECONDS);
            } else {
                set(key, value);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    /**
     * 普通缓存放入并设置时间
     * @param key 键
     * @param value 值
     * @param time 时间
     * @return true成功 false 失败
     */
    public static boolean set(String key, Object value, long time,TimeUnit timeUnit) {
        try {
            if (time > 0) {
                getRedisTemplate().opsForValue().set(key, value, time, timeUnit);
            } else {
                set(key, value);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    /**
     * 递增
     * @param key 键
     * @param delta 要增加几(大于0)
     * @return
     */
    public static long incr(String key, long delta) {
        if (delta < 0) {
            throw new RuntimeException("递增因子必须大于0");
        }
        return getRedisTemplate().opsForValue().increment(key, delta);
    }

    /**
     * 递减
     * @param key 键
     * @param delta 要减少几(小于0)
     * @return
     */
    public static long decr(String key, long delta) {
        if (delta < 0) {
            throw new RuntimeException("递减因子必须大于0");
        }
        return getRedisTemplate().opsForValue().increment(key, -delta);

    }
    /**
     * 判断key是否存在
     * @param key 键
     * @return true 存在 false不存在
     */
    public static boolean hasKey(String key) {
        try {
            return getRedisTemplate().hasKey(key);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean delete(String key){
        return getRedisTemplate().delete(key);
    }
    public static String getAndSet(String key,String value){
        return (String) getRedisTemplate().boundValueOps(key).getAndSet(value);
    }

    public static Object popSet(String key){
        return getRedisTemplate().boundSetOps(key).pop();
    }
    public static List popSet(String key, long count) {
        return StrUtil.isBlank(key) || 0L == count ? null : getRedisTemplate().boundSetOps(key).randomMembers(count);
    }
    public static Object addSet(String key,Object ... value){
        return getRedisTemplate().boundSetOps(key).add(value);
    }

    public static Set getSetMembers(String key){
        return getRedisTemplate().boundSetOps(key).members();
    }

    public static Object leftPopList(String key){
        return getRedisTemplate().boundListOps(key).leftPop();
    }
    public static Object leftPushList(String key,Object value){
        return getRedisTemplate().boundListOps(key).leftPush(value);
    }
    public static Object rightPopList(String key){
        return getRedisTemplate().boundListOps(key).rightPop();
    }
    public static Object rightPushList(String key,Object value){
        return getRedisTemplate().boundListOps(key).rightPush(value);
    }
    public static RedisTemplate getRedisTemplate(){
        if(redisTemplate==null){
            redisTemplate= (RedisTemplate) SpringUtil.getBean("stringRedisTemplate");
        }
        return redisTemplate;
    }

    public static Set<String> getKeys(String keyPart){
        return getRedisTemplate().keys(keyPart);
    }

    public static Long deleteSet(Set<String> keys){
        return getRedisTemplate().delete(keys);
    }

    public static Boolean setIfAbsent(String key,Object value){
        return getRedisTemplate().boundValueOps(key).setIfAbsent(String.valueOf(value));
    }
    public static Boolean setIfAbsent(String key,Object value,long time,TimeUnit timeUnit){
        if(setIfAbsent(key,value)){
            return set(key,value,time,timeUnit);
        }
        return false;
    }
    public static Long deleteSetValue(String key,Object... value){
        return getRedisTemplate().boundSetOps(key).remove(value);
    }

}
