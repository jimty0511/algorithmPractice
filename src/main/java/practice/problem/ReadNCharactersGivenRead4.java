package practice.problem;

// 157. Read N Characters Given Read4
public class ReadNCharactersGivenRead4 {

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

    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return The number of actual characters read
     */
    public int read(char[] buf, int n) {
        char[] buffer = new char[4];
        boolean endOfFile = false;
        int readBtyes = 0;
        while (readBtyes < n && !endOfFile) {
            int cur = read4(buffer);
            if (cur != 4)
                endOfFile = true;
            int len = Math.min(n - readBtyes, cur);
            for (int i = 0; i < len; i++) {
                buf[readBtyes + i] = buffer[i];
            }
            readBtyes += len;
        }
        return readBtyes;
    }
}
