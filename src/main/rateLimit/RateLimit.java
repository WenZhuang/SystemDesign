package main.rateLimit;

import java.util.*;

/**
 * @author wenzhuang
 * @date 2020/2/1 5:15 PM
 */
public class RateLimit {
    Map<String, List<Integer>> hitRecords = new HashMap<>();

    /*
     * @param timestamp: the current timestamp
     * @param event: the string to distinct different event
     * @param rate: the format is [integer]/[s/m/h/d]
     * @param increment: whether we should increase the counter
     * @return: true or false to indicate the event is limited or not
     */
    public boolean isRatelimited(int timestamp, String event, String rate, boolean increment) {
        // write your code here
        boolean isLimit = isLimit(timestamp, event, rate);
        if (!isLimit && increment){
            if (!hitRecords.containsKey(event)){
                hitRecords.put(event, new ArrayList<>());
            }
            hitRecords.get(event).add(timestamp);
        }
        return isLimit;
    }

    private boolean isLimit(int timestamp, String event, String rate){
        List<Integer> times = hitRecords.get(event);
        if (times == null){
            return false;
        }
        String[] rateStr = rate.split("/");
        int limit = Integer.parseInt(rateStr[0]);
        String rateType = rateStr[1];

        int stime = timestamp;
        if ("s".equals(rateType)){
            stime = timestamp;
        } else if ("m".equals(rateType)){
            stime = timestamp - 59;
        } else if ("h".equals(rateType)){
            stime = timestamp - 3599;
        } else {
            stime = timestamp - 86399;
        }
        int count = times.size() - binarySearch(times, stime);
        return count >= limit;
    }

    private int binarySearch(List<Integer> times, int stime){
        int low = 0, high = times.size() - 1;
        while (low <= high){
            int mid = ((high - low) >> 1) + low;
            if (times.get(mid) >= stime){
                if (mid == 0 || times.get(mid - 1) < stime){
                    return mid;
                } else {
                    high = mid - 1;
                }
            } else {
                low = mid + 1;
            }
        }
        return times.size();
    }
}
