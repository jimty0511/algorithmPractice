package practice.problem;

import practice.domain.Employee;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// 690. Employee Importance
public class EmployeeImportance {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = employees.stream().collect(Collectors.toMap(e -> e.id, e -> e));
        return helper(map, id);
    }

    private int helper(Map<Integer, Employee> map, int id) {
        Employee employee = map.get(id);
        int ans = employee.importance;
        for (int subId : employee.getSubordinates()) {
            ans += helper(map, subId);
        }
        return ans;
    }
}
