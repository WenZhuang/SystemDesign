package main.user;

import java.util.*;

/**
 * @author wenzhuang
 * @date 2020/1/28 10:51 PM
 */
public class FriendshipService {

    private Map<Integer, Set<Integer>> followerMap = new HashMap<>();
    private Map<Integer, Set<Integer>> followingMap = new HashMap<>();

    public FriendshipService() {
        // do intialization if necessary
    }

    /*
     * @param user_id: An integer
     * @return: all followers and sort by user_id
     */
    public List<Integer> getFollowers(int user_id) {
        // write your code here
        Set<Integer> followers = followerMap.get(user_id);
        return followers == null ? new ArrayList<>() : new ArrayList<>(followers);
    }

    /*
     * @param user_id: An integer
     * @return: all followings and sort by user_id
     */
    public List<Integer> getFollowings(int user_id) {
        // write your code here
        Set<Integer> followings = followingMap.get(user_id);
        return followings == null ? new ArrayList<>() : new ArrayList<>(followings);
    }

    /*
     * @param from_user_id: An integer
     * @param to_user_id: An integer
     * @return: nothing
     */
    public void follow(int to_user_id, int from_user_id) {
        // write your code here
        if (!followingMap.containsKey(from_user_id)){
            followingMap.put(from_user_id, new TreeSet<>());
        }
        followingMap.get(from_user_id).add(to_user_id);
        if (!followerMap.containsKey(to_user_id)){
            followerMap.put(to_user_id, new TreeSet<>());
        }
        followerMap.get(to_user_id).add(from_user_id);

    }

    /*
     * @param from_user_id: An integer
     * @param to_user_id: An integer
     * @return: nothing
     */
    public void unfollow(int to_user_id, int from_user_id) {
        // write your code here
        Set<Integer> followings = followingMap.get(from_user_id);
        if (followings != null && !followings.isEmpty()){
            followings.remove(to_user_id);
        }
        Set<Integer> followers = followerMap.get(to_user_id);
        if (followers != null && !followers.isEmpty()){
            followers.remove(from_user_id);
        }
    }
}