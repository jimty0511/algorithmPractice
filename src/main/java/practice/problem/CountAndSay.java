package practice.problem;

// 38. Count and Say
public class CountAndSay {
    public String countAndSay(int n) {
        String cur = "1";
        while (--n > 0) {
            int count = 1;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < cur.length(); i++) {
                if (i == cur.length() - 1 || cur.charAt(i) != cur.charAt(i + 1)) {
                    sb.append(count).append(cur.charAt(i));
                    count = 1;
                } else {
                    count++;
                }
            }
            cur = sb.toString();
        }
        return cur;
    }
}
