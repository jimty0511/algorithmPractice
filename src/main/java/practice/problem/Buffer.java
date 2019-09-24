package practice.problem;

public class Buffer {

    int size;
    int start;
    int end;
    char[] bf;
    int cap;

    public Buffer(int capacity) {
        bf = new char[capacity];
        size = 0;
        start = 0;
        end = 0;
        cap = capacity;
    }

    public int write(char[] src) {
        int i = 0;
        for (; i < src.length; i++) {
            bf[end++] = src[i];
            size++;
            end = end % cap;
            if (size >= cap)
                break;
        }
        return i;
    }

    public char[] read(int n) {
        int rl = n;
        if (n > size)
            rl = size;
        char[] res = new char[rl];
        for (int i = 0; i < rl; i++) {
            res[i] = bf[start++];
            size--;
            start = start % cap;
        }
        return res;
    }
}
