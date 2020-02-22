package main.search;

import java.util.*;

/**
 * @author wenzhuang
 * @date 2020/2/23 1:06 AM
 */
public class GoogleSuggestion {

    public static class Map {
        public void map(Document value,
                        OutputCollector<String, Pair> output) {
            // Write your code here
            // Output the results into output buffer.
            // Ps. output.collect(String key, Pair value);
            String content = value.content;
            int count = value.count;
            for (int i = 1; i <= content.length(); i++){
                String subContent = content.substring(0, i);
                output.collect(subContent, new Pair(content, count));
            }
        }
    }

    public static class Reduce {

        private Comparator<Pair> comparator = (x, y) -> (x.getCount() == y.getCount() ? y.getContent().compareTo(x.getContent()) : x.getCount() - y.getCount());

        public void setup() {
            // initialize your data structure here
        }

        public void reduce(String key, Iterator<Pair> values, OutputCollector<String, Pair> output) {
            // Write your code here
            // Output the results into output buffer.
            // Ps. output.collect(String key, Pair value);
            PriorityQueue<Pair> queue = new PriorityQueue<Pair>(comparator);

            while (values.hasNext()){
                Pair value = values.next();
                if (queue.size() >= 10){
                    if (comparator.compare(queue.peek(), value) < 0) {
                        queue.poll();
                        queue.offer(value);
                    }
                } else {
                    queue.offer(value);
                }
            }
            List<Pair> res = new ArrayList<>();
            while (!queue.isEmpty()){
                res.add(queue.poll());
            }
            for (int i = res.size() - 1; i >= 0; i--){
                output.collect(key, res.get(i));
            }
        }
    }
}

class Pair {
    private String content;
    private int count;

    Pair(String content, int count) {
        this.content = content;
        this.count = count;
    }
    public String getContent(){
 	 	 return this.content;
 	 }
 	public int getCount(){
    	 return this.count;
    }
}

class Document {
    public int count;
    public String content;
}

class OutputCollector<K, V> {
    // Adds a key/value pair to the output buffer
    public void collect(K key, V value) {

    }
}
