package practice.problem;

// 1103. Distribute Candies to People
public class DistributeCandiesToPeople {
    public int[] distributeCandies(int candies, int num_people) {
        int[] res = new int[num_people];
        for (int give = 0; candies > 0; candies -= give) {
            res[give % num_people] += Math.min(++give, candies);
        }
        return res;
    }
}
