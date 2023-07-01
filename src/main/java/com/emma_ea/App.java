package com.emma_ea;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }

    public int findDuplicate(String input) {
        int len;
        if (input == null || (len = input.length()) == 0) {
            return -1;
        }

        Set<Character> chars = new HashSet<>();
        for (int i = 0; i < len; i++) {
            if (chars.contains(input.charAt(i))) {
                return i;
            } else {
                chars.add(input.charAt(i));
            }
        }
        return -1;
    }

    /**
     * [abc, bbc, abc]
     */
    public List<String> calculateWordFrequency(List<String> words) {
        int len;
        if (words == null || (len = words.size()) == 0) {
            return new ArrayList<>();
        }

        TreeMap<String, Integer> freqMap = new TreeMap<>();
        List<String> res = new ArrayList<>();
        for (String word : words) {
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
        }

        for (String key : freqMap.keySet()) {
            res.add(String.format("%s | %d", key, freqMap.get(key)));
        }
        return res;
    }

    /**
     * 1+2
     * 1+2+3
     */
    public int calculator(String input) {
        int len;
        if (input == null || (len = input.length()) == 0) {
            return 0;
        }

        Stack<Integer> calcStack = new Stack<>();
        char sign = '+';
        int num =  0;
        for (int i = 0; i < len; i++) {
            if (Character.isDigit(input.charAt(i))) {
                num = num * 10 + input.charAt(i) - '0';
            }
            if (!Character.isDigit(input.charAt(i)) || i == len - 1) {
                if (sign == '+') {
                    calcStack.add(num);
                }
                if (sign == '-') {
                    calcStack.add(-num);
                }
                if (sign == '*') {
                    calcStack.add(calcStack.pop() * num);
                }
                sign = input.charAt(i);
                num = 0;
            }
        }

        int ans = 0;
        for (int i : calcStack) {
            ans += i;
        }
        return ans;

    }

    public List<Integer> findKLargest(int[] arr, int k) {

        if (arr == null ||arr.length == 0) {
            return new ArrayList<>();
        }

        TreeSet<Integer> largest = new TreeSet<>();
        for (int i : arr) {
            largest.add(i);
            if (largest.size() > k) {
                largest.pollFirst();
            }
        }

        return new ArrayList<>(largest);
    }
}
