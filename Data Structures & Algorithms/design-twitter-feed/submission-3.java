class FeedItem {
    int userId;
    int tweetIdx;

    public FeedItem(int userId, int tweetIdx){
        this.userId = userId;
        this.tweetIdx = tweetIdx;
    }
}

class Tweet {
    int tweetId;
    int time;

    public Tweet(int tweetId, int time){
        this.tweetId = tweetId;
        this.time = time;
    }
}

class Twitter {
    Map<Integer, Set<Integer>> followeesMap;
    Map<Integer, List<Tweet>> userTweetMap;
    int time;

    public Twitter() {
        followeesMap = new HashMap<>();
        userTweetMap = new HashMap<>();
        time = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        userTweetMap.computeIfAbsent(userId, k -> new ArrayList<>()).add(new Tweet(tweetId, time));
        time++;
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> result = new ArrayList<>();
        Set<Integer> followees = new HashSet<>(followeesMap.getOrDefault(userId, Collections.emptySet()));
        // adding current user to their own feed
        followees.add(userId);

        PriorityQueue<FeedItem> feed = new PriorityQueue<>(
            (a, b) -> Integer.compare(
                userTweetMap.get(b.userId).get(b.tweetIdx).time,
                userTweetMap.get(a.userId).get(a.tweetIdx).time
                )
            );

        for(Integer followeeId : followees){
            List<Tweet> userTweets = userTweetMap.get(followeeId);
            if(userTweets != null && userTweets.size() > 0){
                feed.add(new FeedItem(followeeId, userTweets.size() - 1));
            }
        }
        
        while(result.size() < 10 && !feed.isEmpty()){
            FeedItem topFeed = feed.poll();
            List<Tweet> currentUserTweets = userTweetMap.get(topFeed.userId);

            result.add(currentUserTweets.get(topFeed.tweetIdx).tweetId);

            if(topFeed.tweetIdx > 0){
                feed.add(new FeedItem(topFeed.userId, topFeed.tweetIdx - 1));
            }
        }

        return result;
    }
    
    public void follow(int followerId, int followeeId) {
        followeesMap.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        Set<Integer> followees = followeesMap.get(followerId);
        if(followees != null){
            followees.remove(followeeId);
        } else {
            // failure will be caught in console
            System.out.println("Failure");
        }
    }
}
