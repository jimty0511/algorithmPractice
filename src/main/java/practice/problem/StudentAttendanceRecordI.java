package practice.problem;

// 551. Student Attendance Record I
public class StudentAttendanceRecordI {
    public boolean checkRecord(String s) {
        if (s == null || s.length() == 0)
            return false;
        int countA = 0, countL = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'A') {
                countA++;
                countL = 0;
            } else if (c == 'L')
                countL++;
            else
                countL = 0;
            if (countA > 1 || countL > 2)
                return false;
        }
        return true;
    }

    public boolean checkRecordTwo(String s) {
        if (s.indexOf('A') != s.lastIndexOf('A') || s.contains("LLL"))
            return false;
        return true;
    }
}
