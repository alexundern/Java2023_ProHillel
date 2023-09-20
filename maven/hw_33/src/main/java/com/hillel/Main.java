package com.hillel;

import com.hillel.service.CacheImpl;
import com.hillel.service.CacheService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Timestamp;

public class Main {

    public static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

        logger.info("Start Cache! " + new Timestamp(System.currentTimeMillis()));

        CacheService cacheServ = new CacheImpl();

        String[] cacheNames = {"nameCache1", "nameCache2", "nameCache3"};
        String[] keys = {"keyCache1", "keyCache2", "keyCache1", "keyCache2"};
        Object[] values = {"Object1_nameCache1", "Object1_nameCache2", "Object1_nameCache3", "Object1_nameCache4"};

        for (int i = 0; i < cacheNames.length; i++) {
            String cacheName = cacheNames[i];
            String key = keys[i];
            Object value = values[i];

            if (!cacheServ.isCacheExist(cacheName)) {
                logger.info("Creating a new cache: " + cacheName);
            }

            cacheServ.put(cacheName, key, value);
        }

        String cache3 = "nameCache3";
        String keyCache1 = "keyCache1";

        Object cachedValue1 = cacheServ.get(cache3, keyCache1);

        if (cachedValue1 != null) {
            System.out.println("Value retrieved from cache: "
                    + cachedValue1 + " in cache: " + cache3 + " with key: " + keyCache1);
        } else {
            System.out.println("Value not found in cache for key: " + keyCache1);
        }

        String cache2 = "nameCache2";
        String key2 = "keyCache2";

        Object cachedValue2 = cacheServ.get(cache2, key2);

        if (cachedValue2 != null) {
            System.out.println("Value retrieved from cache: "
                    + cachedValue2 + " in cache: " + cache2 + " with key: " + key2);
        } else {
            System.out.println("Value not found in cache for key: " + key2);
        }

        logger.info("End of program! " + new Timestamp(System.currentTimeMillis()));
    }

}