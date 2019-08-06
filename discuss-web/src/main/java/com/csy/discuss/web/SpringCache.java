package com.csy.discuss.web;

import lombok.Getter;
import lombok.Setter;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by yaojiafeng on 2017/4/18 下午3:22.
 */
public class SpringCache {

    @Getter
    @Setter
    public static class Cache {

        private String id;

        public Cache(String id) {
            this.id = id;
        }
    }

    /**
     * 加缓存
     * <p>
     * value=data 代表1级key 从EhCacheCacheManager获取Cache
     * key=#id 代表2级key 从Cache获取
     *
     * @param cache
     * @return
     */
    @Cacheable(value = "data", key = "#id")
    public String getData(Cache cache) {
        return cache.getId() + ":" + System.currentTimeMillis();
    }

    /**
     * 清缓存
     *
     * @param cache
     */
    @CacheEvict(value = "data", key = "#id")
    public void setData(Cache cache) {
    }

    public static void main(String[] args) {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("/spring/spring-cache.xml");
        SpringCache springCache = (SpringCache) classPathXmlApplicationContext.getBean("springCache");
        String data = springCache.getData(new Cache("1"));
        System.out.println(data);
        data = springCache.getData(new Cache("1"));
        System.out.println(data);
        springCache.setData(new Cache("1"));
        String data1 = springCache.getData(new Cache("1"));
        System.out.println(data1);
        String data2 = springCache.getData(new Cache("2"));
        System.out.println(data2);
    }
}
