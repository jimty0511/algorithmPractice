package practice.problem;

import java.util.TreeMap;

// 616. Add Bold Tag in String
public class AddBoldTagInString {
    public String addBoldTagTreeMap(String s, String[] dict) {
        int n = s.length();
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (String d : dict) {
            int i = -1;
            i = s.indexOf(d, i);
            while (i != -1) {
                treeMap.put(i, treeMap.getOrDefault(i, 0) + 1);
                treeMap.put(i + d.length(), treeMap.getOrDefault(i + d.length(), 0) - 1);
                i = s.indexOf(d, i + 1);
            }
        }
        StringBuilder sb = new StringBuilder();
        int count = 0;
        boolean bold = false;
        for (int i = 0; i <= n; i++) {
            if (treeMap.containsKey(i)) {
                count += treeMap.get(i);
                if (count > 0 && !bold) {
                    sb.append("<b>");
                    bold = true;
                } else if (count == 0 && bold) {
                    sb.append("</b>");
                    bold = false;
                }
            }
            if (i == n)
                break;
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    public String addBoldTagArray(String s, String[] dict) {
        int n = s.length();
        int[] mark = new int[n + 1];
        for (String d : dict) {
            int i = -1;
            i = s.indexOf(d, i);
            while (i != -1) {
                mark[i]++;
                mark[i + d.length()]--;
                i = s.indexOf(d, i + 1);
            }
        }
        StringBuilder sb = new StringBuilder();
        int count = 0;
        boolean bold = false;
        for (int i = 0; i <= n; i++) {
            count += mark[i];
            if (count > 0 && !bold) {
                sb.append("<b>");
                bold = true;
            }
            if (count == 0 && bold) {
                sb.append("</b>");
                bold = false;
            }
            if (i == n)
                break;
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}

