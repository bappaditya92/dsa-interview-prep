import java.util.*;

class Tweet {

    int id;
    int time;

    Tweet(int id, int time) {
        this.id = id;
        this.time = time;
    }
}

public class Twitter {

    private int timestamp;

    private final Map<Integer, Set<Integer>> followMap;
    private final Map<Integer, List<Tweet>> tweetMap;

    public Twitter() {

        timestamp = 0;

        followMap = new HashMap<>();
        tweetMap = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {

        tweetMap.putIfAbsent(userId,
                new ArrayList<>());

        tweetMap.get(userId)
                .add(new Tweet(tweetId, timestamp++));
    }

    public List<Integer> getNewsFeed(int userId) {

        PriorityQueue<Tweet> pq =
                new PriorityQueue<>(
                        (a, b) -> b.time - a.time
                );

        followMap.putIfAbsent(userId,
                new HashSet<>());

        followMap.get(userId).add(userId);

        for (int followee :
                followMap.get(userId)) {

            List<Tweet> tweets =
                    tweetMap.getOrDefault(
                            followee,
                            new ArrayList<>());

            for (Tweet tweet : tweets) {
                pq.offer(tweet);
            }
        }

        List<Integer> result =
                new ArrayList<>();

        int count = 0;

        while (!pq.isEmpty()
                && count < 10) {

            result.add(pq.poll().id);

            count++;
        }

        return result;
    }

    public void follow(int followerId,
                       int followeeId) {

        followMap.putIfAbsent(followerId,
                new HashSet<>());

        followMap.get(followerId)
                .add(followeeId);
    }

    public void unfollow(int followerId,
                         int followeeId) {

        if (followMap.containsKey(followerId)
                && followeeId != followerId) {

            followMap.get(followerId)
                    .remove(followeeId);
        }
    }
}
