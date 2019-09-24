package practice.problem;

// 158. Read N Characters Given Read4 II - Call multiple times
public class ReadNCharactersGivenRead4II {
    char[] example = new char[]{'a', 'b', 'c', 'd', 'A', 'B', 'C', 'D', '1', '2', '3', '4', '5'};
    int idx = 0;

    int read4(char[] buf) {
        int cnt = 0;
        for (int i = idx, j = 0; i < example.length && j < 4; i++, j++) {
            buf[j] = example[i];
            cnt++;
            idx++;
        }
        return cnt;
    }

    private int bufPointer = 0;
    private int bufCnt = 0;
    private char[] buffer = new char[4];

    public int read(char[] buf, int n) {
        int pointer = 0;
        while (pointer < n) {
            if (bufPointer == 0)
                bufCnt = read4(buffer);
            if (bufCnt == 0)
                break;
            while (pointer < n && bufPointer < bufCnt)
                buf[pointer++] = buffer[bufPointer++];
            if (bufPointer >= bufCnt)
                bufPointer = 0;
        }
        return pointer;
    }
}
