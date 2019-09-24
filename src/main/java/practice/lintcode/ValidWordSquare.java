package practice.lintcode;

// 888. Valid Word Square
public class ValidWordSquare {
    public boolean validWordSquare(String[] words) {
        // Write your code here
        if (words.length != words[0].length())
            return false;
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                if (j >= words.length || i >= words[j].length() || words[i].charAt(j) != words[j].charAt(i))
                    return false;
            }
        }
        return true;
    }

    public boolean validWordSquareTwo(String[] words) {
        if (words.length != words[0].length())
            return false;
        char[][] chars = new char[words.length][words.length];
        for (int i = 0; i < words.length; i++)
            chars[i] = words[i].toCharArray();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (chars[i][j] != chars[j][i])
                    return false;
            }
        }
        return true;
    }
}
