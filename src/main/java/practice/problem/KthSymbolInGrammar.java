package practice.problem;

// 779. K-th Symbol in Grammar
public class KthSymbolInGrammar {
    public int kthGrammar(int N, int K) {
        return Integer.bitCount(K - 1) & 1;
    }

    public int kthGrammarTwo(int N, int K) {
        int res = 0;
        while (K > 1) {
            K = K % 2 == 1 ? K + 1 : K / 2;
            res ^= 1;
        }
        return res;
    }
}
