package practice;

import practice.domain.*;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;
import java.lang.String;

public class AllPractices {

    public List<Integer> merge(List<Integer> first, List<Integer> second, List<Integer> accumulator) {
        if (first.isEmpty()) {
            accumulator.addAll(second);
        } else if (second.isEmpty()) {
            accumulator.addAll(first);
        } else {
            if (first.get(0) <= second.get(0)) {
                accumulator.add(first.get(0));
                return merge(first.subList(1, first.size()), second, accumulator);
            } else {
                accumulator.add(second.get(0));
                return merge(first, second.subList(1, second.size()), accumulator);
            }
        }
        return accumulator;
    }

    public List<Integer> mergeSort(List<Integer> list) {
        int mid = list.size() / 2;
        if (mid == 0) {
            return list;
        }
        return merge(
                mergeSort(list.subList(0, mid)),
                mergeSort(list.subList(mid, list.size())),
                new ArrayList<>()
        );
    }

    public <T> Set<T> getCommonElements(Collection<? extends Collection<T>> collections) {

        Set<T> common = new LinkedHashSet<T>();
        if (!collections.isEmpty()) {
            Iterator<? extends Collection<T>> iterator = collections.iterator();
            common.addAll(iterator.next());
            while (iterator.hasNext()) {
                common.retainAll(iterator.next());
            }
        }
        return common;
    }

    public int[] findErrorNums(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int duplicate = 0, n = nums.length;
        long sum = (n * (n + 1)) / 2;
        for (int i : nums) {
            if (set.contains(i)) {
                duplicate = i;
            }
            sum -= i;
            set.add(i);
        }
        return new int[]{duplicate, (int) sum + duplicate};
    }

    public int findLHS(int[] nums) {
        Arrays.sort(nums);
        int res = 0, stIdx = 0, nextStIdx = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[stIdx] > 1) {
                stIdx = nextStIdx;
            }
            if (nums[i] - nums[stIdx] == 1) {
                res = Math.max(i - stIdx + 1, res);
            }
            if (nums[i] != nums[i - 1]) {
                nextStIdx = i;
            }
        }
        return res;
    }


    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.next.val == current.next.next.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }

    public int searchInsert(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] newNumber = new int[n + 1];
        newNumber[0] = 1;
        return newNumber;
    }

    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();
        List<String> res = new ArrayList<>();
        int minSum = Integer.MAX_VALUE;
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }
        for (int i = 0; i < list2.length; i++) {
            Integer j = map.get(list2[i]);
            if (j != null && i + j <= minSum) {
                if (i + j < minSum) {
                    res.clear();
                    minSum = i + j;
                }
                res.add(list2[i]);
            }
        }
        return res.toArray(new String[res.size()]);
    }

    // 521. Longest Uncommon Subsequence I
    public int findLUSlength(String a, String b) {
        return a.equals(b) ? -1 : Integer.max(a.length(), b.length());
    }


    // 292. Nim Game
    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }

    // 796. Rotate String
    public boolean rotateString(String A, String B) {
        return A.length() == B.length() && (A + A).contains(B);
    }


    // 717. 1-bit and 2-bit Characters
    public boolean isOneBitCharacter(int[] bits) {
        int ones = 0;
        for (int i = bits.length - 2; i >= 0 && bits[i] != 0; i--) {
            ones++;
        }
        if (ones % 2 > 0) return false;
        return true;
    }

    // 551. Student Attendance Record I
    public boolean checkRecord(String s) {
        char[] c = s.toCharArray();
        int counta = 0, countl = 0;
        for (int i = 0; i < c.length; i++) {
            if (c[i] == 'A') {
                counta++;
            }
            if (c[i] == 'L') {
                countl++;
            } else {
                countl = 0;
            }
            if (countl > 2 || counta > 1) return false;
        }
        return true;
    }


    // Multiples of 3 and 5
    public int multiplesOf3And5(int n) {
        int sum = 0;
        for (int i = 1; i < n; i++) {
            if (i % 3 == 0 || i % 5 == 0) sum += i;
        }
        return sum;
    }

    // binomialCoeff
    public int binomialCoeff(int n, int k) {
        if (k == 0 || k == n) return 1;
        return binomialCoeff(n - 1, k - 1) + binomialCoeff(n - 1, k);
    }

    public int binomial(int n, int k) {
        int[][] res = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= Math.min(k, i); j++) {
                if (j == 0 || j == i) {
                    res[i][j] = 1;
                } else {
                    res[i][j] = res[i - 1][j - 1] + res[i - 1][j];
                }
            }
        }
        return res[n][k];
    }


    // getProductsOfAllIntsExceptAtIndex
    public int[] getProductsOfAllIntsExceptAtIndex(int[] input) {
        int[] res = new int[input.length];

        int productSoFar = 1;
        for (int i = 0; i < input.length; i++) {
            res[i] = productSoFar;
            productSoFar *= input[i];
        }
        productSoFar = 1;
        for (int i = input.length - 1; i >= 0; i--) {
            res[i] *= productSoFar;
            productSoFar *= input[i];
        }
        return res;
    }

    // highestProductOf3
    public int highestProductOf3(int[] input) {
        int highest = Math.max(input[0], input[1]);
        int lowest = Math.max(input[0], input[1]);

        int highestProductOf2 = input[0] * input[1];
        int lowestProductOf2 = input[0] * input[1];

        int highestProductOf3 = input[0] * input[1] * input[2];

        for (int i = 2; i < input.length; i++) {
            int current = input[i];
            highestProductOf3 = Math.max(Math.max(highestProductOf3, current * highestProductOf2), current * lowestProductOf2);
            highestProductOf2 = Math.max(Math.max(highestProductOf2, current * highest), current * lowest);
            lowestProductOf2 = Math.min(Math.min(lowestProductOf2, current * highest), current * lowest);
            highest = Math.max(highest, current);
            lowest = Math.min(lowest, current);
        }
        return highestProductOf3;
    }




    // 459. Repeated Substring Pattern
    public boolean repeatedSubstringPattern(String s) {
        int l = s.length();
        for (int i = l / 2; i >= 1; i--) {
            if (l % i == 0) {
                int m = l / i;
                String subS = s.substring(0, i);
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < m; j++) {
                    sb.append(subS);
                }
                if (sb.toString().equals(s)) return true;
            }
        }
        return false;
    }

    // 836. Rectangle Overlap
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return Math.max(rec1[0], rec2[0]) < Math.min(rec1[2], rec2[2]) && Math.max(rec1[1], rec2[1]) < Math.min(rec1[3], rec2[3]);
    }

    // 501. Find Mode in Binary Search Tree
    int max = 0;

    public int[] findMode(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> integerList = new ArrayList<>();
        findModeHelper(root, map);
        for (Integer k : map.keySet()) {
            if (map.get(k) == max) integerList.add(k);
        }
        int[] res = new int[integerList.size()];
        for (int i = 0; i < integerList.size(); i++) res[i] = integerList.get(i);

        return res;
    }

    private void findModeHelper(TreeNode root, Map<Integer, Integer> map) {
        if (root == null) return;
        map.put(root.val, map.getOrDefault(root.val, 0) + 1);
        max = Math.max(max, map.get(root.val));
        findModeHelper(root.left, map);
        findModeHelper(root.right, map);
    }

    // 172. Factorial Trailing Zeroes
    public int trailingZeroes(int n) {
        if (n == 0) return 0;
        else {
            int res = n / 5 + trailingZeroes(n / 5);
            return res;
        }

//        return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
    }

    // 38. Count and Say
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

    // 26. Remove Duplicates from Sorted Array
    public int removeDuplicates(int[] nums) {
        int index = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[index++] = nums[i];
            }
        }
        return index;
    }

    // 434. Number of Segments in a String
    public int countSegments(String s) {
        if (s.length() == 0) return 0;
        int count = 0;
        if (s.charAt(0) != ' ') count++;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) == ' ' && s.charAt(i) != ' ')
                count++;
        }
        return count;
    }

    // 441. Arranging Coins
    public int arrangeCoins(int n) {
        /* 数学推导
        (1+k)*k/2 = n
        k+k*k = 2*n
        k*k + k + 0.25 = 2*n + 0.25
        (k + 0.5) ^ 2 = 2*n +0.25
        k + 0.5 = sqrt(2*n + 0.25)
        k = sqrt(2*n + 0.25) - 0.5
        */
//        return (int) (Math.sqrt(2*(long)n+0.25) - 0.5);
        int count = 0, left = n;
        for (int i = 1; left >= i; i++) {
            count++;
            left -= i;
        }
        return count;
    }

    // 9. Palindrome Number
    public boolean isPalindrome(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)) return false;
        int rev = 0;
        while (x > rev) {
            rev = rev * 10 + x % 10;
            x = x / 10;
        }
        return (x == rev || x == rev / 10);
    }

    // 443. String Compression
    public int compress(char[] chars) {
        if (chars == null || chars.length == 0) return 0;
        if (chars.length == 1) return 1;
        int count = 1;
        int index = 0;
        for (int i = 0; i < chars.length; i++) {
            if (i != chars.length - 1 && chars[i] == chars[i + 1]) {
                count++;
            } else {
                chars[index] = chars[i];
                index++;
                if (count > 1) {
                    String num = String.valueOf(count);
                    for (int j = 0; j < num.length(); j++) {
                        chars[index] = num.charAt(j);
                        index++;
                    }
                    count = 1;
                }
            }
        }
        return index;
    }


    // 205. Isomorphic Strings
    public boolean isIsomorphic(String s, String t) {
//        if (s == null || s.length() <= 1) return true;
//        HashMap<Character, Character> map = new HashMap<>();
//        for (int i = 0; i < s.length(); i++) {
//            char a = s.charAt(i), b = t.charAt(i);
//            if (map.containsKey(a)) {
//                if (map.get(a).equals(b))
//                    continue;
//                else
//                    return false;
//            } else {
//                if (!map.containsValue(b))
//                    map.put(a, b);
//                else
//                    return false;
//            }
//        }
//        return true;

        int[] m = new int[512];
        for (int i = 0; i < s.length(); i++) {
            if (m[s.charAt(i)] != m[t.charAt(i) + 256]) return false;
            m[s.charAt(i)] = m[t.charAt(i) + 256] = i + 1;
        }
        return true;
    }

    // 67. Add Binary
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1, carry = 0;
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (i >= 0) {
                sum += a.charAt(i--) - '0';
            }
            if (j >= 0) {
                sum += b.charAt(j--) - '0';
            }
            sb.append(sum % 2);
            carry = sum / 2;
        }
        if (carry != 0) sb.append(carry);
        return sb.reverse().toString();
    }

    // 290. Word Pattern
    public boolean wordPattern(String pattern, String str) {
        List<String> stringList = Arrays.asList(str.split(" "));
        Map<Character, String> map = new HashMap<>();
        if (pattern.length() != stringList.size()) return false;
        for (int i = 0; i < pattern.length(); i++) {
            if (map.containsKey(pattern.charAt(i))) {
                if (!map.get(pattern.charAt(i)).equals(stringList.get(i)))
                    return false;
            } else {
                if (!map.containsValue(stringList.get(i))) {
                    map.put(pattern.charAt(i), stringList.get(i));
                } else {
                    return false;
                }
            }
        }
        return true;
    }


    // 30. Substring with Concatenation of All Words
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (s == null || words == null || words.length == 0 || s.length() < words.length * words[0].length())
            return res;
//        Map<String, Integer> counts = new HashMap<>();
//        for (String w : words) {
//            counts.put(w, counts.getOrDefault(w, 0) + 1);
//        }
//        int n = s.length(), num = words.length, len = words[0].length();
//
//        Map<String, Integer> curMap = new HashMap<>();
//        for (int start = 0; start < len; start++) {
//            curMap.clear();
//            int left = start;
//            int count = 0;
//            for (int right = start + len; right <= n; right += len) {
//                String sub = s.substring(right - len, right);
//                if (counts.containsKey(sub)) {
//                    curMap.put(sub, curMap.getOrDefault(sub, 0) + 1);
//                    count++;
//                    while (curMap.get(sub) > counts.get(sub)) {
//                        String leftSub = s.substring(left, left + len);
//                        curMap.put(leftSub, curMap.get(leftSub) - 1);
//                        left += len;
//                        count--;
//                    }
//                    if (count == num) {
//                        res.add(left);
//                        String leftSub = s.substring(left, left + len);
//                        curMap.put(leftSub, curMap.get(leftSub) - 1);
//                        left += len;
//                        count--;
//                    }
//                } else {
//                    curMap.clear();
//                    count = 0;
//                    left = right;
//                }
//            }
//        }
//        return res;


//        for (int i = 0; i < n - num * len + 1; i++) {
//            Map<String, Integer> seen = new HashMap<>();
//            int j = 0;
//            while (j < num) {
//                String word = s.substring(i + j * len, i + (j + 1) * len);
//                if (counts.containsKey(word)) {
//                    seen.put(word, seen.getOrDefault(word, 0) + 1);
//                    if (seen.get(word) > counts.getOrDefault(word, 0))
//                        break;
//                } else {
//                    break;
//                }
//                j++;
//            }
//            if (j == num)
//                res.add(i);
//        }
//
//        return res;

        int n = s.length(), m = words.length, wl = words[0].length();
        Map<String, Integer> map = new HashMap<>(), curMap = new HashMap<>();
        for (String w : words) {
            map.put(w, map.getOrDefault(w, 0) + 1);
        }
        String str = null, tmp = null;
        for (int i = 0; i < wl; i++) {
            int count = 0;
            int start = i;
            for (int right = i; right + wl <= n; right += wl) {
                str = s.substring(right, right + wl);
                if (map.containsKey(str)) {
                    curMap.put(str, curMap.getOrDefault(str, 0) + 1);

                    if (curMap.get(str) <= map.get(str))
                        count++;
                    while (curMap.get(str) > map.get(str)) {
                        tmp = s.substring(start, start + wl);
                        curMap.put(tmp, curMap.get(tmp) - 1);
                        start += wl;

                        if (curMap.get(tmp) < map.get(tmp))
                            count--;
                    }
                    if (count == m) {
                        res.add(start);
                        tmp = s.substring(start, start + wl);
                        curMap.put(tmp, curMap.get(tmp) - 1);
                        start += wl;
                        count--;
                    }
                } else {
                    curMap.clear();
                    count = 0;
                    start = right + wl;
                }
            }
            curMap.clear();
        }
        return res;
    }

    // 111. Minimum Depth of Binary Tree
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
//        int left = minDepth(root.left);
//        int right = minDepth(root.right);
//        return (left == 0 || right == 0) ? left + right + 1 : Math.min(left, right) + 1;
        if (root.left == null)
            return minDepth(root.right) + 1;
        if (root.right == null)
            return minDepth(root.left) + 1;

        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);

        return Math.min(leftDepth, rightDepth) + 1;
    }

    public int minDepthBfs(TreeNode root) {
        if (root == null)
            return 0;
        int depth = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                if (temp.left == null && temp.right == null)
                    return depth;
                if (temp.left != null)
                    queue.offer(temp.left);
                if (temp.right != null)
                    queue.offer(temp.right);
            }
            depth++;
        }
        return depth;
    }


    // 203. Remove Linked List Elements
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        ListNode pointer = head;
        while (pointer.next != null) {
            if (pointer.next.val == val)
                pointer.next = pointer.next.next;
            else
                pointer = pointer.next;
        }
        return head.val == val ? head.next : head;
    }


    // 687. Longest Univalue Path
    int univaluePathMax = 0;

    public int longestUnivaluePath(TreeNode root) {
        if (root != null) {
            longestUnivaluePathHelper(root);
        }
        return univaluePathMax;
    }

    private int longestUnivaluePathHelper(TreeNode root) {
        int l = root.left != null ? longestUnivaluePathHelper(root.left) : 0;
        int r = root.right != null ? longestUnivaluePathHelper(root.right) : 0;
        int resl = root.left != null && root.left.val == root.val ? l + 1 : 0;
        int resr = root.right != null && root.right.val == root.val ? r + 1 : 0;
        univaluePathMax = Math.max(univaluePathMax, resl + resr);
        return Math.max(resl, resr);
    }

    // 507. Perfect Number
    public boolean checkPerfectNumber(int num) {
        if (num <= 1) return false;
        int sum = 0;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                sum += i;
                if (i != num / i) // we only need to add the same factor once
                    sum += num / i;
            }
        }
        sum++;
        return sum == num;
    }

    // 633. Sum of Square Numbers
    public boolean judgeSquareSum(int c) {
        if (c < 0) return false;
        int left = 0, right = (int) Math.sqrt(c);
        while (left <= right) {
            int cur = left * left + right * right;
            if (cur < c) {
                left++;
            } else if (cur > c) {
                right--;
            } else {
                return true;
            }
        }
        return false;
    }

    // 88. Merge Sorted Array
    public void mergeSortedArray(int[] nums1, int m, int[] nums2, int n) {
        int i = m + n - 1;
        m--;
        n--;
        while (n >= 0) {
            if (m < 0 || nums1[m] < nums2[n]) {
                nums1[i--] = nums2[n--];
            } else {
                nums1[i--] = nums1[m--];
            }
        }
    }

    // 680. Valid Palindrome II
    public boolean validPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                int i1 = i, j1 = j - 1, i2 = i + 1, j2 = j;
                while (i1 < j1 && s.charAt(i1) == s.charAt(j1)) {
                    i1++;
                    j1--;
                }
                while (i2 < j2 && s.charAt(i2) == s.charAt(j2)) {
                    i2++;
                    j2--;
                }
                return i1 >= j1 || i2 >= j2;
            }
        }
        return true;
    }

    // 58. Length of Last Word
    public int lengthOfLastWord(String s) {
        if (s.trim().isEmpty()) return 0;
        String[] res = s.split(" ");
        return res[res.length - 1].length();
    }

    // 686. Repeated String Match
    public int repeatedStringMatch(String A, String B) {
        StringBuilder sb = new StringBuilder();
        int n = B.length() / A.length();
        for (int i = 0; i < n + 2; i++) {
            sb.append(A);
            String temp = sb.toString();
            if (temp.contains(B))
                return i + 1;
        }
        return -1;
    }

    // 160. Intersection of Two Linked Lists
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode a = headA;
        ListNode b = headB;
        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        return a;
    }

    // 605. Can Place Flowers
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 1, result = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                count++;
            } else {
                result += (count - 1) / 2;
                count = 0;
            }
        }
        if (count != 0)
            result += count / 2;
        return result >= n;
    }

    // 400. Nth Digit
    public int findNthDigit(int n) {
        int length = 1;
        long count = 9;
        int start = 1;
        while (n > length * count) {
            n -= length * count;
            length += 1;
            count *= 10;
            start *= 10;
        }
        start += (n - 1) / length;
        String s = Integer.toString(start);
        return Character.getNumericValue(s.charAt((n - 1) % length));
    }

    // 475. Heaters
    public int findRadius(int[] houses, int[] heaters) {
//        Arrays.sort(heaters);
//        int result = Integer.MIN_VALUE;
//        for (int house : houses) {
//            int index = Arrays.binarySearch(heaters, house);
//            if (index < 0) {
//                index = -(index + 1);
//            }
//            int dist1 = index - 1 >= 0 ? house - heaters[index - 1] : Integer.MAX_VALUE;
//            int dist2 = index < heaters.length ? heaters[index] - house : Integer.MAX_VALUE;
//
//            result = Math.max(result, Math.min(dist1, dist2));
//        }
//        return result;

        Arrays.sort(houses);
        Arrays.sort(heaters);
        int i = 0, j = 0, res = 0;
//        while (i < houses.length) {
//            while (j < heaters.length - 1 && Math.abs(heaters[j + 1] - houses[i]) <= Math.abs(heaters[j] - houses[i])) {
//                j++;
//            }
//            res = Math.max(res, Math.abs(heaters[j] - houses[i]));
//            i++;
//        }
        for (int house : houses) {
            while (i < heaters.length - 1 && heaters[i] + heaters[i + 1] <= house * 2) {
                i++;
            }
            res = Math.max(res, Math.abs(heaters[i] - house));
        }
        return res;
    }


    // 581. Shortest Unsorted Continuous Subarray
    public int findUnsortedSubarray(int[] nums) {
//        int[] clone = nums.clone();
//        Arrays.sort(clone);
//        int start = clone.length, end = 0;
//        for (int i = 0; i < clone.length; i++) {
//            if (clone[i] != nums[i]) {
//                start = Math.min(start, i);
//                end = Math.max(end, i);
//            }
//        }
//        return end - start >= 0 ? end - start + 1 : 0;

        int n = nums.length, beg = -1, end = -2, min = nums[n - 1], max = nums[0];
        for (int i = 1; i < n; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[n - 1 - i]);
            if (nums[i] < max)
                end = i;
            if (nums[n - 1 - i] > min)
                beg = n - 1 - i;
        }
        return end - beg + 1;
    }

    // 28. Implement strStr()
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) return 0;
        if (haystack.length() == 0 || haystack.length() < needle.length()) return -1;
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            if (haystack.substring(i, i + needle.length()).equals(needle))
                return i;
        }
        return -1;
    }

    // 69. Sqrt(x)
    public int mySqrt(int x) {
        if (x == 0) return 0;
        int start = 1, end = x;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            int val = x / mid;
            if (val == mid) {
                return mid;
            } else if (val > mid) {
                start = mid;
            } else {
                end = mid;
            }
        }
        return start;
    }


    // 125. Valid Palindrome
    public boolean isPalindrome(String s) {
        if (s == "") return true;
        int left = 0, right = s.length() - 1;
        char head, tail;
        while (left <= right) {
            head = s.charAt(left);
            tail = s.charAt(right);
            if (!Character.isLetterOrDigit(head)) {
                left++;
            } else if (!Character.isLetterOrDigit(tail)) {
                right--;
            } else {
                if (Character.toLowerCase(head) != Character.toLowerCase(tail)) {
                    return false;
                }
                left++;
                right--;
            }
        }
        return true;
    }

    // 479. Largest Palindrome Product
    public int largestPalindrome(int n) {
        if (n == 1) return 9;
        int max = (int) Math.pow(10, n) - 1;
        for (int v = max - 1; v > max / 10; v--) {
            long u = Long.valueOf(v + new StringBuilder().append(v).reverse().toString());
            for (long x = max; x * x >= u; x--) {
                if (u % x == 0)
                    return (int) (u % 1337);
            }
        }
        return 0;
    }

    // Extract leaves to doubly linked list
    ListNode currentNode = null, headNode = null, prevNode = null;

    public ListNode leavesToDoublyLinkedList(TreeNode treeNode) {
        leavesToDoublyLinkedListHelper(treeNode);
        return headNode;
    }

    public TreeNode leavesToDoublyLinkedListHelper(TreeNode treeNode) {
        if (treeNode == null) return null;
        if (treeNode.left == null && treeNode.right == null) {
            if (headNode == null) {
                currentNode = new ListNode(treeNode.val);
                headNode = currentNode;
                prevNode = currentNode;
            } else {
                currentNode = new ListNode(treeNode.val);
                currentNode.left = prevNode;
                prevNode.next = currentNode;
                prevNode = currentNode;
            }
            return null;
        }
        treeNode.left = leavesToDoublyLinkedListHelper(treeNode.left);
        treeNode.right = leavesToDoublyLinkedListHelper(treeNode.right);
        return treeNode;
    }

    // 624：Maximum Distance in Arrays
    public int maxDistance(List<List<Integer>> arrays) {
        int res = 0;
        int min = arrays.get(0).get(0);
        int max = arrays.get(0).get(arrays.get(0).size() - 1);
        for (int i = 1; i < arrays.size(); i++) {
            List<Integer> array = arrays.get(i);
            res = Math.max(Math.abs(min - array.get(array.size()) - 1), Math.max(Math.abs(array.get(0) - max), res));
            min = Math.min(min, array.get(0));
            max = Math.max(max, array.get(array.size() - 1));
        }
        return res;
    }


    // Remove Alternate Duplicate characters from a char array you have to do it in Place.Like keeping only the odd occurences of each character.
    public String removeAlternateDuplicate(String input) {
        Map<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
            if (map.get(c) == 1) {
                sb.append(c);
            } else {
                map.put(c, map.get(c) - 2);
            }
        }
        return sb.toString();
    }


    // Print all nodes at distance k from a given node
    List<Integer> printkdistanceNode = new ArrayList<>();

    public void printkdistanceNodeDown(TreeNode node, int k) {
        if (node == null || k < 0)
            return;
        if (k == 0) {
            printkdistanceNode.add(node.val);
            return;
        }
        printkdistanceNodeDown(node.left, k - 1);
        printkdistanceNodeDown(node.right, k - 1);
    }

    public int printkdistanceNode(TreeNode node, TreeNode target, int k) {
        if (node == null)
            return -1;
        if (node == target) {
            printkdistanceNodeDown(node, k);
            return 0;
        }

        int dl = printkdistanceNode(node.left, target, k);
        if (dl != -1) {
            if (dl + 1 == k) {
                printkdistanceNode.add(node.val);
            } else {
                printkdistanceNodeDown(node.right, k - dl - 2);
            }
            return dl + 1;
        }

        int dr = printkdistanceNode(node.right, target, k);
        if (dr != -1) {
            if (dr + 1 == k) {
                printkdistanceNode.add(node.val);
            } else {
                printkdistanceNodeDown(node.left, k - dr - 2);
            }
            return 1 + dr;
        }
        return -1;
    }

    // 824. Goat Latin
    public String toGoatLatin(String S) {
        StringBuilder res = new StringBuilder();
        String[] strings = S.split(" ");
        int a = 1;
        for (String s : strings) {
            if (isVowel(s.charAt(0))) {
                res.append(s).append("ma");
                for (int i = 0; i < a; i++) {
                    res.append("a");
                }
                res.append(" ");
                a++;
            } else {
                res.append(s.substring(1)).append(s.charAt(0)).append("ma");
                for (int i = 0; i < a; i++) {
                    res.append("a");
                }
                res.append(" ");
                a++;
            }
        }
        return res.toString().trim();
    }

    private boolean isVowel(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
            return true;
        }
        return false;
    }

    // 504. Base 7
    public String convertToBase7(int num) {
        if (num < 0)
            return "-" + convertToBase7(-num);
        if (num < 7)
            return num + "";
        return convertToBase7(num / 7) + num % 7;
    }


    // 7. Reverse Integer
    public int reverse(int x) {
        StringBuilder sb = new StringBuilder(Integer.toString(Math.abs(x)));
        try {
            String reversed = sb.reverse().toString();
            return Integer.parseInt(reversed.replaceFirst("^0+(?!$)", "")) * (x / Math.abs(x));
        } catch (Exception e) {
            return 0;
        }
    }

    // 665. Non-decreasing Array
    public boolean checkPossibility(int[] nums) {
        if (nums == null || nums.length <= 1) return true;
        boolean found = false;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > nums[i]) {
                if (found)
                    return false;
                else {
                    if (i - 2 >= 0 && nums[i - 2] > nums[i])
                        nums[i] = nums[i - 1];
                    found = true;
                }
            }
        }
        return true;
    }

    // 344. Reverse String
    public String reverseString(String s) {
        if (s == null || s.length() == 0)
            return "";
        char[] chars = s.toCharArray();
        for (int i = 0, j = s.length() - 1; i <= s.length() / 2; i++, j--) {
            char temp = s.charAt(i);
            chars[j] = temp;
            chars[i] = s.charAt(j);
        }
        return String.valueOf(chars);
    }

    // 412. Fizz Buzz
    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                res.add("FizzBuzz");
            } else if (i % 3 == 0) {
                res.add("Fizz");
            } else if (i % 5 == 0) {
                res.add("Buzz");
            } else {
                res.add(String.valueOf(i));
            }
        }
        return res;
    }


    // 283. Move Zeroes
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int index = 0;
        for (int num : nums) {
            if (num != 0)
                nums[index++] = num;
        }
        while (index < nums.length) {
            nums[index++] = 0;
        }
    }


    // 242. Valid Anagram
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) return false;
        int[] res = new int[26];
        for (int i = 0; i < s.length(); i++) {
            res[s.charAt(i) - 'a']++;
            res[t.charAt(i) - 'a']--;
        }
        for (int n : res) {
            if (n != 0)
                return false;
        }
        return true;
    }

    // 237. Delete Node in a Linked List
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }


    // 108. Convert Sorted Array to Binary Search Tree
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBSTHelper(nums, 0, nums.length - 1);
    }

    private TreeNode sortedArrayToBSTHelper(int[] nums, int low, int high) {
        if (low > high)
            return null;
        int mid = (low + high + 1) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = sortedArrayToBSTHelper(nums, low, mid - 1);
        node.right = sortedArrayToBSTHelper(nums, mid + 1, high);
        return node;
    }

    // 109. Convert Sorted List to Binary Search Tree
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        return sortedListToBSTHelper(head, null);
    }

    private TreeNode sortedListToBSTHelper(ListNode head, ListNode tail) {
        ListNode slow = head;
        ListNode fast = head;
        if (head == tail) return null;
        while (fast != tail && fast.next != tail) {
            fast = fast.next.next;
            slow = slow.next;
        }
        TreeNode treeNode = new TreeNode(slow.val);
        treeNode.left = sortedListToBSTHelper(head, slow);
        treeNode.right = sortedListToBSTHelper(slow.next, tail);
        return treeNode;
    }


    // 202. Happy Number
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (set.add(n)) {
            int sum = 0;
            while (n > 0) {
                int digit = n % 10;
                sum += digit * digit;
                n /= 10;
            }
            if (sum == 1)
                return true;
            else {
                n = sum;
            }
        }
        return false;
    }


    public List<Integer> cellCompete(int[] states, int days) {
        // WRITE YOUR CODE HERE
        List<Integer> result = new ArrayList<>();
        int n = states.length;
        int[] temp = new int[n];

        for (int i = 0; i < n; i++)
            temp[i] = states[i];
        while (days-- > 0) {

            // Finding next values for corner cells
            temp[0] = 0 ^ states[1];
            temp[n - 1] = 0 ^ states[n - 2];

            // Compute values of intermediate cells
            // If both cells active or inactive, then
            // temp[i]=0 else temp[i] = 1.
            for (int i = 1; i <= n - 2; i++)
                temp[i] = states[i - 1] ^ states[i + 1];

            // Copy temp[] to cells[] for next iteration
            for (int i = 0; i < n; i++)
                states[i] = temp[i];
        }
        for (int i : states) {
            result.add(i);
        }
        return result;
    }

    public int generalizedGCD(int num, int[] arr) {
        // WRITE YOUR CODE HERE
        Arrays.sort(arr);
        int result = arr[0];
        for (int i = 1; i < num; i++) {
            result = gcd(arr[i], result);
        }
        return result;
    }

    // Method to find gcd between two integers
    private int gcd(int a, int b) {
        if (a == 0) {
            return b;
        }
        return gcd(b % a, a);
    }

    // Print a given matrix in spiral form
    public List<Integer> spiralPrint(int[][] input) {
        List<Integer> result = new ArrayList<>();
        int m = input.length, n = input[0].length;
        int k = 0, l = 0;
        while (k < m && l < n) {
            for (int i = l; i < n; i++) {
                result.add(input[k][i]);
            }
            k++;
            for (int i = k; i < m; i++) {
                result.add(input[i][n - 1]);
            }
            n--;
            if (k < m) {
                for (int i = n - 1; i >= l; i--) {
                    result.add(input[m - 1][i]);
                }
                m--;
            }
            if (l < n) {
                for (int i = m - 1; i >= k; i--) {
                    result.add(input[i][l]);
                }
                l++;
            }
        }
        return result;
    }

    // Given an n-by-n matrix of 0’s and 1’s where all 1’s in each row come before all 0’s,
    // find the most efficient way to return the row with the maximum number of 0’s.
    public int rowWithMax0(int[][] input) {
        int resRow = 0;
        int row = 0, col = input[0].length - 1;
        while (row < input.length && col >= 0) {
            if (input[row][col] == 0) {
                col--;
                resRow = row;
            } else {
                row++;
            }
        }
        return resRow;
    }

    // Given a limit, generate all Pythagorean Triples with values smaller than given limit
    public List<List<Integer>> pythagoreanTriplets(int limit) {
        List<List<Integer>> result = new ArrayList<>();
        int a, b, c = 0;
        int m = 2;
        while (c < limit) {
            for (int n = 1; n < m; n++) {
                List<Integer> subResult = new ArrayList<>();

                a = m * m - n * n;
                b = 2 * m * n;
                c = m * m + n * n;

                if (c > limit)
                    break;
                subResult = Arrays.asList(a, b, c);
                result.add(subResult);
            }
            m++;
        }
        return result;
    }

    // find LCM of two numbers
    public int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    // find LCM of n elements
    public long lcmOfArrays(int[] array) {
        long lcmOfArrays = 1;
        int divisor = 2;
        while (true) {
            int count = 0;
            boolean divisible = false;
            for (int i = 0; i < array.length; i++) {
                if (array[i] == 0) {
                    return 0;
                } else if (array[i] < 0) {
                    array[i] = array[i] * -1;
                }
                if (array[i] == 1)
                    count++;

                if (array[i] % divisor == 0) {
                    divisible = true;
                    array[i] = array[i] / divisor;
                }
            }
            if (divisible) {
                lcmOfArrays = lcmOfArrays * divisor;
            } else {
                divisor++;
            }

            if (count == array.length)
                return lcmOfArrays;
        }
    }

    public int lcmOfArraysTwo(int[] array) {
        int result = array[0];
        for (int i = 1; i < array.length; i++) {
            result = lcm(result, array[i]);
        }
        return result;
    }


    public List<String> retrieveMostFrequentlyUsedWords(String literatureText, List<String> wordsToExclude) {
        List<String> result = new ArrayList<>();
        int mostFreq = 0;
        if (literatureText.length() == 0) return result;
        Map<String, Integer> map = new HashMap<>();
        List<String> wordList = Arrays.stream(literatureText.split("\\W+"))
                .map(i -> i.toLowerCase()).collect(Collectors.toList());

        wordsToExclude = wordsToExclude.stream().map(i -> i.toLowerCase()).collect(Collectors.toList());

        for (String word : wordList) {
            if (!wordsToExclude.contains(word.toLowerCase())) {
                map.put(word.toLowerCase(), map.getOrDefault(word.toLowerCase(), 0) + 1);
                mostFreq = Math.max(mostFreq, map.get(word.toLowerCase()));
            }
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == mostFreq) {
                result.add(entry.getKey());
            }
        }

        return result;
    }

    public List<String> reorderLines(int logFileSize, List<String> logLines) {
        List<String> result = new ArrayList<>();
        if (logFileSize != logLines.size()) return result;

        Map<String, String> letterLineMap = new HashMap<>();
        Map<String, String> digitLineMap = new HashMap<>();

        for (String s : logLines) {
            int firstSpace = s.indexOf(" ");
            String subStr = s.substring(firstSpace + 1);
            if (Character.isLetter(subStr.charAt(0)))
                letterLineMap.put(s.substring(0, firstSpace), s.substring(firstSpace + 1));
            else if (Character.isDigit(subStr.charAt(0)))
                digitLineMap.put(s.substring(0, firstSpace), s.substring(firstSpace + 1));
        }

        List<Map.Entry<String, String>> letterList = letterLineMap.entrySet().stream().sorted((a, b) -> a.getValue() == b.getValue() ?
                b.getKey().compareTo(a.getKey()) : b.getValue().compareTo(a.getValue()))
                .collect(Collectors.toList());

        List<Map.Entry<String, String>> digitList = digitLineMap.entrySet().stream().sorted((a, b) -> a.getValue() == b.getValue() ?
                b.getKey().compareTo(a.getKey()) : b.getValue().compareTo(a.getValue()))
                .collect(Collectors.toList());

        StringBuilder sb = new StringBuilder();

        for (int i = letterList.size() - 1; i >= 0; i--) {
            sb.append(letterList.get(i).getKey()).append(" ").append(letterList.get(i).getValue());
            result.add(sb.toString());
            sb.setLength(0);
        }

        for (int i = 0; i < digitList.size(); i++) {
            sb.append(digitList.get(i).getKey()).append(" ").append(digitList.get(i).getValue());
            result.add(sb.toString());
            sb.setLength(0);
        }

        return result;
    }


    // 347. Top K Frequent Elements
    public List<Integer> topKFrequent(int[] nums, int k) {
        if (nums.length == 1)
            return Arrays.asList(nums[0]);

        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        Arrays.stream(nums).forEach(x -> map.put(x, map.getOrDefault(x, 0) + 1));

        PriorityQueue<Map.Entry<Integer, Integer>> max = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            max.add(entry);
        }

        while (result.size() < k) {
            Map.Entry<Integer, Integer> entry = max.poll();
            result.add(entry.getKey());
        }
        return result;
    }

    // 22. Generate Parentheses
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateParenthesisHelper(result, "", 0, 0, n);
        return result;
    }

    private void generateParenthesisHelper(List<String> list, String str, int open, int close, int max) {
        if (str.length() == max * 2) {
            list.add(str);
            return;
        }

        if (open < max) {
            generateParenthesisHelper(list, str + "(", open + 1, close, max);
        }
        if (close < open) {
            generateParenthesisHelper(list, str + ")", open, close + 1, max);
        }
    }

    public List<String> generateParenthesisTwo(int n) {
        List<String> list = new ArrayList();
        generateParenthesisTwoHelper(list, "", n, n);
        return list;
    }

    private void generateParenthesisTwoHelper(List<String> list, String tempStr, int l, int r) {
        if (l == 0 && r == 0) {
            list.add(tempStr);
        } else {
            if (r > l) {
                generateParenthesisTwoHelper(list, tempStr + ")", l, r - 1);
            }
            if (l > 0) {
                generateParenthesisTwoHelper(list, tempStr + "(", l - 1, r);
            }
        }
    }

    /**
     * BackTracking related problems
     */
    public List<String> generateParenthesisBacktrack(int n) {
        List<String> result = new ArrayList<>();
        generateParenthesisBacktrackHelper(result, new StringBuilder(), 0, 0, n);
        return result;
    }

    private void generateParenthesisBacktrackHelper(List<String> list, StringBuilder sb,
                                                    int open, int close, int n) {
        if (open > n) {
            return;
        } else if (open == n && close == n) {
            list.add(sb.toString());
        } else {
            if (open < n) {
                sb.append("(");
                generateParenthesisBacktrackHelper(list, sb, open + 1, close, n);
                sb.setLength(sb.length() - 1);
            }
            if (close < open) {
                sb.append(")");
                generateParenthesisBacktrackHelper(list, sb, open, close + 1, n);
                sb.setLength(sb.length() - 1);
            }
        }
    }

    // 46. Permutations
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        permuteBacktrack(list, new ArrayList<>(), nums);
        return list;
    }

    private void permuteBacktrack(List<List<Integer>> list, List<Integer> tempList, int[] nums) {
        if (tempList.size() == nums.length) {
            list.add(new ArrayList<>(tempList));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (tempList.contains(nums[i]))
                    continue;
                tempList.add(nums[i]);
                permuteBacktrack(list, tempList, nums);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    public List<List<Integer>> permuteIterative(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        int l = nums.length;
        if (nums == null || l == 0)
            return list;

        Queue<List<Integer>> queue = new ArrayDeque<>();
        for (int n : nums) {
            queue.offer(Arrays.asList(n));
        }

        while (!queue.isEmpty()) {
            List<Integer> next = queue.poll();
            if (l == next.size()) {
                list.add(next);
                continue;
            }
            for (int n : nums) {
                if (!next.contains(n)) {
                    List<Integer> u = new ArrayList<>(next);
                    u.add(n);
                    queue.offer(u);
                }
            }
        }
        return list;
    }

    // 47. Permutations II
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        permuteUniqueHelper(result, new ArrayList<>(), nums, new boolean[nums.length]);
        return result;
    }

    private void permuteUniqueHelper(List<List<Integer>> list, List<Integer> tempList, int[] nums, boolean[] used) {
        if (tempList.size() == nums.length) {
            list.add(new ArrayList<>(tempList));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1])
                    continue;
                used[i] = true;
                tempList.add(nums[i]);
                permuteUniqueHelper(list, tempList, nums, used);
                used[i] = false;
                tempList.remove(tempList.size() - 1);
            }
        }
    }


    // 90. Subsets II
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        subsetsWithDupHelper(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private void subsetsWithDupHelper(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start) {
        list.add(new ArrayList<>(tempList));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1])
                continue;
            tempList.add(nums[i]);
            subsetsWithDupHelper(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }

    // 39. Combination Sum
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSumHelper(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    private void combinationSumHelper(List<List<Integer>> list, List<Integer> tempList,
                                      int[] candidates, int remain, int start) {
        if (remain < 0) {
            return;
        } else if (remain == 0) {
            list.add(new ArrayList<>(tempList));
        } else {
            for (int i = start; i < candidates.length; i++) {
                tempList.add(candidates[i]);
                combinationSumHelper(list, tempList, candidates, remain - candidates[i], i);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    // 40. Combination Sum II
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSum2Helper(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    private void combinationSum2Helper(List<List<Integer>> list, List<Integer> tempList, int[] candidates,
                                       int remain, int start) {
        if (remain < 0) {
            return;
        } else if (remain == 0) {
            list.add(new ArrayList<>(tempList));
        } else {
            for (int i = start; i < candidates.length; i++) {
                if (i > start && candidates[i] == candidates[i - 1]) {
                    continue;
                }
                tempList.add(candidates[i]);
                combinationSum2Helper(list, tempList, candidates, remain - candidates[i], i + 1);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    // 131. Palindrome Partitioning
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        partitionHelper(result, new ArrayList<>(), s, 0);
        return result;
    }

    private void partitionHelper(List<List<String>> list, List<String> tempList, String s, int start) {
        if (start == s.length()) {
            list.add(new ArrayList<>(tempList));
        } else {
            for (int i = start; i < s.length(); i++) {
                if (isPalindromePartition(s, start, i)) {
                    tempList.add(s.substring(start, i + 1));
                    partitionHelper(list, tempList, s, i + 1);
                    tempList.remove(tempList.size() - 1);
                }
            }
        }
    }

    private boolean isPalindromePartition(String s, int low, int high) {
        while (low < high) {
            if (s.charAt(low++) != s.charAt(high--))
                return false;
        }
        return true;
    }

    /**
     * End of backtracking questions
     */

    // 18. 4Sum
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        fourSumHelper(result, new ArrayList<>(), nums, target, 0);
        return result;
    }

    private void fourSumHelper(List<List<Integer>> list, List<Integer> tempList, int[] nums, int remain, int start) {
        if (tempList.size() == 4 && remain == 0 && !list.contains(tempList)) {
            list.add(new ArrayList<>(tempList));
        } else if (tempList.size() == 4) {
            return;
        } else {
            for (int i = start; i < nums.length; i++) {
                if (nums[i] + nums[nums.length - 1] * (3 - tempList.size()) < remain)
                    continue;
                if (nums[i] * (4 - tempList.size()) > remain)
                    return;
                tempList.add(nums[i]);
                fourSumHelper(list, tempList, nums, remain - nums[i], i + 1);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    // 454. 4Sum II
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                int sum = C[i] + D[j];
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }

        int res = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                res += map.getOrDefault(-1 * (A[i] + B[j]), 0);
            }
        }

        return res;
    }


    // 328. Odd Even Linked List
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode odd = head, even = head.next, p = odd, q = even;
        while (q != null && q.next != null) {
            p.next = q.next;
            p = q.next;
            q.next = p.next;
            q = p.next;
        }
        p.next = even;
        return odd;
    }

    // 378. Kth Smallest Element in a Sorted Matrix
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<Tuple> pq = new PriorityQueue<>();
        for (int j = 0; j <= n - 1; j++) {
            pq.offer(new Tuple(0, j, matrix[0][j]));
        }
        for (int i = 0; i < k - 1; i++) {
            Tuple t = pq.poll();
            if (t.x == n - 1)
                continue;
            pq.offer(new Tuple(t.x + 1, t.y, matrix[t.x + 1][t.y]));
        }
        return pq.poll().val;
    }

    public int kthSmallestBinarySearch(int[][] matrix, int k) {
        int low = matrix[0][0], high = matrix[matrix.length - 1][matrix[0].length - 1] + 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            int count = 0, j = matrix[0].length - 1;
            for (int i = 0; i < matrix.length; i++) {
                while (j >= 0 && matrix[i][j] > mid)
                    j--;
                count += (j + 1);
            }
            if (count < k)
                low = mid + 1;
            else
                high = mid;
        }
        return low;
    }

    // 373. Find K Pairs with Smallest Sums
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<Tuple> pq = new PriorityQueue<>();
        int m = nums1.length, n = nums2.length;
        List<int[]> res = new ArrayList<>();
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0 || k <= 0) return res;
        for (int j = 0; j <= n - 1; j++)
            pq.offer(new Tuple(0, j, nums1[0] + nums2[j]));
        for (int i = 0; i < Math.min(k, m * n); i++) {
            Tuple t = pq.poll();
            res.add(new int[]{nums1[t.x], nums2[t.y]});
            if (t.x == m - 1)
                continue;
            pq.offer(new Tuple(t.x + 1, t.y, nums1[t.x + 1] + nums2[t.y]));
        }
        return res;
    }

    public int findDuplicateBinarySearch(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int low = 1, high = nums.length - 1, mid;
        while (low < high) {
            mid = low + (high - low) / 2;
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= mid)
                    count++;
            }
            if (count > mid)
                high = mid;
            else
                low = mid + 1;
        }
        return low;
    }

    // 75. Sort Colors
    public void sortColors(int[] nums) {
        int zero = 0, two = nums.length - 1;
        for (int i = 0; i <= two; i++) {
            while (nums[i] == 2 && i < two) {
                int temp = nums[i];
                nums[i] = nums[two];
                nums[two--] = temp;
            }
            while (nums[i] == 0 && i > zero) {
                int temp = nums[i];
                nums[i] = nums[zero];
                nums[zero++] = temp;
            }
        }
    }

    // 162. Find Peak Element
    public int findPeakElement(int[] nums) {
        return findPeakElementHelper(nums, 0, nums.length - 1);
    }

    private int findPeakElementHelper(int[] nums, int start, int end) {
        if (start == end) {
            return start;
        } else if (start + 1 == end) {
            if (nums[start] > nums[end]) {
                return start;
            }
            return end;
        } else {
            int m = (start + end) / 2;
            if (nums[m] > nums[m - 1] && nums[m] > nums[m + 1]) {
                return m;
            } else if (nums[m - 1] > nums[m] && nums[m] > nums[m + 1]) {
                return findPeakElementHelper(nums, start, m - 1);
            } else {
                return findPeakElementHelper(nums, m + 1, end);
            }
        }
    }


    // 36. Valid Sudoku
    public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char number = board[i][j];
                if (number != '.') {
                    if (!seen.add(number + " in row " + i) || !seen.add(number + " in col " + j)
                            || !seen.add(number + " in block " + i / 3 + "-" + j / 3)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }


    // 289. Game of Life
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0)
            return;
        int m = board.length, n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int lives = gameOfLifeHelper(board, m, n, i, j);
                if (board[i][j] == 1 && lives >= 2 && lives <= 3) {
                    board[i][j] = 3;
                }
                if (board[i][j] == 0 && lives == 3) {
                    board[i][j] = 2;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] >>= 1;
            }
        }
    }

    private int gameOfLifeHelper(int[][] board, int m, int n, int i, int j) {
        int lives = 0;
        for (int x = Math.max(i - 1, 0); x <= Math.min(i + 1, m - 1); x++) {
            for (int y = Math.max(j - 1, 0); y <= Math.min(j + 1, n - 1); y++) {
                lives += board[x][y] & 1;
            }
        }
        lives -= board[i][j] & 1;
        return lives;
    }


    // 227. Basic Calculator II
    public int calculate(String s) {
        int len = s.length();
        if (s == null || s.length() == 0)
            return 0;
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char sign = '+';
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                num = num * 10 + s.charAt(i) - '0';
            }
            if (!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == len - 1) {
                if (sign == '-') {
                    stack.push(-num);
                }
                if (sign == '+') {
                    stack.push(num);
                }
                if (sign == '*') {
                    stack.push(stack.pop() * num);
                }
                if (sign == '/') {
                    stack.push(stack.pop() / num);
                }
                sign = s.charAt(i);
                num = 0;
            }
        }

        int re = 0;
        for (int i : stack) {
            re += i;
        }
        return re;
    }

    // 433. Minimum Genetic Mutation
    public int minMutation(String start, String end, String[] bank) {
        if (start.equals(end))
            return 0;
        Set<String> bankSet = new HashSet<>();
        for (String s : bank)
            bankSet.add(s);
        if (!bankSet.contains(end))
            return -1;
        char[] charSet = new char[]{'A', 'C', 'G', 'T'};

        int level = 0;
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                String curr = queue.poll();
                if (curr.equals(end))
                    return level;
                char[] currChars = curr.toCharArray();
                for (int i = 0; i < currChars.length; i++) {
                    char oldChar = currChars[i];
                    for (char c : charSet) {
                        currChars[i] = c;
                        String next = new String(currChars);
                        if (!visited.contains(next) && bankSet.contains(next)) {
                            visited.add(next);
                            queue.offer(next);
                        }
                    }
                    currChars[i] = oldChar;
                }
            }
            level++;
        }
        return -1;
    }

    public int minMutationBiDirection(String start, String end, String[] bank) {
        if (bank == null || bank.length == 0)
            return -1;
        Set<String> bankSet = new HashSet<>();
        for (String s : bank)
            bankSet.add(s);
        if (!bankSet.contains(end))
            return -1;

        char[] charSet = new char[]{'A', 'C', 'G', 'T'};
        Set<String> fwd = new HashSet<>(), bwd = new HashSet<>();
        fwd.add(start);
        bwd.add(end);

        int level = 0;
        while (!fwd.isEmpty() && !bwd.isEmpty()) {
            if (fwd.size() > bwd.size()) {
                Set<String> tempSet = fwd;
                fwd = bwd;
                bwd = tempSet;
            }
            Set<String> temp = new HashSet<>();
            for (String s : fwd) {
                char[] currChars = s.toCharArray();
                for (int i = 0; i < s.length(); i++) {
                    char old = currChars[i];
                    for (char c : charSet) {
                        if (c == old)
                            continue;
                        currChars[i] = c;
                        String newString = new String(currChars);
                        if (bwd.contains(newString))
                            return level + 1;
                        if (bankSet.contains(newString)) {
                            temp.add(newString);
                            bankSet.remove(newString);
                        }
                        currChars[i] = old;
                    }
                }
            }
            level++;
            fwd = temp;
        }
        return -1;
    }

    public static String findGameStatus(char[][] board) {
        /*
         * Write your code here.
         */
        int height = board.length, width = board[0].length;
        boolean rWin = false, yWin = false;
        char[] players = new char[]{'R', 'Y'};
        for (char p : players) {
            char currentPlayer = p;
            outerLoop:
            for (int r = 0; r < height; r++) {
                for (int c = 0; c < width; c++) {
                    if (board[r][c] == '0') {
                        continue;
                    }
                    if (board[r][c] == currentPlayer) {
                        if (c + 3 < width && currentPlayer == board[r][c + 1] &&
                                currentPlayer == board[r][c + 2] && currentPlayer == board[r][c + 3]) {
                            if (currentPlayer == 'R') {
                                rWin = true;
                            } else {
                                yWin = true;
                            }
                            break outerLoop;
                        }
                        if (r + 3 < height) {
                            if (currentPlayer == board[r + 1][c] && currentPlayer == board[r + 2][c] &&
                                    currentPlayer == board[r + 3][c]) {
                                if (currentPlayer == 'R') {
                                    rWin = true;
                                } else {
                                    yWin = true;
                                }
                                break outerLoop;
                            }
                            if (c + 3 < width && currentPlayer == board[r + 1][c + 1] &&
                                    currentPlayer == board[r + 2][c + 2] && currentPlayer == board[r + 3][c + 3]) {
                                if (currentPlayer == 'R') {
                                    rWin = true;
                                } else {
                                    yWin = true;
                                }
                                break outerLoop;
                            }
                            if (c - 3 >= 0 && currentPlayer == board[r + 1][c - 1] &&
                                    currentPlayer == board[r + 2][c - 2] && currentPlayer == board[r + 3][c - 3]) {
                                if (currentPlayer == 'R') {
                                    rWin = true;
                                } else {
                                    yWin = true;
                                }
                                break outerLoop;
                            }
                        }
                    }
                }
            }
        }

        if (rWin && yWin) {
            return "B";
        } else if (rWin) {
            return "R";
        } else if (yWin) {
            return "Y";
        } else {
            return "N";
        }
    }
}
