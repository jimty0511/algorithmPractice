package practice.problem;

// 299. Bulls and Cows
public class BullsAndCows {
    public String getHint(String secret, String guess) {
        int bulls = 0, cows = 0;
        int[] nums = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i))
                bulls++;
            else {
                if (nums[secret.charAt(i) - '0']++ < 0)
                    cows++;
                if (nums[guess.charAt(i) - '0']-- > 0)
                    cows++;
            }
        }
        return bulls + "A" + cows + "B";
    }

    public String getHintTwo(String secret, String guess) {
        int bulls = 0, cows = 0;
        int[] nums = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            int s = Character.getNumericValue(secret.charAt(i));
            int g = Character.getNumericValue(guess.charAt(i));
            if (s == g)
                bulls++;
            else {
                if (nums[s] < 0)
                    cows++;
                if (nums[g] > 0)
                    cows++;
                nums[s]++;
                nums[g]--;
            }
        }
        return bulls + "A" + cows + "B";
    }
}
