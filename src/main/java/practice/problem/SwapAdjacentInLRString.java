package practice.problem;

// 777. Swap Adjacent in LR String
public class SwapAdjacentInLRString {
    public boolean canTransform(String start, String end) {
        if (!start.replaceAll("X", "").equals(end.replace("X", "")))
            return false;
        int p1 = 0, p2 = 0;
        while (p1 < start.length() && p2 < end.length()) {
            while (p1 < start.length() && start.charAt(p1) == 'X')
                p1++;
            while (p2 < end.length() && end.charAt(p2) == 'X')
                p2++;
            if (p1 == start.length() && p2 == end.length())
                return true;
            if (p1 == start.length() || p2 == end.length())
                return false;
            if (start.charAt(p1) != end.charAt(p2))
                return false;
            if (start.charAt(p1) == 'L' && p2 > p1)
                return false;
            if (start.charAt(p1) == 'R' && p2 < p1)
                return false;
            p1++;
            p2++;
        }
        return true;
    }
}
