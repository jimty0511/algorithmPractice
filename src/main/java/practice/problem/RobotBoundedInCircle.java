package practice.problem;

// 1041. Robot Bounded In Circle
public class RobotBoundedInCircle {
    public boolean isRobotBounded(String instructions) {
        int x = 0, y = 0, i = 0;
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for (char c : instructions.toCharArray()) {
            if (c == 'R')
                i = (i + 1) % 4;
            else if (c == 'L')
                i = (i + 3) % 4;
            else {
                x += dirs[i][0];
                y += dirs[i][1];
            }
        }
        return x == 0 && y == 0 || i > 0;
    }
}
