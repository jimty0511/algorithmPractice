package practice.lintcode;

// 203. Segment Tree Modify
public class SegmentTreeModify {

    public class SegmentTreeNode {
        public int start, end, max;
        public SegmentTreeNode left, right;

        public SegmentTreeNode(int start, int end, int max) {
            this.start = start;
            this.end = end;
            this.max = max;
            this.left = this.right = null;
        }
    }

    public void modify(SegmentTreeNode root, int index, int value) {
        // write your code here
        if (root.start == index && root.end == index) {
            root.max = value;
            return;
        }
        int mid = (root.start + root.end) / 2;
        if (root.start <= index && index <= mid)
            modify(root.left, index, value);
        if (mid < index && index <= root.end)
            modify(root.right, index, value);
        root.max = Math.max(root.left.max, root.right.max);
    }
}
