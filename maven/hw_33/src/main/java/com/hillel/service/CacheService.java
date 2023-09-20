package com.hillel.service;

/**
 * Interface for working with the cache.
 */
public interface CacheService {

    /**
     * Places an object in the cache by the specified key.
     *
     * @param cache cache where the object should be placed.
     * @param key   the key by which to place the object.
     * @param o     object to be placed in the cache.
     * @return true, if the object was successfully placed in the cache, otherwise false.
     */
    boolean put(String cache, String key, Object o);

    /**
     * Retrieves an object from the cache by the specified key.
     *
     * @param cache cache from which you want to retrieve the object.
     * @param key   the key by which you want to retrieve the object.
     * @return object from the cache or null if the object is not found.
     */
    Object get(String cache, String key);

    /**
     * Checks if an object for the specified key exists in the cache.
     *
     * @param cache cache in which the check is performed.
     * @param key   key for which the check is performed.
     * @return true, if the object exists in the cache, otherwise false.
     */
    boolean contains(String cache, String key);

    /**
     * Clears all caches.
     */
    void clear();

    /**
     * Clears the specified cache.
     *
     * @param cache cache that needs to be cleared.
     */
    void clear(String cache);

    /**
     * Checks if the specified cache exists.
     *
     * @param cache cache that needs to be checked.
     * @return true, if the cache exists, otherwise false.
     */
    boolean isCacheExist(String cache);
}

