package practice;

import practice.domain.ListNode;
import practice.domain.TreeNode;
import practice.domain.Tuple;

import java.util.*;
import java.util.stream.Collectors;

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

    // 521. Longest Uncommon Subsequence I
    public int findLUSlength(String a, String b) {
        return a.equals(b) ? -1 : Integer.max(a.length(), b.length());
    }


    // 292. Nim Game
    public boolean canWinNim(int n) {
        return n % 4 != 0;
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


    // 172. Factorial Trailing Zeroes
    public int trailingZeroes(int n) {
        if (n == 0) return 0;
        else {
            int res = n / 5 + trailingZeroes(n / 5);
            return res;
        }

//        return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
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


    // 58. Length of Last Word
    public int lengthOfLastWord(String s) {
        if (s.trim().isEmpty()) return 0;
        String[] res = s.split(" ");
        return res[res.length - 1].length();
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

    // 504. Base 7
    public String convertToBase7(int num) {
        if (num < 0)
            return "-" + convertToBase7(-num);
        if (num < 7)
            return num + "";
        return convertToBase7(num / 7) + num % 7;
    }


    // 237. Delete Node in a Linked List
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }


    public List<Integer> cellCompete(int[] states, int days) {
        // WRITE YOUR CODE HERE
//        List<Integer> result = new ArrayList<>();
//        int n = states.length;
//        int[] temp = states;
//        while (days-- > 0) {
//
//            // Finding next values for corner cells
//            temp[0] = 0 ^ states[1];
//            temp[n - 1] = 0 ^ states[n - 2];
//
//            // Compute values of intermediate cells
//            // If both cells active or inactive, then
//            // temp[i]=0 else temp[i] = 1.
//            for (int i = 1; i <= n - 2; i++)
//                temp[i] = states[i - 1] ^ states[i + 1];
//
//            // Copy temp[] to cells[] for next iteration
//            for (int i = 0; i < n; i++)
//                states[i] = temp[i];
//        }
//        for (int i : states) {
//            result.add(i);
//        }
//        return result;

        List<Integer> res = new ArrayList<>();
        int n = states.length;
        int[] temp = new int[n];
        for (int i = 0; i < n; i++)
            temp[i] = states[i];
        while (days-- > 0) {
            temp[0] = 0 ^ states[1];
            temp[n - 1] = 0 ^ states[n - 2];
            for (int i = 1; i <= n - 2; i++) {
                temp[i] = states[i - 1] ^ states[i + 1];
            }
            for (int i = 0; i < n; i++)
                states[i] = temp[i];
        }
        for (int i : states) {
            res.add(i);
        }
        return res;
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


    /**
     * End of backtracking questions
     */


    // 378. Kth Smallest Element in a Sorted Matrix
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

    public List<List<Integer>> solution(int[] input) {
        List<List<Integer>> res = new ArrayList<>();
        if (input == null || input.length == 0)
            return res;
        helper(input, 0, 0, new ArrayList<>(), res);
        return res;
    }

    private void helper(int[] input, int index, int sum, List<Integer> temp, List<List<Integer>> res) {
        if (temp.size() == 3) {
            if (sum == 0) {
                res.add(new ArrayList<>(temp));
            }
        } else {
            for (int i = index; i < input.length; i++) {
                int current = input[i]; // 5
                sum += current;         // 5
                temp.add(i);            // 0
                helper(input, i, sum, temp, res);
                temp.remove(temp.size() - 1); // 0
            }
        }
    }

    /**
     * Hackerrank
     */
    public void plusMinus(int[] arr) {
        double positive = 0, negative = 0, len = arr.length;
        for (int n : arr) {
            if (n > 0)
                positive++;
            else if (n < 0)
                negative++;
        }
        double p = positive / len, n = negative / len, z = (len - positive - negative) / len;
        System.out.println(String.format("%.6f", p));
        System.out.println(String.format("%.6f", n));
        System.out.println(String.format("%.6f", z));
    }

    public void staircase(int n) {
        for (int i = n - 1; i >= 0; i--) {
            StringBuilder sb = new StringBuilder();
            int j = 0;
            while (j < i) {
                sb.append(" ");
                j++;
            }
            while (j < n) {
                sb.append("#");
                j++;
            }
            System.out.println(sb.toString());
        }
    }
}
