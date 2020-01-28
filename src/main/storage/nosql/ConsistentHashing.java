package main.storage.nosql;

import java.util.*;

/**
 * @author wenzhuang
 * @date 2020/1/29 1:41 AM
 */
public class ConsistentHashing {
    List<Shard> shards = new ArrayList<>();

    /*
     * @param n: a positive integer
     * @return: n x 3 matrix
     */
    public List<List<Integer>> consistentHashing(int n) {
        // write your code here
        for (int i = 1; i <= n; i++){
            scale(i);
        }
        List<List<Integer>> res = new ArrayList<>();
        for (Shard shard : shards){
            res.add(Arrays.asList(shard.low, shard.high, shard.id));
        }
        return res;
    }

    private void scale(int n){
        Shard maxShard = null;
        int maxInterval = 0;
        for (Shard shard : shards){
            if (shard.high - shard.low + 1 > maxInterval){
                maxShard = shard;
                maxInterval = shard.high - shard.low + 1;
            }
        }
        if (maxShard == null){
            Shard shard = new Shard(1, 0, 359);
            shards.add(shard);
        } else {
            maxShard.high = maxShard.low + (maxInterval + 1) / 2 - 1;
            Shard shard = new Shard(n, maxShard.high + 1, maxShard.high + maxInterval / 2);
            shards.add(shard);
        }
    }


    class Shard{
        public int id;
        public int low;
        public int high;

        public Shard(int id, int low, int high){
            this.id = id;
            this.low = low;
            this.high = high;
        }
    }
}
