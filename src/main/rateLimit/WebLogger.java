package main.rateLimit;

import java.util.*;

/**
 * @author wenzhuang
 * @date 2020/2/1 5:32 PM
 */
public class WebLogger {

    Queue<Integer> queue = new LinkedList<>();

    public WebLogger() {
        // do intialization if necessary
    }

    /*
     * @param timestamp: An integer
     * @return: nothing
     */
    public void hit(int timestamp) {
        // write your code here
        queue.offer(timestamp);
    }

    /*
     * @param timestamp: An integer
     * @return: An integer
     */
    public int get_hit_count_in_last_5_minutes(int timestamp) {
        // write your code here
        while (!queue.isEmpty() && queue.peek() + 300 <= timestamp){
            queue.poll();
        }
        return queue.size();
    }
}
