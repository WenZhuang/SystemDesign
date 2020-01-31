package main.gfs;

import java.util.*;

/**
 * @author wenzhuang
 * @date 2020/1/31 10:12 PM
 */
public class HeartBeat {

    private Map<String, Integer> slaveIpAliveTime= new HashMap<>();
    private int k;

    public HeartBeat() {
        // do intialization if necessary
    }

    /*
     * @param slaves_ip_list: a list of slaves'ip addresses
     * @param k: An integer
     * @return: nothing
     */
    public void initialize(List<String> slaves_ip_list, int k) {
        // write your code here
        for (String slave_ip : slaves_ip_list) {
            slaveIpAliveTime.put(slave_ip, 0);
        }
        this.k = k;
    }

    /*
     * @param timestamp: current timestamp in seconds
     * @param slave_ip: the ip address of the slave server
     * @return: nothing
     */
    public void ping(int timestamp, String slave_ip) {
        // write your code here
        if (!slaveIpAliveTime.containsKey(slave_ip)){
            return;
        }
        slaveIpAliveTime.put(slave_ip, timestamp);
    }

    /*
     * @param timestamp: current timestamp in seconds
     * @return: a list of slaves'ip addresses that died
     */
    public List<String> getDiedSlaves(int timestamp) {
        // write your code here
        List<String> diedSlaves = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : slaveIpAliveTime.entrySet()){
            if (entry.getValue() + 2 * k <= timestamp){
                diedSlaves.add(entry.getKey());
            }
        }
        return diedSlaves;
    }
}
