package practice.domain;

// 307. Range Sum Query - Mutable
public class NumArrayII {

    /**
     * SegmentTreeNode way
     */
    class SegmentTreeNode {
        int start, end;
        SegmentTreeNode left, right;
        int sum;

        public SegmentTreeNode(int start, int end) {
            this.start = start;
            this.end = end;
            this.left = null;
            this.right = null;
            this.sum = 0;
        }
    }

    SegmentTreeNode root = null;

    public NumArrayII(int[] nums) {
        root = buildTree(nums, 0, nums.length - 1);
    }

    private SegmentTreeNode buildTree(int[] nums, int start, int end) {
        if (start > end)
            return null;
        else {
            SegmentTreeNode ret = new SegmentTreeNode(start, end);
            if (start == end) {
                ret.sum = nums[start];
            } else {
                int mid = start + (end - start) / 2;
                ret.left = buildTree(nums, start, mid);
                ret.right = buildTree(nums, mid + 1, end);
                ret.sum = ret.left.sum + ret.right.sum;
            }
            return ret;
        }
    }

    public void update(int i, int val) {
        update(root, i, val);
    }

    private void update(SegmentTreeNode root, int i, int val) {
        if (root.start == root.end) {
            root.sum = val;
        } else {
            int mid = root.start + (root.end - root.start) / 2;
            if (i <= mid) {
                update(root.left, i, val);
            } else {
                update(root.right, i, val);
            }
            root.sum = root.left.sum + root.right.sum;
        }
    }

    public int sumRange(int i, int j) {
        return sumRange(root, i, j);
    }

    private int sumRange(SegmentTreeNode root, int i, int j) {
        if (root.start == i && root.end == j)
            return root.sum;
        else {
            int mid = root.start + (root.end - root.start) / 2;
            if (j <= mid) {
                return sumRange(root.left, i, j);
            } else if (i >= mid + 1) {
                return sumRange(root.right, i, j);
            } else {
                return sumRange(root.left, i, mid) + sumRange(root.right, mid + 1, j);
            }
        }
    }

    /**
     * NumArrayI way
     */
//    int[] nums, sum;
//
//    public NumArrayII(int[] nums) {
//        if (nums == null || nums.length == 0)
//            return;
//        this.nums = nums;
//        this.sum = new int[nums.length + 1];
//        for (int i = 1; i <= nums.length; i++) {
//            sum[i] = sum[i - 1] + nums[i - 1];
//        }
//    }
//
//    public void update(int i, int val) {
//        for (int start = i + 1; start < sum.length; start++) {
//            sum[start] = sum[start] - nums[i] + val;
//        }
//        nums[i] = val;
//    }
//
//    public int sumRange(int i, int j) {
//        if (i == 0)
//            return sum[j];
//
//        return sum[j + 1] - sum[i];
//    }

    /**
     * BIT way
     */
//    int[] nums;
//    int[] BIT;
//    int n;
//
//    public NumArrayII(int[] nums) {
//        this.nums = nums;
//        n = nums.length;
//        BIT = new int[n + 1];
//        for (int i = 0; i < n; i++) {
//            init(i, nums[i]);
//        }
//    }
//
//    private void init(int i, int val) {
//        i++;
//        while (i <= n) {
//            BIT[i] += val;
//            i += (i & -i);
//        }
//    }
//
//    public void update(int i, int val) {
//        int diff = val - nums[i];
//        nums[i] = val;
//        init(i, diff);
//    }
//
//    public int sumRange(int i, int j) {
//        return getSum(j) - getSum(i - 1);
//    }
//
//    private int getSum(int i) {
//        int sum = 0;
//        i++;
//        while (i > 0) {
//            sum += BIT[i];
//            i -= (i & -i);
//        }
//        return sum;
//    }

}
