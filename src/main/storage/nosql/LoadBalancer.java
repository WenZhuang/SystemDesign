package main.storage.nosql;

import java.util.*;

/**
 * @author wenzhuang
 * @date 2020/1/29 8:01 PM
 */
public class LoadBalancer {

    List<Integer> serverList = new ArrayList<>();
    Random random = new Random();

    public LoadBalancer() {
        // do intialization if necessary
    }

    /*
     * @param server_id: add a new server to the cluster
     * @return: nothing
     */
    public void add(int server_id) {
        // write your code here
        serverList.add(server_id);
    }

    /*
     * @param server_id: server_id remove a bad server from the cluster
     * @return: nothing
     */
    public void remove(int server_id) {
        // write your code here
        serverList.remove(new Integer(server_id));
    }

    /*
     * @return: pick a server in the cluster randomly with equal probability
     */
    public int pick() {
        // write your code here
        return serverList.get(random.nextInt(serverList.size()));

    }
}
