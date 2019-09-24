package practice.problem;

import java.util.Arrays;

// 179. Largest Number
public class LargestNumber {
    public String largestNumber(int[] nums) {
        String[] array = Arrays.stream(nums).mapToObj(String::valueOf).toArray(String[]::new);
        Arrays.sort(array, (String s1, String s2) -> (s2 + s1).compareTo(s1 + s2));
        return Arrays.stream(array).reduce((x, y) -> x.equals("0") ? y : x + y).get();
    }

    public String largestNumberTwo(int[] nums) {
        if (nums == null || nums.length == 0)
            return "";
        String[] array = new String[nums.length];
        for (int i = 0; i < nums.length; i++)
            array[i] = String.valueOf(nums[i]);
        Arrays.sort(array, (String s1, String s2) -> (s2 + s1).compareTo(s1 + s2));
        if (array[0].charAt(0) == '0')
            return "0";
        StringBuilder sb = new StringBuilder();
        for (String s : array)
            sb.append(s);
        return sb.toString();
    }
}
