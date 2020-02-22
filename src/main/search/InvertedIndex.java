package main.search;

import java.util.*;

/**
 * @author wenzhuang
 * @date 2020/2/23 1:37 AM
 */
public class InvertedIndex {
    public Map<String, List<Integer>> invertedIndex(List<Document> docs) {
        // Write your code here
        Map<String, List<Integer>> map = new HashMap<>();
        if (docs == null || docs.size() == 0){
            return map;
        }
        for (Document doc : docs){
            int id = doc.id;
            String content = doc.content;
            StringTokenizer st = new StringTokenizer(content);
            while (st.hasMoreTokens()){
                String word = st.nextToken();
                if (!map.containsKey(word)){
                    map.put(word, new ArrayList<>());
                }
                List<Integer> list = map.get(word);
                if (list.size() > 0 && list.get(list.size() - 1) == id){
                    continue;
                }
                list.add(id);
            }

        }
        return map;
    }

}
