package practice.problem;

// 245. Shortest Word Distance III
public class ShortestWordDistanceIII {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int dist = Integer.MAX_VALUE, i1 = words.length, i2 = -words.length;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                i1 = i;
            }
            if (words[i].equals(word2)) {
                if (word1.equals(word2))
                    i1 = i2;
                i2 = i;
            }
            dist = Math.min(dist, Math.abs(i1 - i2));
        }
        return dist;
    }
}
