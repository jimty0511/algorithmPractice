package practice.problem;

import java.util.*;

// 588. Design In-Memory File System
public class DesignInMemoryFileSystem {

    class File {
        boolean isFile = false;
        Map<String, File> files = new HashMap<>();
        String content = "";
    }

    File root;

    public DesignInMemoryFileSystem() {
        root = new File();
    }

    public List<String> ls(String path) {
        File cur = root;
        List<String> files = new ArrayList<>();
        if (!path.equals("/")) {
            String[] dir = path.split("/");
            for (int i = 1; i < dir.length; i++)
                cur = cur.files.get(dir[i]);
            if (cur.isFile) {
                files.add(dir[dir.length - 1]);
                return files;
            }
        }
        List<String> res = new ArrayList<>(cur.files.keySet());
        Collections.sort(res);
        return res;
    }

    public void mkdir(String path) {
        File cur = root;
        String[] dir = path.split("/");
        for (int i = 1; i < dir.length; i++) {
            if (!cur.files.containsKey(dir[i]))
                cur.files.put(dir[i], new File());
            cur = cur.files.get(dir[i]);
        }
    }

    public void addContentToFile(String filePath, String content) {
        File cur = root;
        String[] dir = filePath.split("/");
        for (int i = 1; i < dir.length - 1; i++) {
            cur = cur.files.get(dir[i]);
        }
        if (!cur.files.containsKey(dir[dir.length - 1])) {
            cur.files.put(dir[dir.length - 1], new File());
        }
        cur = cur.files.get(dir[dir.length - 1]);
        cur.isFile = true;
        cur.content = cur.content + content;
    }

    public String readContentFromFile(String filePath) {
        File cur = root;
        String[] dir = filePath.split("/");
        for (int i = 1; i < dir.length - 1; i++) {
            cur = cur.files.get(dir[i]);
        }
        return cur.files.get(dir[dir.length - 1]).content;
    }
}
