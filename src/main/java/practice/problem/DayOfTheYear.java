package practice.problem;

// 1154. Day of the Year
public class DayOfTheYear {
    public int dayOfYear(String date) {
        String[] strs = date.split("-");
        int year = Integer.parseInt(strs[0]);
        int month = Integer.parseInt(strs[1]);
        int day = Integer.parseInt(strs[2]);
        int feb = 28 + (isLeap(year) ? 1 : 0);
        int res = 0;
        int[] days = {31, feb, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        for (int i = 0; i < month - 1; i++)
            res += days[i];
        return res + day;
    }

    private boolean isLeap(int year) {
        if ((year % 4 == 0) && (year % 100 != 0))
            return true;
        return false;
    }
}
