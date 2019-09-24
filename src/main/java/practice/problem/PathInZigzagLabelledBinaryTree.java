package practice.problem;

import java.util.LinkedList;
import java.util.List;

// 1104. Path In Zigzag Labelled Binary Tree
public class PathInZigzagLabelledBinaryTree {
    public List<Integer> pathInZigZagTree(int label) {
        List<Integer> res = new LinkedList<>();
        if (label <= 0)
            return res;
        int level = 0;
        while (Math.pow(2, level) - 1 < label)
            level++;
        level--;
        while (level != 0) {
            res.add(0, label);
            int pos = label - (int) Math.pow(2, level);
            label = label - (pos + 1) - pos / 2;
            level--;
        }
        res.add(0, 1);
        return res;
    }
}
