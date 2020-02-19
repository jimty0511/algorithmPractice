package practice.lcdesign;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

// 522. Tiny Url II
// Chapter 4
public class TinyUrl2 {

    private Map<String, String> s2l = new HashMap<>();
    private Map<String, String> l2s = new HashMap<>();
    private Random random = new Random();
    private String strList = "abcdefghijklmnopqrstuvwxyzABCDEFGHIGKLMNOPQRSTUVWXYZ0123456789";
    private String prefix = "http://tiny.url/";

    /*
     * @param long_url: a long url
     * @param key: a short key
     * @return: a short url starts with http://tiny.url/
     */
    public String createCustom(String long_url, String key) {
        // write your code here
        String shorUrl = prefix + key;
        if (l2s.containsKey(long_url)) {
            if (l2s.get(long_url).equals(shorUrl))
                return shorUrl;
            else
                return "error";
        }
        if (s2l.containsKey(shorUrl))
            return "error";
        l2s.put(long_url, shorUrl);
        s2l.put(shorUrl, long_url);
        return shorUrl;
    }

    /*
     * @param long_url: a long url
     * @return: a short url starts with http://tiny.url/
     */
    public String longToShort(String long_url) {
        // write your code here
        if (l2s.containsKey(long_url))
            return l2s.get(long_url);
        String shortUrl = generate();
        l2s.put(long_url, shortUrl);
        s2l.put(shortUrl, long_url);
        return shortUrl;
    }

    /*
     * @param short_url: a short url starts with http://tiny.url/
     * @return: a long url
     */
    public String shortToLong(String short_url) {
        // write your code here
        if (s2l.containsKey(short_url))
            return s2l.get(short_url);
        return "error";
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
