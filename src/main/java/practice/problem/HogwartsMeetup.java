package practice.problem;

import java.util.*;

public class HogwartsMeetup {
    class Wizard implements Comparable<Wizard> {

        int id;
        int cost;

        public Wizard(int v) {
            this.id = v;
            this.cost = Integer.MAX_VALUE;
        }

        @Override
        public int compareTo(Wizard that) {
            return this.cost - that.cost;
        }
    }

    public List<Integer> getShortestPathTwo(List<String> wizardsList) {
        List<List<Integer>> wizards = new ArrayList<>();
        for (int i = 0; i < wizardsList.size(); i++) {
            if (wizardsList.get(i).isEmpty()) {
                wizards.add(new ArrayList<>());
            } else {
                List<String> sub = Arrays.asList(wizardsList.get(i).split(" "));
                List<Integer> newSub = new ArrayList<>();
                for (int j = 0; j < sub.size(); j++)
                    newSub.add(Integer.parseInt(sub.get(j)));
                wizards.add(newSub);
            }
        }
        int n = wizards.size();
        int[] parents = new int[n];
        Map<Integer, Wizard> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            parents[i] = i;
            map.put(i, new Wizard(i));
        }
        map.get(0).cost = 0;
        PriorityQueue<Wizard> pq = new PriorityQueue<>();
        pq.offer(map.get(0));
        while (!pq.isEmpty()) {
            Wizard curr = pq.poll();
            List<Integer> neighbors = wizards.get(curr.id);
            for (int neighbor : neighbors) {
                Wizard next = map.get(neighbor);
                int weight;
                if (curr.id == 0) {
                    weight = 0;
                } else {
                    weight = (int) Math.pow(next.id - curr.id, 2);
                }
                if (curr.cost + weight < next.cost) {
                    parents[next.id] = curr.id;
                    pq.remove(next);
                    next.cost = curr.cost + weight;
                    pq.offer(next);
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        int t = wizards.size() - 1;
        if (t == parents[t])
            return Arrays.asList(0);
        while (t != 0) {
            res.add(t);
            t = parents[t];
        }
        res.add(0);
        Collections.reverse(res);
        return res;
    }

    public List<Integer> getShortestPath(List<String> wizards) {
        List<String> temp = new ArrayList<>();
        int target = wizards.size() - 1;
        List<List<Integer>> wizardList = new ArrayList<>();
        for (int i = 0; i < wizards.size(); i++) {
            if (i == 0 && wizards.get(i).isEmpty()) {
                return new ArrayList<>(Arrays.asList(0));
            }
            List<String> sub = Arrays.asList(wizards.get(i).split(" "));
            List<Integer> newSub = new ArrayList<>();
            for (int j = 0; j < sub.size(); j++)
                newSub.add(Integer.parseInt(sub.get(j)));
            wizardList.add(newSub);
        }
        for (Integer alreadyKnow : wizardList.get(0)) {
            Queue<String> queue = new LinkedList<>();
            Queue<Integer> currNumber = new LinkedList<>();
            boolean[] visited = new boolean[wizards.size()];
            visited[0] = true;
            queue.offer(String.valueOf(alreadyKnow) + ",");
            currNumber.offer(alreadyKnow);
            while (!queue.isEmpty()) {
                String curr = queue.poll();
                int currNum = currNumber.poll();
                if (currNum == target) {
                    temp.add(curr);
                    continue;
                }
                for (Integer neighbour : wizardList.get(currNum)) {
//                    if (neighbour < currNum)
//                        continue;
                    queue.offer(curr + String.valueOf(neighbour) + ",");
                    currNumber.offer(neighbour);
                }
            }
        }
        if (temp.size() == 0) {
            return new ArrayList<>(Arrays.asList(0));
        } else {
            List<Integer> res = new ArrayList<>();
            for (String str : temp) {
                List<String> strings = Arrays.asList(str.split(","));
                List<Integer> tempRes = new ArrayList<>();
                for (int i = 0; i < strings.size(); i++) {
                    tempRes.add(Integer.parseInt(strings.get(i)));
                }
                int sum = 0, min = Integer.MAX_VALUE;
                for (int i = 1; i < tempRes.size(); i++) {
                    sum += Math.pow(tempRes.get(i) - tempRes.get(i - 1), 2);
                }
                if (sum < min) {
                    res = tempRes;
                }
            }
            res.add(0, 0);
            return res;
        }
    }
}
