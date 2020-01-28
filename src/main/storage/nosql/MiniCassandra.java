package main.storage.nosql;

import java.util.*;

/**
 * @author wenzhuang
 * @date 2020/1/27 4:46 PM
 */
public class MiniCassandra {
    private Map<String, TreeMap<Integer, String>> map = new HashMap<>();

    public MiniCassandra() {
        // do intialization if necessary
    }

    /*
     * @param raw_key: a string
     * @param column_key: An integer
     * @param column_value: a string
     * @return: nothing
     */
    public void insert(String row_key, int column_key, String value) {
        // write your code here
        if (!map.containsKey(row_key)){
            map.put(row_key, new TreeMap<Integer, String>());
        }
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
        if (!map.containsKey(row_key)){
            return res;
        }
        Map<Integer, String> data = map.get(row_key).subMap(column_start, true, column_end, true);
        for (Map.Entry<Integer, String> entry : data.entrySet()){
            Column column = new Column(entry.getKey(), entry.getValue());
            res.add(column);
        }
        return res;
    }
}


class Column {
    public int key;
    public String value;
    public Column(int key, String value) {
        this.key = key;
        this.value = value;
    }
 }
