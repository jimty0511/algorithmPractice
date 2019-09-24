package practice.problem;

// 1138. Alphabet Board Path
public class AlphabetBoardPath {
    public String alphabetBoardPath(String target) {
        StringBuilder sb = new StringBuilder();
        int prex = 0, prey = 0;
        for (char c : target.toCharArray()) {
            int curx = (c - 'a') / 5, cury = (c - 'a') % 5;
            while (prex > curx) {
                prex--;
                sb.append("U");
            }
            while (prey < cury) {
                prey++;
                sb.append("R");
            }
            while (prey > cury) {
                prey--;
                sb.append("L");
            }
            while (prex < curx) {
                prex++;
                sb.append("D");
            }
            sb.append("!");
        }
        return sb.toString();
    }
}
