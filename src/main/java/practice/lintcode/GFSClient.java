package practice.lintcode;

import java.util.HashMap;
import java.util.Map;

// 566. GFS Client
public class GFSClient extends BaseGFSClient {

    private int size;
    private Map<String, Integer> chunkNum;

    /*
     * @param chunkSize: An integer
     */
    public GFSClient(int chunkSize) {
        // do intialization if necessary
        size = chunkSize;
        chunkNum = new HashMap<>();
    }

    /*
     * @param filename: a file name
     * @return: conetent of the file given from GFS
     */
    public String read(String filename) {
        // write your code here
        if (!chunkNum.containsKey(filename))
            return null;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chunkNum.get(filename); i++) {
            String subContent = readChunk(filename, i);
            if (subContent != null)
                sb.append(subContent);
        }
        return sb.toString();
    }

    /*
     * @param filename: a file name
     * @param content: a string
     * @return: nothing
     */
    public void write(String filename, String content) {
        // write your code here
        int len = content.length();
        int num = (len - 1) / size + 1;
        chunkNum.put(filename, num);
        for (int i = 0; i < num; i++) {
            int start = i * size;
            int end = i == num - 1 ? len : (i + 1) * size;
            String subContent = content.substring(start, end);
            writeChunk(filename, i, subContent);
        }
    }
}
