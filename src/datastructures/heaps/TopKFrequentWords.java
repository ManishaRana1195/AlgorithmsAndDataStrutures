package datastructures.heaps;

import java.util.*;
import java.util.PriorityQueue;

public class TopKFrequentWords {

    public static void main(String[] args) {
        int k = 2;
        String[] words = {"i", "love", "leetcode", "i", "love", "coding", "leetcode"};
        List<String> uniqueWords = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            Integer count = map.getOrDefault(word, 0);
            if (count == 0) {
                uniqueWords.add(word);
            }
            map.put(word, count + 1);
        }

        PriorityQueue<Word> minHeap = new PriorityQueue<>((o1, o2) -> o1.frequency == o2.frequency ? o1.value.compareTo(o2.value) : o2.frequency - o1.frequency);

        int size = uniqueWords.size();
        for (int i = 0; i < size; i++) {
            String currentWord = uniqueWords.get(i);
            Integer count = map.get(currentWord);
            minHeap.add(new Word(currentWord, count));
        }

        List<String> result = new ArrayList<>();

        while (k > 0) {
            String top = minHeap.poll().value;
            result.add(top);
            k--;
            System.out.println(top);
        }

    }
}

class Word {
    String value;
    int frequency;

    public Word(String value, int frequency) {
        this.value = value;
        this.frequency = frequency;
    }
}
