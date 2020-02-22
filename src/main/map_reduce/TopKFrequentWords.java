package main.map_reduce;

/**
 * @author wenzhuang
 * @date 2020/2/16 8:59 PM
 */

import java.util.*;

public class TopKFrequentWords {

    public static class Map {
        public void map(String _, Document value,
                        OutputCollector<String, Integer> output) {
            // Write your code here
            // Output the results into output buffer.
            // Ps. output.collect(String key, int value);
            String content = value.content;
            StringTokenizer st = new StringTokenizer(content);
            while (st.hasMoreTokens()){
                String word = st.nextToken();
                output.collect(word, 1);
            }
        }
    }

    public static class Reduce {

        private PriorityQueue<WordCount> queue;
        private int k;

        private Comparator<WordCount> comparator = new Comparator<WordCount>(){
            public int compare(WordCount wc1, WordCount wc2){
                return wc1.count == wc2.count ? wc2.word.compareTo(wc1.word) : wc1.count - wc2.count;
            }
        };

        public void setup(int k) {
            // initialize your data structure here
            this.k = k;
            queue = new PriorityQueue<WordCount>(k, comparator);
        }

        public void reduce(String key, Iterator<Integer> values) {
            // Write your code here
            int count = 0;
            while (values.hasNext()){
                count += values.next();
            }
            WordCount wc = new WordCount(key, count);
            if (queue.size() == k) {
                if (comparator.compare(wc, queue.peek()) > 0) {
                    queue.poll();
                    queue.offer(wc);
                }
            } else {
                queue.offer(new WordCount(key, count));
            }
        }

        public void cleanup(OutputCollector<String, Integer> output) {
            // Output the top k pairs <word, times> into output buffer.
            // Ps. output.collect(String key, Integer value);
            List<WordCount> list = new ArrayList<>();
            while (!queue.isEmpty()){
                list.add(queue.poll());
            }
            for (int i = list.size() - 1; i >= 0; i--) {
                WordCount wc = list.get(i);
                output.collect(wc.word, wc.count);
            }
        }
    }

    static class WordCount{
        String word;
        int count;
        public WordCount(String word, int count){
            this.word = word;
            this.count = count;
        }
    }
}

class Document {
    public int id;
    public String content;
}

class OutputCollector<K, V> {
    // Adds a key/value pair to the output buffer
    public void collect(K key, V value) {

    }
}
