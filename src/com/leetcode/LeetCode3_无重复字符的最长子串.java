package com.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LeetCode3_无重复字符的最长子串 {

    public static void main(String[] args) {

    }

    /**
     * 滑动窗口
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int length = s.length();
        int max = 0;

        Map<Character, Integer> map = new HashMap<>();
        int start = 0;
        for(int end = 0; end < length; end++){
            char element = s.charAt(end);
            if(map.containsKey(element)){
                start = Math.max(map.get(element) + 1, start); //map.get()的地方进行+1操作
            }
            max = Math.max(max, end - start + 1);
            map.put(element, end);
        }
        return max;
    }

}
