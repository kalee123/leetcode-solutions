/*
 Pattern Matching
Hard

You are given strings s and p. Return whether there's some pairing between each unique character in p to some non-empty string such that p becomes s under this mapping.

Example 1
Input
s = "dogdogcat"
p = "aab"
Output
true
Explanation
We can map "a" to "dog" and "b" to "cat"
*/

import java.util.*;

class Solution {
    public boolean findPattern(String str, String pattern, int len, int n, HashMap map, int index) {
        String mapStr = "";

        if (index == n)
            return true;

        char ch = pattern.charAt(index);
        if (map.containsKey(ch))
            mapStr = map.get(ch).toString();

        for (int i = 0; i < len; i++) {
            String sub = str.substring(0, i + 1);
            String subStr = str.substring(i + 1, len);
            if (index == n - 1) {
                sub = str.substring(0, len);
            }
            if (mapStr.equals("")) {
                map.put(ch, sub);
                if (findPattern(subStr, pattern, subStr.length(), n, map, index + 1))
                    return true;
                map.remove(ch);
            } else if (sub.equals(mapStr)) {
                if (findPattern(subStr, pattern, subStr.length(), n, map, index + 1))
                    return true;
            }
        }
        return false;
    }
    public boolean solve(String s, String p) {
        HashMap<String, String> map = new HashMap<>();
        return findPattern(s, p, s.length(), p.length(), map, 0);
    }
}