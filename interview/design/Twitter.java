package interview.design;


//355 Design Twitter
/**
It is a design problem using 2 or more data structure
1. Create User 
2. Post a tweet as user
3. Follow other users - Follower follows a followee. If the operation is invalid, it should be a no-op. 
4. Unfollow other users
5. Get Timeline // Get top 10 tweets of all the tweets made by user and his/her followers

User has following attributes
1. UserId an unique id
2. Set of users whom he is following
3. Set of tweets made by the users

Tweet
1. It belongs to user
2. Timestamp when it was made to can keep track of latest tweets
3. TweetId an unique id

***Map of userid as key and value as user object
 Function
1. Create User with an userid and instantiate list of tweets and set of followers.
2. Post a tweet as user with user id and tweet. if user doesnt exist then create it and add to map and then add create tweet and add to the tweet list of the user and set the time stamp.
3. Follow other users(follower,followee) create both users if they dont exist and get user by follower id and add the follow list with followee id
4. Unfollow other users
5. Get Timeline // Get top 10 tweets of all the tweets made by user and his/her followers
a. get user by user id
b. get tweets from the user
c. get followers and get tweets of all them
d. add all the tweets to the priority queue to sort them by descending order of timestamp
e. get top 10 tweets or number of tweet in the priority queue.

*/
public class Twitter {
    long timeStamp=0;
    public static class User{
        Set<Integer> follows;//= new HashSet<User>();
        int userId;
        List<Tweet> tweets;
            public User(int userId){
            follows= new HashSet<Integer>();
            this.userId=userId;
                tweets= new LinkedList<Tweet>();
        }
    }
    public static class Tweet{
        int tweetId;
        int userId;
        long timeStamp=0;
            public Tweet(int userId,int tweetId,long timeStamp){
            this.tweetId=tweetId;
            this.userId=userId;
            this.timeStamp=timeStamp;
        }
    }
    Map<Integer,User> map;
    /** Initialize your data structure here. */
    public Twitter() {
        map= new HashMap<Integer,User>();
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if(!map.containsKey(userId)){
            map.put(userId,new User(userId));
        }
        User user=map.get(userId);
        Tweet t= new Tweet(userId,tweetId,timeStamp++);
        user.tweets.add(t);
        
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        if(!map.containsKey(userId)) return new ArrayList<Integer>();
        PriorityQueue<Tweet> pq= new PriorityQueue<Tweet>(10,(a,b)->(int)(b.timeStamp-a.timeStamp));
        User user= map.get(userId);
        List<Tweet> tweets= new ArrayList<Tweet>();
        tweets.addAll(user.tweets);
        for(int i:user.follows){
            tweets.addAll(map.get(i).tweets);
        }
        for(Tweet i:tweets){
            pq.offer(i);
            
        }
        List<Integer> result= new ArrayList<Integer>(); 
        int k=1;
        while(!pq.isEmpty() &&k<11){
            result.add(pq.poll().tweetId);
            k++;
        }
        return result;
        
        
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
         if(followerId==followeeId) return;
        if(!map.containsKey(followerId)){
            map.put(followerId,new User(followerId));
        }
        if(!map.containsKey(followeeId)){
            map.put(followeeId,new User(followeeId));
        }
       
        map.get(followerId).follows.add(followeeId);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
         if(followerId==followeeId) return;
        if(!map.containsKey(followerId)){
            map.put(followerId,new User(followerId));
        }
        if(!map.containsKey(followeeId)){
            map.put(followeeId,new User(followeeId));
        }
        
        map.get(followerId).follows.remove(followeeId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */