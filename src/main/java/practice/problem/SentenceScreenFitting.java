package practice.problem;

// 418. Sentence Screen Fitting
public class SentenceScreenFitting {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        String s = String.join(" ", sentence) + " ";
        int start = 0, l = s.length();
        for (int i = 0; i < rows; i++) {
            start += cols;
            if (s.charAt(start % l) == ' ') {
                start++;
            } else {
                while (start > 0 && s.charAt((start - 1) % l) != ' ') {
                    start--;
                }
            }
        }
        return start / l;
    }

//    public int wordsTypingTwo(String[] sentence, int rows, int cols) {
//    }
}
