package practice.problem;

import java.util.*;

// 721. Accounts Merge
public class AccountMerge {
    public List<List<String>> accountsMergeDfs(List<List<String>> accounts) {
        Map<String, Set<String>> graph = new HashMap<>();
        Map<String, String> name = new HashMap<>();
        for (List<String> ac : accounts) {
            String userName = ac.get(0);
            for (int i = 1; i < ac.size(); i++) {
                if (!graph.containsKey(ac.get(i))) {
                    graph.put(ac.get(i), new HashSet<>());
                }
                name.put(ac.get(i), userName);
                if (i == 1)
                    continue;
                graph.get(ac.get(i)).add(ac.get(i - 1));
                graph.get(ac.get(i - 1)).add(ac.get(i));
            }
        }
        Set<String> visited = new HashSet<>();
        List<List<String>> res = new ArrayList<>();
        for (String email : name.keySet()) {
            List<String> list = new LinkedList<>();
            if (visited.add(email)) {
                dfs(graph, email, visited, list);
                Collections.sort(list);
                list.add(0, name.get(email));
                res.add(list);
            }
        }
        return res;
    }

    private void dfs(Map<String, Set<String>> graph, String email, Set<String> visited, List<String> list) {
        list.add(email);
        for (String next : graph.get(email)) {
            if (visited.add(next)) {
                dfs(graph, next, visited, list);
            }
        }
    }

    public List<List<String>> accountsMergeUf(List<List<String>> accounts) {
        Map<String, String> owner = new HashMap<>();
        Map<String, String> parents = new HashMap<>();
        Map<String, TreeSet<String>> unions = new HashMap<>();
        for (List<String> ac : accounts) {
            for (int i = 1; i < ac.size(); i++) {
                parents.put(ac.get(i), ac.get(i));
                owner.put(ac.get(i), ac.get(0));
            }
        }
        for (List<String> ac : accounts) {
            String p = find(ac.get(1), parents);
            for (int i = 2; i < ac.size(); i++) {
                parents.put(find(ac.get(i), parents), p);
            }
        }
        for (List<String> ac : accounts) {
            String p = find(ac.get(1), parents);
            if (!unions.containsKey(p))
                unions.put(p, new TreeSet<>());
            for (int i = 1; i < ac.size(); i++)
                unions.get(p).add(ac.get(i));
        }
        List<List<String>> res = new ArrayList<>();
        for (String p : unions.keySet()) {
            List<String> emails = new ArrayList<>(unions.get(p));
            emails.add(0, owner.get(p));
            res.add(emails);
        }
        return res;
    }

    private String find(String s, Map<String, String> parents) {
        if (parents.get(s) == s)
            return s;
        else
            return find(parents.get(s), parents);
//        return parents.get(s) == s ? s : find(parents.get(s), parents);
    }
}
