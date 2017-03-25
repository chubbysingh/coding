package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q355_Design_Twitter {
    List<Integer> tweetList;
    List<Integer> userList;
    Map<Integer, Map<Integer,Integer>> followMap;
    /** Initialize your data structure here. */
    public Q355_Design_Twitter() {
        tweetList=new ArrayList<Integer>();
        userList=new ArrayList<Integer>();
        followMap=new HashMap<Integer, Map<Integer,Integer>>();
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if (followMap.get(userId)==null) {
            Map<Integer,Integer> map=new HashMap<Integer,Integer>();
            map.put(userId, 1);
            followMap.put(userId, map);
        }
        tweetList.add(tweetId);
        userList.add(userId);
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> ans=new ArrayList<Integer>();
        if (followMap.get(userId)==null) {
            return ans;
        }
        int i=tweetList.size()-1;
        Set<Integer> follow=followMap.get(userId).keySet();
        while (i>=0&&ans.size()<10) {
            int id=userList.get(i);
            int tweet=tweetList.get(i);
            if (follow.contains(id)) {
                ans.add(tweet);
            }
            i--;
        }
        return ans;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if (followMap.get(followerId)==null) {
            Map<Integer, Integer> map=new HashMap<Integer,Integer>();
            map.put(followerId, 1);
            followMap.put(followerId, map);
        }
        followMap.get(followerId).put(followeeId, 1);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (followerId!=followeeId&&followMap.get(followerId)!=null&&followMap.get(followerId).get(followeeId)!=null) {
            followMap.get(followerId).remove(followeeId);
        }
    }
}
