package practice.domain;

import java.util.ArrayList;
import java.util.List;

// 855. Exam Room
public class ExamRoom {

    int N;
    List<Integer> list = new ArrayList<>();

    public ExamRoom(int N) {
        this.N = N;
    }

    public int seat() {
        if (list.size() == 0) {
            list.add(0);
            return 0;
        }
        int d = Math.max(list.get(0), N - 1 - list.get(list.size() - 1));
        for (int i = 0; i < list.size() - 1; i++) {
            d = Math.max(d, (list.get(i + 1) - list.get(i)) / 2);
        }
        if (list.get(0) == d) {
            list.add(0, 0);
            return 0;
        }
        for (int i = 0; i < list.size() - 1; i++) {
            if ((list.get(i + 1) - list.get(i)) / 2 == d) {
                list.add(i + 1, (list.get(i + 1) + list.get(i)) / 2);
                return list.get(i + 1);
            }
        }
        list.add(N - 1);
        return N - 1;
    }

    public void leave(int p) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == p)
                list.remove(i);
        }
    }
}
