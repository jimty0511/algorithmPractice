package practice.lintcode;

// 474. Lowest Common Ancestor II
public class LowestCommonAncestorII {

    class ParentTreeNode {
        public ParentTreeNode parent, left, right;
    }

    /*
     * @param root: The root of the tree
     * @param A: node in the tree
     * @param B: node in the tree
     * @return: The lowest common ancestor of A and B
     */
    public ParentTreeNode lowestCommonAncestorII(ParentTreeNode root, ParentTreeNode A, ParentTreeNode B) {
        // write your code here
        ParentTreeNode a = A, b = B;
        while (a != b) {
            a = a.parent == null ? B : a.parent;
            b = b.parent == null ? A : b.parent;
        }
        return a;
    }
}
