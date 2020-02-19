package practice.lintcode;

// 207. Interval Sum II
public class IntervalSumII {
    /* you may need to use some attributes here */
    class SegmentTreeNode {
        int start, end, sum;
        SegmentTreeNode left, right;

        public SegmentTreeNode(int start, int end) {
            this.start = start;
            this.end = end;
            this.sum = 0;
            this.left = null;
            this.right = null;
        }
    }

    SegmentTreeNode root = null;

    /*
     * @param A: An integer array
     */
    public IntervalSumII(int[] A) {
        // do intialization if necessary
        root = buildTree(A, 0, A.length - 1);
    }

    private SegmentTreeNode buildTree(int[] A, int start, int end) {
        if (start > end)
            return null;
        else {
            SegmentTreeNode node = new SegmentTreeNode(start, end);
            if (start == end)
                node.sum = A[start];
            else {
                int mid = (start + end) / 2;
                node.left = buildTree(A, start, mid);
                node.right = buildTree(A, mid + 1, end);
                node.sum = node.left.sum + node.right.sum;
            }
            return node;
        }
    }

    /*
     * @param start: An integer
     * @param end: An integer
     * @return: The sum from start to end
     */
    public long query(int start, int end) {
        // write your code here
        return getSum(root, start, end);
    }

    private int getSum(SegmentTreeNode root, int start, int end) {
        if (root.start == start && root.end == end)
            return root.sum;
        else {
            int mid = (root.start + root.end) / 2;
            if (end <= mid)
                return getSum(root.left, start, end);
            else if (start >= mid + 1)
                return getSum(root.right, start, end);
            else
                return getSum(root.left, start, mid) + getSum(root.right, mid + 1, end);
        }
    }

    /*
     * @param index: An integer
     * @param value: An integer
     * @return: nothing
     */
    public void modify(int index, int value) {
        // write your code here
        update(root, index, value);
    }

    private void update(SegmentTreeNode root, int idx, int val) {
        if (root.start == root.end)
            root.sum = val;
        else {
            int mid = (root.start + root.end) / 2;
            if (idx <= mid)
                update(root.left, idx, val);
            else
                update(root.right, idx, val);
            root.sum = root.left.sum + root.right.sum;
        }
    }
}
