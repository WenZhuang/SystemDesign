package main.chat;

import java.util.*;

/**
 * @author wenzhuang
 * @date 2020/2/2 2:42 AM
 */
public class PubSubPattern {

    Map<String, Set<Integer>> channelUsers = new HashMap<>();

    public PubSubPattern(){
        // Write your code here
    }

    /**
     * @param channel: the channel's name
     * @param user_id: the user who subscribes the channel
     * @return: nothing
     */
    public void subscribe(String channel, int user_id) {
        // Write your code here
        if (!channelUsers.containsKey(channel)) {
            channelUsers.put(channel, new HashSet<>());
        }
        channelUsers.get(channel).add(user_id);
    }

    /**
     * @param channel: the channel's name
     * @param user_id: the user who unsubscribes the channel
     * @return: nothing
     */
    public void unsubscribe(String channel, int user_id) {
        // Write your code here
        if (channelUsers.containsKey(channel)){
            channelUsers.get(channel).remove(user_id);
        }
    }

    /**
     * @param channel: the channel's name
     * @param message: the message need to be delivered to the channel's subscribers
     * @return: nothing
     */
    public void publish(String channel, String message) {
        // Write your code here
        Set<Integer> users = channelUsers.get(channel);
        if (users == null){
            return;
        }
        for (Integer user : users) {
            PushNotification.notify(user, message);
        }
    }
}


class PushNotification {
    public static void notify(int user_id, String the_message){

    }
};

