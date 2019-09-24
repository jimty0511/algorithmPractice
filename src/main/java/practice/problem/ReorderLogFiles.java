package practice.problem;

import java.util.Arrays;
import java.util.Comparator;

// 937. Reorder Log Files
public class ReorderLogFiles {
    public String[] reorderLogFiles(String[] logs) {
        Comparator<String> myComp = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                int s1space = s1.indexOf(' ');
                int s2space = s2.indexOf(' ');
                char s1as = s1.charAt(s1space + 1);
                char s2as = s2.charAt(s2space + 1);
                if (Character.isDigit(s1as)) {
                    if (Character.isDigit(s2as))
                        return 0;
                    else
                        return 1;
                }
                if (Character.isDigit(s2as))
                    return -1;
                int diff = s1.substring(s1space + 1).compareTo(s2.substring(s2space + 1));
                if (diff == 0)
                    return s1.substring(0, s1space).compareTo(s2.substring(0, s2space));
                return diff;
            }
        };
        Arrays.sort(logs, myComp);
        return logs;
    }

    public String[] reorderLogFilesTwo(String[] logs) {
        Arrays.sort(logs, (s1, s2) -> {
            String[] split1 = s1.split(" ", 2);
            String[] split2 = s2.split(" ", 2);
            boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
            boolean isDigit2 = Character.isDigit(split2[1].charAt(0));
            if (!isDigit1 && !isDigit2) {
                int comp = split1[1].compareTo(split2[1]);
                if (comp == 0)
                    return split1[0].compareTo(split2[0]);
                else
                    return comp;
            } else if (isDigit1 && isDigit2)
                return 0;
            else if (isDigit1 && !isDigit2)
                return 1;
            else
                return -1;
        });
        return logs;
    }
}
