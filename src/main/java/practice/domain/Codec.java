package practice.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Codec {
    Map<String, String> map = new HashMap<>();
    String strList = "abcdefghijklmnopqrstuvwxyzABCDEFGHIGKLMNOPQRSTUVWXYZ0123456789";

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        int n = strList.length();
        Random r = new Random();
        StringBuilder sb = new StringBuilder();
        sb.append("http://tinyurl.com/");
        for (int i = 0; i < 6; i++) {
            int j = r.nextInt(n);
            sb.append(strList.charAt(j));
        }
        if (!map.containsKey(sb.toString())) {
            map.put(sb.toString(), longUrl);
        }
        return sb.toString();
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return map.get(shortUrl);
    }
}
