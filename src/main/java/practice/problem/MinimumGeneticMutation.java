package practice.problem;

import java.util.*;

// 433. Minimum Genetic Mutation
public class MinimumGeneticMutation {
    public int minMutation(String start, String end, String[] bank) {
        if (start.equals(end))
            return 0;
        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));
        char[] charSet = new char[]{'A', 'C', 'G', 'T'};
        int level = 0;
//        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
//        visited.add(start);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                String curr = queue.poll();
                if (curr.equals(end))
                    return level;
                char[] currArray = curr.toCharArray();
                for (int i = 0; i < currArray.length; i++) {
                    char old = currArray[i];
                    for (char c : charSet) {
                        currArray[i] = c;
                        String next = new String(currArray);
//                        if (!visited.contains(next) && bankSet.contains(next)) {
//                            visited.add(next);
                        if (bankSet.contains(next)) {
                            queue.offer(next);
                            bankSet.remove(next);
                        }
                    }
                    currArray[i] = old;
                }
            }
            level++;
        }
        return -1;
    }

    public int minMutationBiDirection(String start, String end, String[] bank) {
        if (bank == null || bank.length == 0)
            return -1;
        Set<String> bankSet = new HashSet<>();
        for (String s : bank)
            bankSet.add(s);
        if (!bankSet.contains(end))
            return -1;

        char[] charSet = new char[]{'A', 'C', 'G', 'T'};
        Set<String> fwd = new HashSet<>(), bwd = new HashSet<>();
        fwd.add(start);
        bwd.add(end);

        int level = 0;
        while (!fwd.isEmpty() && !bwd.isEmpty()) {
            if (fwd.size() > bwd.size()) {
                Set<String> tempSet = fwd;
                fwd = bwd;
                bwd = tempSet;
            }
            Set<String> temp = new HashSet<>();
            for (String s : fwd) {
                char[] currChars = s.toCharArray();
                for (int i = 0; i < s.length(); i++) {
                    char old = currChars[i];
                    for (char c : charSet) {
                        if (c == old)
                            continue;
                        currChars[i] = c;
                        String newString = new String(currChars);
                        if (bwd.contains(newString))
                            return level + 1;
                        if (bankSet.contains(newString)) {
                            temp.add(newString);
                            bankSet.remove(newString);
                        }
                        currChars[i] = old;
                    }
                }
            }
            level++;
            fwd = temp;
        }
        return -1;
    }
}
