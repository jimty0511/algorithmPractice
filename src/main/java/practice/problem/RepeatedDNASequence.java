package practice.problem;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// 187. Repeated DNA Sequences
public class RepeatedDNASequence {
    public List<String> findRepeatedDnaSequences(String s) {
        Set seen = new HashSet(), repeated = new HashSet();
        for (int i = 0; i < s.length() - 9; i++) {
            String sub = s.substring(i, i + 10);
            if (!seen.add(sub))
                repeated.add(sub);
        }
        return new ArrayList<>(repeated);
    }
}
