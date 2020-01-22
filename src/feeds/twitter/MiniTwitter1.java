package feeds.twitter;

import java.util.*;

/**
 * 使用pull模式实现twitter
 * @author wenzhuang
 * @date 2020/1/23 1:59 AM
 */

public class MiniTwitter1 {
    List<Tweet> tweetList = new ArrayList<>();
    Map<Integer, Set<Integer>> followShip = new HashMap<>();

    public MiniTwitter1() {
        // do intialization if necessary
        this.tweetList = new ArrayList<>();
        this.followShip = new HashMap<>();
    }

    public Tweet postTweet(int user_id, String tweet_text) {
        // write your code here
        Tweet tweet = Tweet.create(user_id, tweet_text);
        tweetList.add(tweet);
        return tweet;
    }

    public List<Tweet> getNewsFeed(int user_id) {
        // write your code here
        List<Tweet> list = new ArrayList();
        Set<Integer> following = followShip.get(user_id);
        for (int i = tweetList.size() - 1; i >= 0; i--) {
            Tweet tweet = tweetList.get(i);
            if (tweet.user_id == user_id || (following != null && following.contains(tweet.user_id))){
                list.add(tweetList.get(i));
                if (list.size() == 10){
                    break;
                }
            }
        }
        return list;
    }


    public List<Tweet> getTimeline(int user_id) {
        // write your code here
        List<Tweet> list = new ArrayList();
        for (int i = tweetList.size() - 1; i >= 0; i--) {
            if (tweetList.get(i).user_id == user_id){
                list.add(tweetList.get(i));
                if (list.size() == 10){
                    break;
                }
            }
        }
        return list;
    }

    public void follow(int from_user_id, int to_user_id) {
        // write your code here
        if (!followShip.containsKey(from_user_id)){
            followShip.put(from_user_id, new HashSet<>());
        }
        followShip.get(from_user_id).add(to_user_id);
    }

    public void unfollow(int from_user_id, int to_user_id) {
        // write your code here
        Set<Integer> set = followShip.get(from_user_id);
        if (set != null && set.contains(to_user_id)){
            set.remove(to_user_id);
        }
    }
}
