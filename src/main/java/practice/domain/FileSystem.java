package practice.domain;

import java.util.HashMap;
import java.util.Map;

public class FileSystem {
    private Map<String, Integer> pathMap;

    public FileSystem() {
        pathMap = new HashMap<>();
    }

    public boolean create(String path, int value) {
        if (pathMap.containsKey(path))
            return false;
        int lastIndex = path.lastIndexOf("/");
        if (!pathMap.containsKey(path.substring(0, lastIndex)))
            return false;
        pathMap.put(path, value);
        return true;
    }

    public boolean set(String path, int value) {
        if (!pathMap.containsKey(path))
            return false;
        pathMap.put(path, value);
        return true;
    }

    public Integer get(String path) {
        return pathMap.get(path);
    }
}
