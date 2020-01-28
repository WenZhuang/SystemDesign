package test.user;

import main.user.FriendshipService;

/**
 * @author wenzhuang
 * @date 2020/1/28 10:52 PM
 */
public class FriendshipServiceTest {
    public static void main(String[] args){
        FriendshipService friendshipService = new FriendshipService();
        friendshipService.follow(1, 3);
        friendshipService.follow(1, 3);
        friendshipService.getFollowers(1);
        friendshipService.getFollowings(3);
        friendshipService.follow(2, 3);
        friendshipService.getFollowings(3);
        friendshipService.unfollow(1, 3);
        friendshipService.unfollow(2, 3);
        friendshipService.unfollow(2, 3);
        friendshipService.getFollowings(1);
        friendshipService.getFollowings(2);
        friendshipService.getFollowings(3);
        friendshipService.follow(4, 1);
        friendshipService.follow(4, 2);
        friendshipService.follow(4, 3);
        friendshipService.getFollowers(1);
        friendshipService.getFollowers(2);
        friendshipService.getFollowers(3);
        friendshipService.getFollowers(4);
    }
}
