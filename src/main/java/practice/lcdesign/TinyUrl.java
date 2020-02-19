package practice.lcdesign;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

// 232. Tiny Url
// Chapter 4
public class TinyUrl {

    private Map<String, String> map = new HashMap<>();
    private Random random = new Random();
    private String strList = "abcdefghijklmnopqrstuvwxyzABCDEFGHIGKLMNOPQRSTUVWXYZ0123456789";
    private String prefix = "http://tiny.url/";

    /*
     * @param url: a long url
     * @return: a short url starts with http://tiny.url/
     */
    public String longToShort(String url) {
        // write your code here
        String shortUrl = generate();
        if (!map.containsKey(shortUrl)) {
            map.put(shortUrl, url);
        }
        return shortUrl;
    }

    /*
     * @param url: a short url starts with http://tiny.url/
     * @return: a long url
     */
    public String shortToLong(String url) {
        // write your code here
        if (!map.containsKey(url))
            return null;
        return map.get(url);
    }

    private String generate() {
        StringBuilder sb = new StringBuilder();
        sb.append(prefix);
        for (int i = 0; i < 6; i++) {
            int idx = random.nextInt(62);
            sb.append(strList.charAt(idx));
        }
        return sb.toString();
    }
}
