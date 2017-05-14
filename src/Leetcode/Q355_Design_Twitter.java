package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q355_Design_Twitter {
    List<Integer> tweetList;
    List<Integer> userList;
    Map<Integer, Set<Integer>> followMap;

    /**
     * Initialize your data structure here.
     */
    public Q355_Design_Twitter() {
        tweetList = new ArrayList<Integer>();
        userList = new ArrayList<Integer>();
        followMap = new HashMap<Integer, Set<Integer>>();
    }

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {
        //self add
        if (followMap.get(userId) == null) {
            Set<Integer> set = new HashSet<Integer>();
            set.add(userId);
            followMap.put(userId, set);
        }
        tweetList.add(tweetId);
        userList.add(userId);
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> ans = new ArrayList<Integer>();
        if (followMap.get(userId) == null) {
            return ans;
        }
        Set<Integer> follow = followMap.get(userId);
        for (int i=tweetList.size()-1; i >= 0 ; i--) {
            int id = userList.get(i);
            int tweet = tweetList.get(i);
            if (follow.contains(id)) {
                ans.add(tweet);
                if (ans.size() == 10)
                    break;
            }
        }
        return ans;
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {
        if (!followMap.containsKey(followerId)) {
            Set<Integer> set = new HashSet<Integer>();
            set.add(followerId);
            followMap.put(followerId, set);
        }
        followMap.get(followerId).add(followeeId);
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        if (followerId != followeeId && followMap.containsKey(followerId) && followMap.get(followerId).contains(followeeId)) {
            followMap.get(followerId).remove(followeeId);
        }
    }
}
