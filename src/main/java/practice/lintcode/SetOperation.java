package practice.lintcode;

import java.util.HashSet;
import java.util.Set;

// 1471. Set Operation
public class SetOperation {
    /**
     * @param A: The set A
     * @param B: The set B
     * @return: Return the size of three sets
     */
    public int[] getAnswer(int[] A, int[] B) {
        // Write your code here
        Set<Integer> set = new HashSet<>();
        int intersection = 0, len = A.length;
        for (int a : A)
            set.add(a);
        for (int b : B) {
            if (!set.add(b))
                intersection++;
        }
        return new int[]{set.size(), intersection, len - intersection};
    }
}
