package test.storage;

import main.storage.cache.Memcache;

/**
 * @author wenzhuang
 * @date 2020/1/29 12:06 AM
 */
public class MemcacheTest {

    public static void main(String[] args){
        Memcache memcache = new Memcache();
        memcache.set(2, 1, 1, 2);
        System.out.println(memcache.get(3, 1));
    }
}
