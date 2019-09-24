package practice.lintcode;

// 202. Segment Tree Query
public class SegmentTreeQuery {

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

    public int query(SegmentTreeNode root, int start, int end) {
        // write your code here
        if (root.start == start && root.end == end)
            return root.max;
        int mid = (root.start + root.end) / 2;
        if (end <= mid)
            return query(root.left, start, end);
        else if (start >= mid + 1)
            return query(root.right, start, end);
        else {
            int left = query(root.left, start, mid);
            int right = query(root.right, mid + 1, end);
            return Math.max(left, right);
        }
    }
}
