package main.storage.nosql;

/**
 * @author wenzhuang
 * @date 2020/2/2 8:30 PM
 */
public class HashFunction {
    /**
     * @param key: A string you should hash
     * @param HASH_SIZE: An integer
     * @return: An integer
     */
    public int hashCode(char[] key, int HASH_SIZE) {
        // write your code here
        long hash = 0;
        for (int i = 0; i < key.length; i++){
            hash = ((hash * 33) % HASH_SIZE + key[i]) % HASH_SIZE;
        }
        return (int) hash;
    }
}
