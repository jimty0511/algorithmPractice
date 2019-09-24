package practice.problem;

import java.util.List;

// 547. Friend Circles
public class FriendCircles {
    public int findCircleNum(int[][] M) {
        boolean[] visited = new boolean[M.length];
        int count = 0;
        for (int i = 0; i < M.length; i++) {
            if (!visited[i]) {
                helper(M, visited, i);
                count++;
            }
        }
        return count;
    }

    private void helper(int[][] M, boolean[] visited, int person) {
        for (int other = 0; other < M.length; other++) {
            if (M[person][other] == 1 && !visited[other]) {
                visited[other] = true;
                helper(M, visited, other);
            }
        }
    }

    public int findCircleNumUf(int[][] M) {
        int count = M.length;
        int[] root = new int[count];
        for (int i = 0; i < count; i++) {
            root[i] = i;
        }
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[0].length; j++) {
                if (M[i][j] == 1) {
                    int rooti = find(root, i);
                    int rootj = find(root, j);
                    if (rooti != rootj) {
                        count--;
                        root[rooti] = rootj;
                    }
                }
            }
        }
        return count;
    }

    private int find(int[] root, int i) {
        while (i != root[i]) {
            i = root[i];
        }
        return i;
    }

    public int friendCircles(List<String> friends) {
        int len = friends.size();
        boolean[] visited = new boolean[len];
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (!visited[i]) {
                helper(friends, visited, i);
                count++;
            }
        }
        return count;
    }

    private void helper(List<String> friends, boolean[] visited, int person) {
        for (int other = 0; other < friends.size(); other++) {
            if (friends.get(person).charAt(other) == 'Y' && !visited[other]) {
                visited[other] = true;
                helper(friends, visited, other);
            }
        }
    }
}
