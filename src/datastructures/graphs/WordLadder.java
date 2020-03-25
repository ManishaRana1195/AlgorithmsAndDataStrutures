package datastructures.graphs;

import java.util.*;

public class WordLadder {

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        String[] dict = {"hot", "dot", "dog", "lot", "log", "cog"};
//        String beginWord = "a";
//        String endWord = "c";
//        String[] dict = {"a", "b", "c"};
        List<String> wordList = new ArrayList<>();
        for (String string : dict) {
            wordList.add(string);
        }


        int length = ladderLength(beginWord, endWord, wordList);
        System.out.println(length);
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashMap<String, List<String>> base = getPatternMap(wordList);
        HashMap<String, List<String>> patternStringMap = getPatternStringMap(base);
        Map<String, Integer> isVisitedMap = new HashMap<>();
        int ladderLength = 0;
        isVisitedMap.put(beginWord, 1);

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);

        while (!queue.isEmpty()) {
            String front = queue.poll();
            List<String> neighbors = getNeighbor(front, patternStringMap);

            for (String element : neighbors) {
                if (!isVisitedMap.containsKey(element)) {
                    if (element.equals(endWord)) {
                        int currLevel = isVisitedMap.get(front);
                        return currLevel + 1;
                    }
                    queue.add(element);
                    isVisitedMap.put(element, isVisitedMap.get(front) + 1);
                }

            }

        }

        return ladderLength;
    }

    public static List<String> getNeighbor(String word, HashMap<String, List<String>> patternStringMap) {
        List<String> neighbors = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            // add adjacent element to the list
            String wordWithStar = word.substring(0, i) + "*" + word.substring(i + 1);
            List<String> matchingPattern = patternStringMap.getOrDefault(wordWithStar, null);

            if (matchingPattern != null) {
                for (String element : matchingPattern) {
                    neighbors.add(element);
                }
            }
        }
        return neighbors;
    }

    private static HashMap<String, List<String>> getPatternStringMap(HashMap<String, List<String>> base) {
        /*
        * Creating map like *ot => dot, hot, got
        * */
        HashMap<String, List<String>> patternStringMap = new HashMap<>();
        for (String key : base.keySet()) {
            List<String> patternStrings = base.get(key);
            for (String element : patternStrings) {
                List<String> list = patternStringMap.getOrDefault(element, null);
                if (list == null) {
                    list = new ArrayList<>();
                }
                list.add(key);
                patternStringMap.put(element, list);
            }
        }
        return patternStringMap;
    }

    private static HashMap<String, List<String>> getPatternMap(List<String> wordList) {
        /*
        * Creating map like cot => *ot, c*t, co*
        * */
        HashMap<String, List<String>> base = new HashMap<>();
        for (String word : wordList) {
            List<String> currList = base.get(word);
            if (currList == null) {
                currList = new ArrayList<>();
            }
            for (int i = 0; i < word.length(); i++) {
                String wordWithStar = word.substring(0, i) + "*" + word.substring(i + 1);
                currList.add(wordWithStar);
            }
            base.put(word, currList);
        }

        return base;
    }
}
