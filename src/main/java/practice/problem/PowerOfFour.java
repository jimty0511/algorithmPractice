package practice.problem;

// 342. Power of Four
public class PowerOfFour {
    public boolean isPowerOfFour(int num) {
        return num > 0 && (num & (num - 1)) == 0 && num % 3 == 1;
//        return num > 0 && (num & (num - 1)) == 0 && (num-1) % 3 == 1;
    }
}
