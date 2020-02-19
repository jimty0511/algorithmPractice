package practice.lcdesign;

import java.util.*;

// 560. Friendship Service
// Chapter 2
public class FriendshipService {

    private Map<Integer, Set<Integer>> followers, followings;

    public FriendshipService() {
        // do intialization if necessary
        followers = new HashMap<>();
        followings = new HashMap<>();
    }

    /*
     * @param user_id: An integer
     * @return: all followers and sort by user_id
     */
    public List<Integer> getFollowers(int user_id) {
        // write your code here
        if (!followers.containsKey(user_id))
            return new ArrayList<>();
        return new ArrayList<>(followers.get(user_id));
    }

    /*
     * @param user_id: An integer
     * @return: all followings and sort by user_id
     */
    public List<Integer> getFollowings(int user_id) {
        // write your code here
        if (!followings.containsKey(user_id))
            return new ArrayList<>();
        return new ArrayList<>(followings.get(user_id));
    }

    /*
     * @param from_user_id: An integer
     * @param to_user_id: An integer
     * @return: nothing
     */
    public void follow(int to_user_id, int from_user_id) {
        // write your code here
        followers.putIfAbsent(to_user_id, new TreeSet<>());
        followers.get(to_user_id).add(from_user_id);
        followings.putIfAbsent(from_user_id, new TreeSet<>());
        followings.get(from_user_id).add(to_user_id);
    }

    /*
     * @param from_user_id: An integer
     * @param to_user_id: An integer
     * @return: nothing
     */
    public void unfollow(int to_user_id, int from_user_id) {
        // write your code here
        if (followers.containsKey(to_user_id))
            followers.get(to_user_id).remove(from_user_id);
        if (followings.containsKey(from_user_id))
            followings.get(from_user_id).remove(to_user_id);
    }
}
