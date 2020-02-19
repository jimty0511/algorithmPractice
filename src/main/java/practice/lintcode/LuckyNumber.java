package practice.lintcode;

import java.util.List;

// 1679. Lucky Number
public class LuckyNumber {
    /**
     * @param n: the n
     * @return: the smallest lucky number  that is not less than n
     */
//    public String luckyNumber(String n) {
//        // Write your code here.
//        int required;
//        StringBuilder large = new StringBuilder(), small = new StringBuilder();
//        required = n.length() / 2;
//        if (required == 0)
//            required = 1;
//        for (int i = 0; i < required; i++)
//            large.append(5);
//        for (int i = 0; i < required; i++) {
//            large.append(3);
//            small.append(3);
//        }
//        for (int i = 0; i < required; i++)
//            small.append(5);
//        if (Long.parseLong(small.toString()) == Long.parseLong(n))
//            return small.toString();
//        if (Long.parseLong(large.toString()) == Long.parseLong(n))
//            return large.toString();
//        if (Long.parseLong(n) > Long.parseLong(large.toString())) {
//            small.insert(0, 3);
//            small.append(5);
//            return small.toString();
//        }
//        helper(Long.parseLong(n), new StringBuilder(), 0, 0, required);
//        return String.valueOf(res);
//    }
//
//    private long res = Long.MAX_VALUE;
//
//    private void helper(long target, StringBuilder sb, int open, int close, int max) {
//        if (sb.length() == max * 2) {
//            long cur = Long.parseLong(sb.toString());
//            if (cur > target) {
//                res = Math.min(res, cur);
//            }
//            return;
//        }
//        if (open < max) {
//            helper(target, sb.append(3), open + 1, close, max);
//            sb.deleteCharAt(sb.length() - 1);
//        }
//        if (close <= open) {
//            helper(target, sb.append(5), open, close + 1, max);
//            sb.deleteCharAt(sb.length() - 1);
//        }
//    }
    public String luckyNumberTwo(String n) {
        int len = n.length();
        if (len % 2 != 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i <= len / 2; i++)
                sb.append("3");
            for (int i = 0; i <= len / 2; i++)
                sb.append("5");
            return sb.toString();
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < len / 2; i++)
                sb.append("3");
            for (int i = 0; i < len / 2; i++)
                sb.append("5");
            String cur = sb.toString();
            int[] nums = new int[sb.length()];
            for (int i = 0; i < n.length(); i++)
                nums[i] = n.charAt(i) - '0';
            int[] copy = new int[sb.length()];
            for (int i = 0; i < cur.length(); i++)
                copy[i] = cur.charAt(i) - '0';
            if (cur.compareTo(n) >= 0)
                return cur;
            int three = len / 2, five = len / 2;
            boolean canForm = true;
            int i = 0;
            while (i < nums.length) {
                if (nums[i] == 3) {
                    if (three > 0)
                        three--;
                    else if (five > 0) {
                        nums[i] = 5;
                        five--;
                    }
                } else if (nums[i] == 5) {
                    if (five > 0)
                        five--;
                } else {
                    if (nums[i] < 3) {
                        if (three > 0) {
                            nums[i++] = 3;
                            three--;
                        } else {
                            nums[i++] = 5;
                            five--;
                        }
                        break;
                    } else if (nums[i] < 5) {
                        if (five > 0)
                            nums[i++] = 5;
                        else {
                            canForm = false;
                            break;
                        }
                        break;
                    } else {
                        int j = i;
                        while (j - 1 >= 0 && nums[j - 1] == 5)
                            j--;
                        if (j <= 0) {
                            canForm = false;
                            break;
                        }
                        nums[j - 1] = 5;
                        five--;
                        three++;
                        i = j;
                        break;
                    }
                }
                i++;
            }
            StringBuilder res = new StringBuilder();
            if (!canForm) {
                for (int j = 0; j <= len / 2; j++)
                    res.append(3);
                for (int j = 0; j <= len / 2; j++)
                    res.append(5);
                return res.toString();
            } else {
                int total = 0;
                for (int j = 0; j < i; j++) {
                    res.append(nums[j]);
                    total++;
                }
                for (int j = 0; j < three; j++) {
                    res.append(3);
                    total++;
                }
                while (total < n.length()) {
                    res.append(5);
                    total++;
                }
                return res.toString();
            }
        }
    }

//    private String nextPermutation(char[] array) {
//        int i = array.length - 1;
//        while (i > 0 && array[i - 1] >= array[i])
//            i--;
//        // Now i is the head index of the suffix
//
//        // Are we at the last permutation already?
//        if (i <= 0)
//            return null;
//
//        // Let array[i - 1] be the pivot
//        // Find rightmost element that exceeds the pivot
//        int j = array.length - 1;
//        while (array[j] <= array[i - 1])
//            j--;
//        // Now the value array[j] will become the new pivot
//        // Assertion: j >= i
//
//        // Swap the pivot with j
//        char temp = array[i - 1];
//        array[i - 1] = array[j];
//        array[j] = temp;
//
//        // Reverse the suffix
//        j = array.length - 1;
//        while (i < j) {
//            temp = array[i];
//            array[i] = array[j];
//            array[j] = temp;
//            i++;
//            j--;
//        }
//        return new String(array);
//    }
}
