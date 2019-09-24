package practice.problem;

import java.util.ArrayList;
import java.util.List;

// 68. Text Justification
public class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> lines = new ArrayList<>();
        int index = 0;
        while (index < words.length) {
            int count = words[index].length();
            int last = index + 1;
            while (last < words.length) {
                if (words[last].length() + count + 1 > maxWidth)
                    break;
                count += 1 + words[last].length();
                last++;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(words[index]);
            int diff = last - index - 1;
            if (last == words.length || diff == 0) {
                for (int i = index + 1; i < last; i++) {
                    sb.append(" ").append(words[i]);
                }
                for (int i = sb.length(); i < maxWidth; i++) {
                    sb.append(" ");
                }
            } else {
                int spaces = (maxWidth - count) / diff;
                int extra = (maxWidth - count) % diff;
                for (int i = index + 1; i < last; i++) {
                    for (int k = spaces; k >= 0; k--) {
                        sb.append(" ");
                    }
                    if (extra > 0) {
                        sb.append(" ");
                        extra--;
                    }
                    sb.append(words[i]);
                }
            }
            lines.add(sb.toString());
            index = last;
        }
        return lines;
    }
}
