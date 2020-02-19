package practice.lintcode;

import java.util.*;

// 1754. knightship
public class Knightship {
    /**
     * @param a: the Initial state
     * @return: the fewest steps to complete the task
     */
    public int getSteps(String[] a) {
        // Write your code here
        String[] tar = new String[]{"11111", "01111", "00*11", "00001", "00000"};
        String target = String.join(",", tar);
        String ori = String.join(",", a);
        int[][] moves = {{1, 2}, {1, -2}, {-1, 2}, {-1, -2}, {2, 1}, {2, -1}, {-2, 1}, {-2, -1}};
        int[] vacancy = new int[2];
        Set<String> visited = new HashSet<>();
        visited.add(ori);
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (a[i].charAt(j) == '*') {
                    vacancy[0] = i;
                    vacancy[1] = j;
                }
            }
        }
        Queue<int[]> q = new LinkedList<>();
        Queue<String> strQ = new LinkedList<>();
        strQ.offer(ori);
        q.offer(vacancy);
        int step = 1;
        while (!q.isEmpty()) {
            if (step > 15)
                break;
            int size = q.size();
            while (size-- > 0) {
                int[] cur = q.poll();
                String curStr = strQ.poll();
                String[] curStrArr = curStr.split(",");
                int i = cur[0], j = cur[1];
                for (int[] m : moves) {
                    int x = i + m[0], y = j + m[1];
                    if (x < 0 || x >= 5 || y < 0 || y >= 5)
                        continue;
                    StringBuilder sbOne = new StringBuilder(curStrArr[i]);
                    StringBuilder sbTwo = new StringBuilder(curStrArr[x]);
                    char knight = curStrArr[x].charAt(y);
                    sbOne.setCharAt(j, knight);
                    sbTwo.setCharAt(y, '*');
                    String[] copy = Arrays.copyOf(curStrArr, 5);
                    copy[i] = sbOne.toString();
                    copy[x] = sbTwo.toString();
                    String next = String.join(",", copy);
                    if (next.equals(target))
                        return step;
                    if (visited.add(next)) {
                        q.offer(new int[]{x, y});
                        strQ.offer(next);
                    }
                }
            }
            step++;
        }
        return -1;
    }

    public int getStepsTwo(String[] a) {
        // Write your code here
        String[] tar = new String[]{"11111", "01111", "00*11", "00001", "00000"};
        String target = String.join("", tar);
        String ori = String.join("", a);
        int[] movesTwo = {-3, 3, -7, 7, -9, 9, -11, 11};
        Set<String> begin = new HashSet<>(), end = new HashSet<>(), visited = new HashSet<>();
        begin.add(ori);
        end.add(target);
        int step = 1;
        while (!begin.isEmpty() && !end.isEmpty()) {
            if (begin.size() > end.size()) {
                Set<String> set = begin;
                begin = end;
                end = set;
            }
            Set<String> tmp = new HashSet<>();
            if (step > 15)
                break;
            for (String cur : begin) {
                int idx = cur.indexOf('*');
                for (int m : movesTwo) {
                    int newIdx = idx + m;
                    if (newIdx < 0 || newIdx >= 25)
                        continue;
                    String next = swap(cur, idx, newIdx);
                    if (end.contains(next))
                        return step;
                    if (!visited.contains(next)) {
                        visited.add(next);
                        tmp.add(next);
                    }
                }
            }
            begin = tmp;
            step++;
        }
        return -1;
    }

    public int getStepsThree(String[] a) {
        // Write your code here
        String[] tar = new String[]{"11111", "01111", "00*11", "00001", "00000"};
        String target = String.join("", tar);
        String ori = String.join("", a);
        int[] movesTwo = {-3, 3, -7, 7, -9, 9, -11, 11};
        Set<String> visited = new HashSet<>();
        visited.add(ori);
        Queue<String> q = new LinkedList<>();
        q.offer(ori);
        int step = 1;
        while (!q.isEmpty()) {
            if (step > 15)
                break;
            int size = q.size();
            while (size-- > 0) {
                String cur = q.poll();
                int idx = cur.indexOf('*');
                for (int m : movesTwo) {
                    int newIdx = idx + m;
                    if (newIdx < 0 || newIdx >= 25)
                        continue;
                    String next = swap(cur, idx, newIdx);
                    if (next.equals(target))
                        return step;
                    if (visited.add(next)) {
                        q.offer(next);
                    }
                }
            }
            step++;
        }
        return -1;
    }

    public int getStepsFour(String[] a) {
        // Write your code here
        String[] tar = new String[]{"11111", "01111", "00*11", "00001", "00000"};
        String target = String.join(",", tar);
        String ori = String.join(",", a);
        int[][] moves = {{1, 2}, {1, -2}, {-1, 2}, {-1, -2}, {2, 1}, {2, -1}, {-2, 1}, {-2, -1}};
        Set<String> begin = new HashSet<>(), end = new HashSet<>(), visited = new HashSet<>();
        begin.add(ori);
        end.add(target);
        int step = 1;
        while (!begin.isEmpty() && !end.isEmpty()) {
            if (begin.size() > end.size()) {
                Set<String> set = begin;
                begin = end;
                end = set;
            }
            Set<String> tmp = new HashSet<>();
            if (step > 15)
                break;
            for (String cur : begin) {
                String[] curStrArr = cur.split(",");
                int i = -1, j = -1;
                for (int k = 0; k < 5; k++) {
                    if (curStrArr[k].indexOf('*') >= 0) {
                        i = k;
                        j = curStrArr[k].indexOf('*');
                        break;
                    }
                }
                for (int[] m : moves) {
                    int x = i + m[0], y = j + m[1];
                    if (x < 0 || x >= 5 || y < 0 || y >= 5)
                        continue;
                    StringBuilder sbOne = new StringBuilder(curStrArr[i]);
                    StringBuilder sbTwo = new StringBuilder(curStrArr[x]);
                    char knight = curStrArr[x].charAt(y);
                    sbOne.setCharAt(j, knight);
                    sbTwo.setCharAt(y, '*');
                    String[] copy = Arrays.copyOf(curStrArr, 5);
                    copy[i] = sbOne.toString();
                    copy[x] = sbTwo.toString();
                    String next = String.join(",", copy);
                    if (end.contains(next))
                        return step;
                    if (!visited.contains(next)) {
                        visited.add(next);
                        tmp.add(next);
                    }
                }
            }
            begin = tmp;
            step++;
        }
        return -1;
    }

    private String swap(String cur, int i, int j) {
        char[] chars = cur.toCharArray();
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
        return new String(chars);
    }

    private boolean valid(String[] target, String[] cur) {
        for (int i = 0; i < 5; i++) {
            if (!target[i].equals(cur[i]))
                return false;
        }
        return true;
    }
}
