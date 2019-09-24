package practice.problem;

import java.util.*;

// 444. Sequence Reconstruction
public class SequenceReconstruction {
    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> inDegree = new HashMap<>();
        for (List<Integer> seq : seqs) {
            for (int i = 0; i < seq.size(); i++) {
                graph.putIfAbsent(seq.get(i), new ArrayList<>());
                inDegree.putIfAbsent(seq.get(i), 0);
                if (i > 0) {
                    graph.get(seq.get(i - 1)).add(seq.get(i));
                    inDegree.put(seq.get(i), inDegree.get(seq.get(i)) + 1);
                }
            }
        }
        if (org.length != inDegree.size())
            return false;
        Queue<Integer> q = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : inDegree.entrySet()) {
            if (entry.getValue() == 0)
                q.add(entry.getKey());
        }
        int index = 0;
        while (!q.isEmpty()) {
            if (q.size() > 1)
                return false;
            int curr = q.poll();
            if (org[index++] != curr)
                return false;
            for (int nb : graph.get(curr)) {
                inDegree.put(nb, inDegree.get(nb) - 1);
                if (inDegree.get(nb) == 0)
                    q.add(nb);
            }
        }
        return index == org.length;
    }
}
