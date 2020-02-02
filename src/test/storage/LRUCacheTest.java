package test.storage;

import main.storage.cache.LRUCache;

/**
 * @author wenzhuang
 * @date 2020/2/2 4:55 PM
 */
public class LRUCacheTest {

    public static void main(String[] args){
        LRUCache lruCache = new LRUCache(2);
        lruCache.set(2, 1);
        lruCache.set(1, 1);
        lruCache.get(2);
        lruCache.set(4, 1);
        lruCache.get(1);
        lruCache.get(2);
    }
}
