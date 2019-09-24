package practice.lintcode;

// 439. Segment Tree Build II
public class SegmentTreeBuildII {

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

    public SegmentTreeNode build(int[] A) {
        // write your code here
        return helper(A, 0, A.length - 1);
    }

    private SegmentTreeNode helper(int[] A, int start, int end) {
        if (start > end)
            return null;
        if (start == end)
            return new SegmentTreeNode(start, end, A[start]);
        else {
            SegmentTreeNode root = new SegmentTreeNode(start, end, A[start]);
            int mid = (start + end) / 2;
            root.left = helper(A, start, mid);
            root.right = helper(A, mid + 1, end);
            if (root.left != null && root.left.max > root.max)
                root.max = root.left.max;
            if (root.right != null && root.right.max > root.max)
                root.max = root.right.max;
            return root;
        }
    }
}
