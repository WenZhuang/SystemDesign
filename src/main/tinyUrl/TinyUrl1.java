package main.tinyUrl;

import java.util.*;

/**
 * 使用随机法生成短网址
 * @author wenzhuang
 * @date 2020/1/26 12:23 AM
 */
public class TinyUrl1 {
    private final static String cs = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private final String start = "http://tiny.url/";

    private Map<String, String> shortToLongMap = new HashMap<>();

    private Map<String, String> longToShortMap = new HashMap<>();

    private Random random = new Random();

    /*
     * @param long_url: a long url
     * @param key: a short key
     * @return: a short url starts with http://tiny.url/
     */
    public String createCustom(String long_url, String key) {
        // write your code here
        String shortUrl = start + key;
        if (longToShortMap.containsKey(long_url)){
            if (shortUrl.equals(longToShortMap.get(long_url))){
                return shortUrl;
            } else{
                return "error";
            }
        }
        if (shortToLongMap.containsKey(shortUrl)){
            return "error";
        }
        shortToLongMap.put(shortUrl, long_url);
        longToShortMap.put(long_url, shortUrl);
        return shortUrl;
    }

    /*
     * @param url: a long url
     * @return: a short url starts with http://tiny.url/
     */
    public String longToShort(String url) {
        // write your code here
        if (longToShortMap.containsKey(url)){
            return longToShortMap.get(url);
        }
        String shortUrl = getRandomUrl();
        while (shortToLongMap.containsKey(shortUrl)){
            shortUrl = getRandomUrl();
        }
        shortToLongMap.put(shortUrl, url);
        longToShortMap.put(url, shortUrl);
        return shortUrl;
    }

    /*
     * @param url: a short url starts with http://tiny.url/
     * @return: a long url
     */
    public String shortToLong(String url) {
        // write your code here
        return shortToLongMap.get(url);
    }

    private String getRandomUrl(){
        String url = "";
        for (int i = 0; i < 6; i++){
            url += cs.charAt(random.nextInt(62));
        }
        return start + url;
    }
}
