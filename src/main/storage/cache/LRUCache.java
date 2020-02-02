package main.storage.cache;

import java.util.*;

/**
 * @author wenzhuang
 * @date 2020/2/2 4:54 PM
 */
public class LRUCache {

    private Map<Integer, Entry> cache = new HashMap<>();
    private Entry head;
    private Entry tail;
    private int capacity;

    /*
     * @param capacity: An integer
     */public LRUCache(int capacity) {
        // do intialization if necessary
        this.capacity = capacity;
    }

    /*
     * @param key: An integer
     * @return: An integer
     */
    public int get(int key) {
        // write your code here
        if (!cache.containsKey(key)){
            return -1;
        }
        Entry entry = cache.get(key);
        moveToHead(entry);
        return entry.value;
    }

    /*
     * @param key: An integer
     * @param value: An integer
     * @return: nothing
     */
    public void set(int key, int value) {
        // write your code here
        if (!cache.containsKey(key)){
            if (cache.size() >= capacity){
                cache.remove(tail.key);
                removeTail();
            }
            Entry entry = new Entry(key, value);
            addToHead(entry);
            cache.put(key, entry);
        } else {
            Entry entry = cache.get(key);
            entry.value = value;
            moveToHead(entry);
        }
    }

    private void moveToHead(Entry entry){
        if (entry == head){
            return;
        }
        if (entry == tail){
            Entry pre = tail.pre;
            pre.next = null;
            tail = pre;
        } else {
            entry.pre.next = entry.next;
            entry.next.pre = entry.pre;
        }
        addToHead(entry);
    }

    private void removeTail(){
        if (head == tail){
            head = null;
            tail = null;
        } else {
            Entry pre = tail.pre;
            pre.next = null;
            tail = pre;
        }
    }

    private void addToHead(Entry entry){
        if (head == null){
            head = entry;
            tail = entry;
        } else{
            head.pre = entry;
            entry.next = head;
            head = entry;
        }
    }

    class Entry{
        public int key;
        public int value;
        public Entry pre;
        public Entry next;
        public Entry(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
}