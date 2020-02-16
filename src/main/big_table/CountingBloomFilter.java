package main.big_table;

import java.util.*;

/**
 * @author wenzhuang
 * @date 2020/2/16 5:03 PM
 */
public class CountingBloomFilter {
    private final int capacity = 1000000;

    private int[] count = count = new int[capacity];

    private List<HashFunction> hashFunctions = new ArrayList<>();

    /*
     * @param k: An integer
     */public CountingBloomFilter(int k) {
        // do intialization if necessary
        for (int i = 0; i < k; i++){
            hashFunctions.add(new HashFunction(2 * i + 3, capacity));
        }
    }

    /*
     * @param word: A string
     * @return: nothing
     */
    public void add(String word) {
        // write your code here
        for (HashFunction hashFunction : hashFunctions){
            int hash = hashFunction.hash(word);
            count[hash]++;
        }
    }

    /*
     * @param word: A string
     * @return: nothing
     */
    public void remove(String word) {
        // write your code here
        for (HashFunction hashFunction : hashFunctions){
            int hash = hashFunction.hash(word);
            count[hash]--;
        }
    }

    /*
     * @param word: A string
     * @return: True if contains word
     */
    public boolean contains(String word) {
        // write your code here
        for (HashFunction hashFunction : hashFunctions){
            if (count[hashFunction.hash(word)] <= 0){
                return false;
            }
        }
        return true;
    }

    class HashFunction{

        private int seed;
        private int capacity;

        public HashFunction(int seed, int capacity){
            this.seed = seed;
            this.capacity = capacity;
        }

        public int hash(String s){
            int hash = 0;
            for (int i = 0; i < s.length(); i++){
                hash = (hash * seed +   s.charAt(i)) % capacity;
            }
            return hash;
        }
    }
}
