package com.hillel.service;

import com.hillel.exception.CacheNotFoundException;
import com.hillel.exception.KeyNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Implementation of the CacheService interface.
 */
public class CacheImpl implements CacheService {
    private static final Logger logger = LoggerFactory.getLogger(CacheImpl.class);
    private final Map<String, Map<String, Object>> cacheMain;

    public CacheImpl() {
        this.cacheMain = new HashMap<>();
    }

    @Override
    public boolean put(String cache, String key, Object o) {
        cacheMain.computeIfAbsent(cache, k -> {
            logger.info("A new cache has been created: " + cache);
            return new HashMap<>();
        }).put(key, o);
        logger.info("Cached: " + cache + "; key: " + key + "; value: " + o);
        return true;
    }

    //1
//    @Override
//    public Object get(String cache, String key) {
//        Map<String, Object> innerCache = cacheMain.get(cache);
//        if (innerCache == null) {
//            logger.error("Cache: " + cache + " missing!");
//            return null;
//        }
//
//        Object value = innerCache.get(key);
//        if (value == null) {
//            logger.error("Кey: " + key + " missing!");
//            return null;
//        }
//
//        logger.info("Retrieved from cache: " + cache + "; key: " + key + "; value: " + value);
//        return value;
//    }


//    //2
//    @Override
//    public Object get(String cache, String key) {
//        Map<String, Object> innerCache = cacheMain.get(cache);
//        if (innerCache == null) {
//            logger.error("Cache: " + cache + " missing!");
//            throw new CacheNotFoundException("Cache not found: " + cache);
//        }
//
//        Object value = innerCache.get(key);
//        if (value == null) {
//            logger.error("Key: " + key + " missing!");
//            throw new KeyNotFoundException("Key not found: " + key);
//        }
//
//        logger.info("Retrieved from cache: " + cache + "; key: " + key + "; value: " + value);
//        return value;
//    }

    //3
//    @Override
//    public Object get(String cache, String key) {
//        Map<String, Object> innerCache = cacheMain.get(cache);
//        if (innerCache == null) {
//            logger.error("Cache: " + cache + " missing!");
//            throw new CacheNotFoundException("Cache not found: " + cache);
//        }
//
//        Object value = innerCache.get(key);
//        if (value == null) {
//            logger.error("Key: " + key + " missing!");
//            throw new KeyNotFoundException("Key not found: " + key);
//        }
//
//        logger.info("Retrieved from cache: " + cache + "; key: " + key + "; value: " + value);
//        return value;
//    }

    @Override
    public Object get(String cache, String key) {
        Map<String, Object> innerCache = cacheMain.get(cache);
        if (innerCache == null) {
            logger.error("Cache: " + cache + " missing!");
            throw new CacheNotFoundException("Cache not found: " + cache);
        }

        Object value = innerCache.get(key);
        if (value == null) {
            logger.error("Key: " + key + " missing!");
            throw new KeyNotFoundException("Key not found: " + key);
        }

        logger.info("Retrieved from cache: " + cache + "; key: " + key + "; value: " + value);
        return value;
    }

    @Override
    public boolean contains(String cache, String key) {
        return cacheMain.containsKey(cache) && cacheMain.get(cache).containsKey(key);
    }

    @Override
    public void clear() {
        cacheMain.clear();
        logger.info("All caches have been cleared.");
    }

    @Override
    public void clear(String cache) {
        if (!cacheMain.containsKey(cache)) {
            throw new CacheNotFoundException("Cache not found: " + cache);
        }

        cacheMain.get(cache).clear();
        logger.info("Cache cleared " + cache);
    }

    @Override
    public boolean isCacheExist(String cache) {
        if (cacheMain.containsKey(cache)) {
            logger.info("Cache: " + cache + " exists!");
            return true;
        } else {
            logger.info("Cache: " + cache + " missing!");
            return false;
        }
    }
}