package practice.problem;

// 806. Number of Lines To Write String
public class NumberOfLinesToWriteString {
    public int[] numberOfLines(int[] widths, String S) {
        int total = 1, cur = 0;
        for (char c : S.toCharArray()) {
            int width = widths[c - 'a'];
            total = cur + width > 100 ? total + 1 : total;
            cur = cur + width > 100 ? width : cur + width;
        }
        return new int[]{total, cur};
    }
}
