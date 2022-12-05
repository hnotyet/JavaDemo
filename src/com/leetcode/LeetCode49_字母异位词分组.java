package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LeetCode49_字母异位词分组 {

    public List<List<String>> groupAnagrams(String[] strs) {
        return new ArrayList<>(Arrays.stream(strs).collect(Collectors.groupingBy(str ->
                {
                    char[] array = str.toCharArray();
                    Arrays.sort(array);
                    return new String(array);
                }
        )).values());
    }
}
