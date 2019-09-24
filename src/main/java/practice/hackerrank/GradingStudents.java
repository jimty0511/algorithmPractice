package practice.hackerrank;

import java.util.List;
import java.util.stream.Collectors;

public class GradingStudents {
    public List<Integer> gradingStudents(List<Integer> grades) {
        // Write your code here
        List<Integer> res = grades.stream().map(g -> g < 38 ? g : g % 5 < 3 ? g : g + (5 - g % 5)).collect(Collectors.toList());
        return res;
    }
}
