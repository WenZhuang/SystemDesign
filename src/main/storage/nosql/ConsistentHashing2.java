package main.storage.nosql;

import java.util.*;

/**
 * @author wenzhuang
 * @date 2020/1/29 8:55 PM
 */
public class ConsistentHashing2 {
    private int n;
    private int k;
    private TreeMap<Integer, Integer> circle = new TreeMap<>();

    private Random random = new Random();
    /*
     * @param n: a positive integer
     * @param k: a positive integer
     * @return: a Solution object
     */
    public static ConsistentHashing2 create(int n, int k) {
        // Write your code here
        return new ConsistentHashing2(n, k);
    }

    private ConsistentHashing2(int n, int k){
        this.n = n;
        this.k = k;
    }

    /*
     * @param machine_id: An integer
     * @return: a list of shard ids
     */
    public List<Integer> addMachine(int machine_id) {
        // write your code here
        List<Integer> shardIds = new ArrayList<>();
        for (int  i = 0; i < k; i++){
            int shardId = random.nextInt(n);
            while (circle.containsKey(shardId)){
                shardId = random.nextInt(n);
            }
            circle.put(shardId, machine_id);
            shardIds.add(shardId);
        }
        return shardIds;
    }

    /*
     * @param hashcode: An integer
     * @return: A machine id
     */
    public int getMachineIdByHashCode(int hashcode) {
        // write your code here
        Map.Entry<Integer, Integer> entry = circle.ceilingEntry(hashcode);
        if (entry == null){
            entry = circle.firstEntry();
        }
        return entry.getValue();
    }
}
