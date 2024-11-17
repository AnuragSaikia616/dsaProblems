import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * designTwitter355
 */
public class designTwitter355 {
  static int time = 0;

  public class Twitter {

    class Tweet {
      private int tweetId;
      private int time;
      private Tweet next;

      public Tweet(int tweetId, int time, Tweet next) {
        this.tweetId = tweetId;
        this.time = time;
        this.next = next;
      }

      public int getTweetId() {
        return tweetId;
      }

      public Tweet getNext() {
        return next;
      }

    }

    class User {
      private int userId;
      private List<Integer> following;
      private Tweet latestTweet;

      public User(int userId, List<Integer> following) {
        this.userId = userId;
        this.following = following;
      }

      public int getUserId() {
        return userId;
      }

      public List<Integer> getFollowing() {
        return following;
      }

      public void follow(int followeeId) {
        this.following.add(followeeId);
      }

      public void post(Tweet t) {
        t.next = this.latestTweet;
        this.latestTweet = t;
      }
    }

    Map<Integer, User> userMap;

    public Twitter() {
      userMap = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
      if (!userMap.containsKey(userId)) {
        userMap.put(userId, new User(userId, new ArrayList<>()));
      }
      Tweet t = new Tweet(tweetId, ++time, null);
      userMap.get(userId).post(t);
    }

    public List<Integer> getNewsFeed(int userId) {

    }

    public void follow(int followerId, int followeeId) {

    }

    public void unfollow(int followerId, int followeeId) {

    }
  }

}
