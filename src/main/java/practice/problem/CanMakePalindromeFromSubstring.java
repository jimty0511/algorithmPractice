package practice.problem;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// 1177. Can Make Palindrome from Substring
public class CanMakePalindromeFromSubstring {
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        List<Boolean> res = new ArrayList<>();
        for (int[] q : queries)
            res.add(canMakePal(s, q[0], q[1], q[2]));
        return res;
    }

    private boolean canMakePal(String s, int start, int end, int max) {
        if (max >= 13)
            return true;
        Set<Character> set = new HashSet<>();
        for (int i = start; i <= end; i++) {
            if (!set.add(s.charAt(i)))
                set.remove(s.charAt(i));
        }
        return max >= set.size() / 2;
    }

    /**
     * 1.cnt数组类似于一个“前缀和”。cnt【i】【j】表示，从0开始，到当前位置i（不包括i），包含字符（‘a’ + j）的总个数。
     * 2.遍历字符串，更新这个“前缀和数组”。
     * 3.对于每一个操作q，可以得到substring（q【0】， q【1】 + 1），通过前面的“前缀和”数组，可以得到该substring的字母统计结果，即该substring包含多少个a，多少个b，以此类推。
     * 4.对于步骤三得到的结果，开始进行操作，对于每一个字母，查看其个数，如果是偶数个，则sum不变【理由：题目允许rearrange，比如abac，可以先rearrange成abca，则a这个字母是不需要进行替换的】；如果是奇数个，则sum值+1，表示这个落单的字母将来需要被替换掉。这一步遍历完成后，得到了需要replace的总的字符数量。
     * 5.按照要求，有sum个落单的，因此，只要把其中的一般替换成另一半，一定可以rearrange成一个palindrome。
     **/
    public List<Boolean> canMakePaliQueriesTwo(String s, int[][] queries) {
        List<Boolean> res = new ArrayList<>();
        int[][] cnt = new int[s.length() + 1][26];
        for (int i = 0; i < s.length(); i++) {
            cnt[i + 1] = cnt[i].clone();
            cnt[i + 1][s.charAt(i) - 'a']++;
        }
        for (int[] q : queries) {
            int sum = 0;
            for (int i = 0; i < 26; i++) {
                sum += (cnt[q[1] + 1][i] - cnt[q[0]][i]) % 2;
            }
            res.add(sum / 2 <= q[2]);
        }
        return res;
    }
}
