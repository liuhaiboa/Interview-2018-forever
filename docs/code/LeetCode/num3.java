package LeetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;


/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 示例 1:  输入: "abcabcbb"   输出: 3
 示例 2:  输入: "bbbbb"      输出: 1
 示例 3:  输入: "pwwkew"     输出: 3
 */
public class num3 {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j <= n; j++)
                if (allUnique(s, i, j)) ans = Math.max(ans, j - i);
        return ans;
    }

    public boolean allUnique(String s, int start, int end) {
        Set<Character> set = new HashSet<>();
        for (int i = start; i < end; i++) {
            Character ch = s.charAt(i);
            if (set.contains(ch)) return false;
            set.add(ch);
        }
        return true;
    }

    // 第二种解法
    public int lengthOfLongestSubstring1(String s) {
        if (s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        int left = 0;
        for(int i = 0; i < s.length(); i ++){
            if(map.containsKey(s.charAt(i))){
                left = Math.max(left,map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-left+1);
        }
        return max;

    }


}
