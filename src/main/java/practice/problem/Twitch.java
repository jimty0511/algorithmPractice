package practice.problem;

import java.util.*;

public class Twitch {
    public String dayOfTheWeek(String S, int K) {
        // write your code in Java SE 8
        String[] date = new String[]{"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
        int start = -1;
        for (int i = 0; i < 7; i++) {
            if (S.equals(date[i])) {
                start = i;
                break;
            }
        }
        if (start == -1)
            return "Wrong input";
        int idx = (start + K) % 7;
        return date[idx];
    }

    public String battleship(int N, String S, String T) {
        // write your code in Java SE 8
        int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        char[][] matrix = new char[N][N];
        for (char[] row : matrix)
            Arrays.fill(row, '.');
        String[] strs = S.split(",");
        int totalShips = strs.length, sunken = 0, damaged = 0;
        String[] hits = T.split(" ");
        for (String ship : strs) {
            String[] coordinates = ship.split(" ");
            int top = coordinates[0].charAt(0) - '1';
            int left = coordinates[0].charAt(1) - 'A';
            int bottom = coordinates[1].charAt(0) - '1';
            int right = coordinates[1].charAt(1) - 'A';
            while (left <= right) {
                matrix[top][left] = 'O';
                matrix[bottom][left] = 'O';
                left++;
            }
            while (top <= bottom) {
                matrix[top][right] = 'O';
                matrix[top][right] = 'O';
                top++;
            }
        }
        for (String hit : hits) {
            int i = hit.charAt(0) - '1';
            int j = hit.charAt(1) - 'A';
            matrix[i][j] = 'X';
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (matrix[i][j] == 'O') {
                    for (int[] d : dirs) {
                        int x = i + d[0], y = j + d[1];
                        if (x < 0 || x >= N || y < 0 || y >= N)
                            continue;
                        if (matrix[x][y] == 'X') ;
                    }
                }
            }
        }
        return sunken + "," + damaged;
    }

    public String battleshipTwo(int N, String S, String T) {
        // write your code in Java SE 8
        String[] strs = S.split(",");
        int sunken = 0, damaged = 0;
        String[] hits = T.split(" ");
        List<Set<String>> ships = new ArrayList<>();
        Set<String> bombs = new HashSet<>();
        for (String ship : strs) {
            Set<String> shipCorordinates = new HashSet<>();
            String[] coordinates = ship.split(" ");
            int top = coordinates[0].charAt(0) - '1';
            int left = coordinates[0].charAt(1) - 'A';
            int bottom = coordinates[1].charAt(0) - '1';
            int right = coordinates[1].charAt(1) - 'A';
            while (left <= right) {
                shipCorordinates.add(top + "," + left);
                shipCorordinates.add(bottom + "," + left);
                left++;
            }
            while (top <= bottom) {
                shipCorordinates.add(top + "," + right);
                shipCorordinates.add(top + "," + right);
                top++;
            }
            ships.add(shipCorordinates);
        }
        for (String hit : hits) {
            int i = hit.charAt(0) - '1';
            int j = hit.charAt(1) - 'A';
            bombs.add(i + "," + j);
        }
        for (int i = 0; i < ships.size(); i++) {
            Set<String> ship = ships.get(i);
            int gotHit = 0;
            for (String coordinates : ship) {
                if (bombs.remove(coordinates))
                    gotHit++;
            }
            if (ship.size() == gotHit)
                sunken++;
            else if (gotHit > 0)
                damaged++;
        }
        return sunken + "," + damaged;
    }
}
