package practice.problem;

// 165. Compare Version Numbers
public class CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        String[] s1 = version1.split("\\.");
        String[] s2 = version2.split("\\.");
        int len = Math.max(s1.length, s2.length);
        for (int i = 0; i < len; i++) {
            int c1 = 0, c2 = 0;
            if (s1.length > i)
                c1 = Integer.parseInt(s1[i]);
            if (s2.length > i)
                c2 = Integer.parseInt(s2[i]);
            if (c1 > c2)
                return 1;
            if (c1 < c2)
                return -1;
        }
        return 0;
    }
}
