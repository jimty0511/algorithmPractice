package practice.googleContest;

public class YouCanGoYourOwnWay {
    public String solution(int n, String path) {
        StringBuilder sb = new StringBuilder();
        for (char c : path.toCharArray()) {
            if (c == 'E')
                sb.append('S');
            else
                sb.append('E');
        }
        return sb.toString();
    }
}
