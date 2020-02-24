package main.search;

import java.util.*;

/**
 * @author wenzhuang
 * @date 2020/2/25 12:57 AM
 */
public class Typeahead {
    private Map<String, List<String>> map = new HashMap<>();
    /*
     * @param dict: A dictionary of words dict
     */
    public Typeahead(Set<String> dict) {
        // do intialization if necessary
        for (String word : dict){
            for (int i = 0; i < word.length(); i++){
                for (int j = i + 1; j <= word.length(); j++){
                    String subStr = word.substring(i, j);
                    List<String> wordList = map.get(subStr);
                    if (wordList == null){
                        map.put(subStr, new ArrayList<>());
                        map.get(subStr).add(word);
                    } else {
                        if (!wordList.get(wordList.size() - 1).equals(word)){
                            wordList.add(word);
                        }
                    }
                }
            }
        }
    }

    /*
     * @param str: a string
     * @return: a list of words
     */
    public List<String> search(String str) {
        // write your code here
        return map.get(str) == null ? new ArrayList<String>() : map.get(str);
    }
}
