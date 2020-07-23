package com.caidapao.redismq.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Created by caidapao on 2019-12-9
 * Time 20:17
 *
 * @author caidapao
 */
@Component
public class RedisUtil {

    private static RedisTemplate<String, Object> redisTemplate;

    @Autowired
    public final void init(RedisTemplate<String, Object> redisTemplate) {
        RedisUtil.redisTemplate = redisTemplate;
    }

    /**
     * 将参数中的字符串值设置为键的值，不设置过期时间
     *
     * @param key   键
     * @param value 必须要实现 Serializable 接口
     */
    public static void set(String key, Object value) {
        redisTemplate.opsForValue().set(key, value);
    }

    /**
     * 将参数中的字符串值设置为键的值，设置过期时间
     *
     * @param key     键
     * @param value   必须要实现 Serializable 接口
     * @param timeout 过期时间
     */
    public static void set(String key, Object value, Long timeout) {
        redisTemplate.opsForValue().set(key, value, timeout, TimeUnit.SECONDS);
    }

    /**
     * 获取与指定键相关的值
     *
     * @param key 键
     * @return 值
     */
    public static Object get(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    /**
     * 设置某个键的过期时间
     *
     * @param key 键值
     * @param ttl 过期秒数B
     */
    public static Boolean expire(String key, Long ttl) {
        return redisTemplate.expire(key, ttl, TimeUnit.SECONDS);
    }

    /**
     * 判断某个键是否存在
     *
     * @param key 键值
     */
    public static Boolean hasKey(String key) {
        return redisTemplate.hasKey(key);
    }

    /**
     * 向集合添加元素
     *
     * @param key   键
     * @param value 值
     * @return 返回值为设置成功的value数
     */
    public static Long sAdd(String key, Object... value) {
        return redisTemplate.opsForSet().add(key, value);
    }

    /**
     * 获取集合中的某个元素
     *
     * @param key 键
     * @return 返回值为redis中键值为key的value的Set集合
     */
    public static Set<Object> sGetMembers(String key) {
        return redisTemplate.opsForSet().members(key);
    }

    /**
     * 将给定分数的指定成员添加到键中存储的排序集合中
     *
     * @param key   键
     * @param value 值
     * @param score 分数
     * @return
     */
    public static Boolean zAdd(String key, Object value, double score) {
        return redisTemplate.opsForZSet().add(key, value, score);
    }

    /**
     * 返回指定排序集中给定成员的分数
     *
     * @param key
     * @param value
     * @return
     */
    public static Double zScore(String key, Object value) {
        return redisTemplate.opsForZSet().score(key, value);
    }

    /**
     * 删除指定的键
     *
     * @param key
     * @return
     */
    public static Boolean delete(String key) {
        return redisTemplate.delete(key);
    }

    /**
     * 删除多个键
     *
     * @param keys
     * @return
     */
    public static Long delete(Collection<String> keys) {
        return redisTemplate.delete(keys);
    }

    /**
     * @param key   键
     * @param value 值
     * @return
     */
    public static Object setNx(String key, String value) {
        return redisTemplate.opsForValue().setIfAbsent(key, value);
    }


    /**
     * 指定key的剩余过期描述
     *
     * @param key
     * @return
     */
    public static Long getExpireSec(String key) {
        return redisTemplate.getExpire(key, TimeUnit.SECONDS);
    }

    public static Long lPush(String key, Object value) {
        return redisTemplate.opsForList().leftPush(key, value);
    }

    public static Long rPush(String key, Object value) {
        return redisTemplate.opsForList().rightPush(key, value);
    }

    public static Object lPop(String key,int seconds) {
        return redisTemplate.opsForList().leftPop(key,seconds,TimeUnit.SECONDS);
    }

    public static Object rPop(String key,int seconds) {
        return redisTemplate.opsForList().rightPop(key,seconds,TimeUnit.SECONDS);
    }


}
