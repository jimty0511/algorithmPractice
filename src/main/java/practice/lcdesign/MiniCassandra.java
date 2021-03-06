package practice.lcdesign;

import java.util.*;

// 502. Mini Cassandra
// Chapter 2
public class MiniCassandra {

    public class Column {
        public int key;
        public String value;

        public Column(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    private Map<String, TreeMap<Integer, String>> map;

    public MiniCassandra() {
        // do intialization if necessary
        map = new HashMap<>();
    }

    /*
     * @param raw_key: a string
     * @param column_key: An integer
     * @param column_value: a string
     * @return: nothing
     */
    public void insert(String row_key, int column_key, String value) {
        // write your code here
        map.putIfAbsent(row_key, new TreeMap<>());
        map.get(row_key).put(column_key, value);
    }

    /*
     * @param row_key: a string
     * @param column_start: An integer
     * @param column_end: An integer
     * @return: a list of Columns
     */
    public List<Column> query(String row_key, int column_start, int column_end) {
        // write your code here
        List<Column> res = new ArrayList<>();
        if (!map.containsKey(row_key))
            return res;
        for (Map.Entry<Integer, String> entry : map.get(row_key).subMap(column_start, true, column_end, true).entrySet()) {
            res.add(new Column(entry.getKey(), entry.getValue()));
        }
        return res;
    }
}
