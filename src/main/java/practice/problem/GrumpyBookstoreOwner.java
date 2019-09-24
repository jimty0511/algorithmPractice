package practice.problem;

// 1052. Grumpy Bookstore Owner
public class GrumpyBookstoreOwner {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int satisfy = 0, max = 0, notSatisfy = 0;
        for (int i = 0; i < grumpy.length; i++) {
            if (grumpy[i] == 0)
                satisfy += customers[i];
            else
                notSatisfy += customers[i];
            if (i >= X)
                notSatisfy -= grumpy[i - X] * customers[i - X];
            max = Math.max(notSatisfy, max);
        }
        return satisfy + max;
    }
}
