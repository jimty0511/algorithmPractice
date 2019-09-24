package practice.problem;

import java.util.*;

// 609. Find Duplicate File in System
public class FindDuplicateFileInSystem {
    public List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> res = new ArrayList<>();
        if (paths == null || paths.length == 0)
            return res;
        int n = paths.length;
        Map<String, Set<String>> map = new HashMap<>();
        for (String path : paths) {
            String[] strs = path.split("\\s+");
            for (int i = 1; i < strs.length; i++) {
                int idx = strs[i].indexOf("(");
                String content = strs[i].substring(idx);
                String fileName = strs[0] + "/" + strs[i].substring(0, idx);
                Set<String> fileNames = map.getOrDefault(content, new HashSet<>());
                fileNames.add(fileName);
                map.put(content, fileNames);
            }
        }
        for (String key : map.keySet()) {
            if (map.get(key).size() > 1)
                res.add(new ArrayList<>(map.get(key)));
        }
        return res;
    }
}
