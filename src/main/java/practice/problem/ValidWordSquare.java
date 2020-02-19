package practice.problem;

import java.util.List;

// 422. Valid Word Square
public class ValidWordSquare {
    public boolean validWordSquare(List<String> words) {
        if (words == null || words.size() == 0)
            return true;
        int m = words.size();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < words.get(i).length(); j++) {
                if (j >= m || words.get(j).length() <= i || words.get(i).charAt(j) != words.get(j).charAt(i))
                    return false;
            }
        }
        return true;
    }
}
