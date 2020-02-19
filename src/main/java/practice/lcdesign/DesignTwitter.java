package practice.lcdesign;

import java.util.*;

// 501. Design Twitter
// Chapter 1
public class DesignTwitter {
    public static class Tweet {
        public int id;
        public int user_id;
        public String text;

        public static Tweet create(int user_id, String tweet_text, int id) {
            // This will create a new tweet object,
            // and auto fill id
            Tweet tweet = new Tweet();
            tweet.user_id = user_id;
            tweet.text = tweet_text;
            tweet.id = id;
            return tweet;
        }
    }

    Map<Integer, List<Tweet>> tweetMap;
    Map<Integer, Set<Integer>> followMap;
    int id = 1;

    public DesignTwitter() {
        // do intialization if necessary
        tweetMap = new HashMap<>();
        followMap = new HashMap<>();
    }

    /*
     * @param user_id: An integer
     * @param tweet_text: a string
     * @return: a tweet
     */
    public Tweet postTweet(int user_id, String tweet_text) {
        // write your code here
        Tweet tweet = Tweet.create(user_id, tweet_text, this.id++);
        tweetMap.putIfAbsent(user_id, new ArrayList<>());
        List<Tweet> list = tweetMap.get(user_id);
        list.add(0, tweet);
        if (list.size() > 10)
            list.remove(list.size() - 1);
        if (!followMap.containsKey(user_id))
            follow(user_id, user_id);
        return tweet;
    }

    /*
     * @param user_id: An integer
     * @return: a list of 10 new feeds recently and sort by timeline
     */
    public List<Tweet> getNewsFeed(int user_id) {
        // write your code here
        if (!followMap.containsKey(user_id))
            return new ArrayList<>();
        Set<Integer> set = followMap.get(user_id);
        PriorityQueue<Tweet> pq = new PriorityQueue<>((a, b) -> a.id - b.id);
        for (Integer id : set) {
            List<Tweet> list = tweetMap.get(id);
            if (list == null)
                continue;
            for (Tweet t : list) {
                pq.offer(t);
                if (pq.size() > 10)
                    pq.poll();
            }
        }
        List<Tweet> res = new ArrayList<>();
        while (!pq.isEmpty())
            res.add(0, pq.poll());
        return res;
    }

    /*
     * @param user_id: An integer
     * @return: a list of 10 new posts recently and sort by timeline
     */
    public List<Tweet> getTimeline(int user_id) {
        // write your code here
        if (!tweetMap.containsKey(user_id))
            return new ArrayList<>();
        return tweetMap.get(user_id);
    }

    /*
     * @param from_user_id: An integer
     * @param to_user_id: An integer
     * @return: nothing
     */
    public void follow(int from_user_id, int to_user_id) {
        // write your code here
        followMap.putIfAbsent(from_user_id, new HashSet<>());
        followMap.get(from_user_id).add(to_user_id);
        followMap.get(from_user_id).add(from_user_id);
    }

    /*
     * @param from_user_id: An integer
     * @param to_user_id: An integer
     * @return: nothing
     */
    public void unfollow(int from_user_id, int to_user_id) {
        // write your code here
        if (!followMap.containsKey(from_user_id))
            return;
        followMap.get(from_user_id).remove(to_user_id);
    }
}
