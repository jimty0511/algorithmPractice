package practice.problem;

import practice.domain.TreeNode;

// 968. Binary Tree Cameras
public class BinaryTreeCameras {
    private int NOT_MONITORED = 0;
    private int MONITORED_NO_CAM = 1;
    private int MONITORED_WITH_CAM = 2;
    private int cameras = 0;

    public int minCameraCover(TreeNode root) {
        if (root == null)
            return 0;
        int top = dfs(root);
        return cameras + (top == NOT_MONITORED ? 1 : 0);
    }

    private int dfs(TreeNode root) {
        if (root == null)
            return MONITORED_NO_CAM;
        int left = dfs(root.left);
        int right = dfs(root.right);
        if (left == MONITORED_NO_CAM && right == MONITORED_NO_CAM) {
            return NOT_MONITORED;
        } else if (left == NOT_MONITORED || right == NOT_MONITORED) {
            cameras++;
            return MONITORED_WITH_CAM;
        } else {
            return MONITORED_NO_CAM;
        }
    }
}
