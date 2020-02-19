package practice.lintcode;

// 143. Sort Colors II
public class SortColorsII {
    /**
     * @param colors: A list of integer
     * @param k:      An integer
     * @return: nothing
     */
    public void sortColors2(int[] colors, int k) {
        // write your code here
        if (colors == null || colors.length == 0)
            return;
        helper(colors, 0, colors.length - 1, 1, k);
    }

    private void helper(int[] colors, int left, int right, int colorStart, int colorEnd) {
        if (colorStart == colorEnd)
            return;
        if (left >= right)
            return;
        int colorMid = (colorStart + colorEnd) / 2;
        int l = left, r = right;
        while (l <= r) {
            while (l <= r && colors[l] <= colorMid)
                l++;
            while (l <= r && colors[r] > colorMid)
                r--;
            if (l <= r) {
                int tmp = colors[l];
                colors[l] = colors[r];
                colors[r] = tmp;
                l++;
                r--;
            }
        }
        helper(colors, left, r, colorStart, colorMid);
        helper(colors, l, right, colorMid + 1, colorEnd);
    }
}
