package test.rateLimit;

import main.rateLimit.RateLimit;

/**
 * @author wenzhuang
 * @date 2020/2/1 5:20 PM
 */
public class RateLimitTest {
    public static void main(String[] args){
        RateLimit rateLimit = new RateLimit();
        rateLimit.isRatelimited(1, "login", "3/m", true);
        rateLimit.isRatelimited(11, "login", "3/m", true);
        rateLimit.isRatelimited(21, "login", "3/m", true);
        rateLimit.isRatelimited(30, "login", "3/m", true);
        rateLimit.isRatelimited(65, "login", "3/m", true);
        rateLimit.isRatelimited(300, "login", "3/m", true);
    }
}
