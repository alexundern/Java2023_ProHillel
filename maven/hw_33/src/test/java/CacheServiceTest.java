import com.hillel.exception.CacheNotFoundException;
import com.hillel.exception.KeyNotFoundException;
import com.hillel.service.CacheImpl;
import com.hillel.service.CacheService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CacheServiceTest {
    private CacheService cacheService;

    @BeforeEach
    public void setUp() {
        cacheService = new CacheImpl();
    }

    @Test
    @DisplayName("Put and Get")
    public void testPutAndGet() {
        String cacheName = "testCache";
        String key = "testKey";
        Object value = "testValue";

        assertTrue(cacheService.put(cacheName, key, value));

        Object retrievedValue = cacheService.get(cacheName, key);

        assertEquals(value, retrievedValue);
    }

    @Test
    @DisplayName("Put and Get With Missing Cache")
    public void testPutAndGetWithMissingCache() {
        String cacheName = "nonExistentCache";
        String key = "testKey";
        Object value = "testValue";

        assertFalse(cacheService.contains(cacheName, key));

        assertThrows(CacheNotFoundException.class, () -> cacheService.get(cacheName, key));
    }

    @Test
    @DisplayName("Put and Contains")
    public void testPutAndContains() {
        String cacheName = "testCache";
        String key = "testKey";
        Object value = "testValue";

        assertTrue(cacheService.put(cacheName, key, value));

        assertTrue(cacheService.contains(cacheName, key));
    }

    @Test
    @DisplayName("Clear")
    public void testClear() {
        String cacheName = "testCache";
        String key = "testKey";
        Object value = "testValue";

        assertTrue(cacheService.put(cacheName, key, value));

        cacheService.clear();

        assertFalse(cacheService.contains(cacheName, key));
    }

    @Test
    @DisplayName("Get Non Existent Cache")
    public void testGetNonExistentCache() {
        String cacheName = "nonExistentCache";
        String key = "testKey";

        assertThrows(CacheNotFoundException.class, () -> cacheService.get(cacheName, key));
    }

    @Test
    @DisplayName("Get Non Existent Key")
    public void testGetNonExistentKey() {
        String cacheName = "testCache";
        String key = "nonExistentKey";

        assertThrows(CacheNotFoundException.class, () -> cacheService.get(cacheName, key));
    }

    @Test
    @DisplayName("Is Cache Exist")
    public void testIsCacheExist() {
        String cacheName = "testCache";

        assertTrue(cacheService.put(cacheName, "key1", "value1"));

        assertTrue(cacheService.isCacheExist(cacheName));
    }

    @Test
    @DisplayName("Is Cache Not Exist")
    public void testIsCacheNotExist() {
        String cacheName = "nonExistentCache";

        assertFalse(cacheService.isCacheExist(cacheName));
    }
}