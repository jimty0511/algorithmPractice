package practice.problem;

// 1185. Day of the Week
public class DayOfTheWeek {
    public String dayOfTheWeek(int day, int month, int year) {
        String[] week = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        int[] daysOfMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int total = 0;
        for (int i = 1971; i < year; i++) {
            if (i % 4 == 0)
                total += 366;
            else
                total += 365;
        }
        if (year % 4 == 0)
            daysOfMonth[1] = 29;
        for (int i = 0; i < month - 1; i++)
            total += daysOfMonth[i];
        total += day - 1;
        return week[(total + 5) % 7];
    }
}
