package practice.domain;

import java.util.ArrayList;
import java.util.List;

public class ImplementQueuewithFixedSizeofArrays {
    public class QueueWithFixedArray {

        private int fixedSize;
        private int count;
        private int head;
        private int tail;
        private List<Object> headList;
        private List<Object> tailList;

        public QueueWithFixedArray(int fixedSize) {
            this.fixedSize = fixedSize;
            this.count = 0;
            this.head = 0;
            this.tail = 0;
            this.headList = new ArrayList<>();
            this.tailList = headList;
        }

        public void offer(int num) {
            if (tail == fixedSize - 1) {
                List<Object> newList = new ArrayList<>();
                newList.add(num);
                tailList.add(newList);
                tailList = (List<Object>) tailList.get(tail);
                tail = 0;
            } else {
                tailList.add(num);
            }
            count++;
            tail++;
        }

        public Integer poll() {
            if (count == 0)
                return null;
            int num = (int) headList.get(head);
            head++;
            count--;
            if (head == fixedSize - 1) {
                List<Object> newList = (List<Object>) headList.get(head);
                headList.clear();
                headList = newList;
                head = 0;
            }
            return num;
        }

        public int size() {
            return count;
        }
    }
}
