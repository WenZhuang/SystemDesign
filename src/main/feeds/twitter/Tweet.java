package main.feeds.twitter;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 推文的定义
 * @author wenzhuang
 * @date 2020/1/23 2:00 AM
 */

public class Tweet {
    //模拟自增主键
    private static AtomicInteger atomicInteger = new AtomicInteger(0);

    public int id;
    public int user_id;
    public String text;

    public static Tweet create(int user_id, String tweet_text) {
        // This will create a new tweet object,
        // and auto fill id
        return new Tweet(user_id, tweet_text);
    }

    private Tweet(int user_id, String tweet_text){
        this.user_id = user_id;
        this.text = tweet_text;
        this.id = createId();
    }

    private int createId(){
        return atomicInteger.decrementAndGet();
    }
}