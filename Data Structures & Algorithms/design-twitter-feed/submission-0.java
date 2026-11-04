class Twitter {
    class Tweet {
        int tweetId;
        int timestamp;

        public Tweet(int tweetId, int timestamp) {
            this.tweetId = tweetId;
            this.timestamp = timestamp;
        }
    }
    private Map<Integer, List<Tweet>> userTweets = new HashMap<>();
    private Map<Integer, Set<Integer>> following = new HashMap<>();

    private int globalTime = 0;
    public Twitter() {}

    public void postTweet(int userId, int tweetId) {
        userTweets.computeIfAbsent(userId, key -> new ArrayList<>())
            .add(new Tweet(tweetId, globalTime++));
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> feed = new ArrayList<>();

        Set<Integer> users = new HashSet<>(following.getOrDefault(userId, Collections.emptySet()));
        users.add(userId);


        PriorityQueue<Tweet> heap = new PriorityQueue<>((a, b) -> Integer.compare(b.timestamp, a.timestamp));

        for(Integer user: users){
            List<Tweet> tweets = userTweets.get(user);

            if( tweets == null) continue;

            heap.addAll(tweets);
        }

        for(int i = 0 ; i < 10 && !heap.isEmpty(); i++){
            feed.add(heap.poll().tweetId);
        }
        return feed;

    }

    public void follow(int followerId, int followeeId) {
        following.computeIfAbsent(followerId, key -> new HashSet<>()).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        Set<Integer> set = following.get(followerId);
        if(set != null) set.remove(followeeId);
    }
}
