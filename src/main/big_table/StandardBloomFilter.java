package main.big_table;

import main.storage.nosql.HashFunction;

import java.util.*;

/**
 * @author wenzhuang
 * @date 2020/2/16 5:01 PM
 */
public class StandardBloomFilter {

    private final int capacity = 1000000;

    private BitSet bitSet = new BitSet(capacity);

    private List<HashFunction> hashFunctions = new ArrayList<>();
    /*
     * @param k: An integer
     */public StandardBloomFilter(int k) {
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
            bitSet.set(hash);
        }
    }

    /*
     * @param word: A string
     * @return: True if contains word
     */
    public boolean contains(String word) {
        // write your code here
        for (HashFunction hashFunction : hashFunctions){
            if (!bitSet.get(hashFunction.hash(word))){
                return false;
            }
        }
        return true;
    }
}
