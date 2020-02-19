package practice.problem;

// 69. Sqrt(x)
public class SqrtX {
    public int mySqrt(int x) {
//        if (x == 0)
//            return 0;
//        int start = 1, end = x;
//        while (start < end) {
//            int mid = start + (end - start) / 2;
//            if (mid <= x / mid && (mid + 1) > x / (mid + 1))
//                return mid;
//            else if (mid > x / mid)
//                end = mid;
//            else
//                start = mid + 1;
//        }
//        return start;

        if (x == 0)
            return 0;
        int s = 1, e = x;
        while (s <= e) {
            int m = s + (e - s) / 2;
            if (m <= x / m && (m + 1) > x / (m + 1))
                return m;
            else if (m > x / m)
                e = m;
            else
                s = m;
        }
        return s;
    }
}
