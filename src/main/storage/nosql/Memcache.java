package main.storage.nosql;

import java.util.*;

/**
 * @author wenzhuang
 * @date 2020/1/28 11:50 PM
 */
public class Memcache {

    private Map<Integer, Entry> cache = new HashMap<>();

    private final int NOT_EXIST = 2147483647;

    public Memcache() {
        // do intialization if necessary
    }

    /*
     * @param curtTime: An integer
     * @param key: An integer
     * @return: An integer
     */
    public int get(int curtTime, int key) {
        // write your code here
        if (!cache.containsKey(key)){
            return NOT_EXIST;
        }
        Entry entry = cache.get(key);
        if (entry.ttl > 0 && entry.cTime + entry.ttl <= curtTime){
            delete(curtTime, key);
            return NOT_EXIST;
        }
        return cache.get(key).val;
    }

    /*
     * @param curtTime: An integer
     * @param key: An integer
     * @param value: An integer
     * @param ttl: An integer
     * @return: nothing
     */
    public void set(int curtTime, int key, int value, int ttl) {
        // write your code here
        Entry entry = new Entry(value, curtTime, ttl);
        cache.put(key, entry);
    }

    /*
     * @param curtTime: An integer
     * @param key: An integer
     * @return: nothing
     */
    public void delete(int curtTime, int key) {
        // write your code here
        if (cache.containsKey(key)){
            cache.remove(key);
        }
    }

    /*
     * @param curtTime: An integer
     * @param key: An integer
     * @param delta: An integer
     * @return: An integer
     */
    public int incr(int curtTime, int key, int delta) {
        // write your code here
        if (get(curtTime, key) == NOT_EXIST){
            return NOT_EXIST;
        }
        Entry entry = cache.get(key);
        entry.val = entry.val + delta;
        return entry.val;
    }

    /*
     * @param curtTime: An integer
     * @param key: An integer
     * @param delta: An integer
     * @return: An integer
     */
    public int decr(int curtTime, int key, int delta) {
        // write your code here
        if (get(curtTime, key) == NOT_EXIST){
            return NOT_EXIST;
        }
        Entry entry = cache.get(key);
        entry.val = entry.val - delta;
        return entry.val;
    }

    class Entry{
        public int val;
        public int cTime;
        public int ttl;

        public Entry(int value, int cTime, int ttl){
            this.val = val;
            this.cTime = cTime;
            this.ttl = ttl;
        }
    }
}

