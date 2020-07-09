package LeetCode;

import java.util.*;

/**
 * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
 注意:假设字符串的长度不会超过 1010。
 示例
 输入:"abccccdd"
 输出:7
 解释:我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 */
public class num409 {
    public int longestPalindrome(String s) {

        int[] count = new int[128];
        for (char c: s.toCharArray()){
            count[c]++;
        }

        int ans = 0;
        for (int v: count) {
            ans += v / 2 * 2;
            if (v % 2 == 1 && ans % 2 == 0)
                ans++;
        }
        return ans;

        // 找出可以构成最长回文串的长度
//        int[] arr = new int[128];
//        for(char c : s.toCharArray()) {
//            arr[c]++;
//        }
//        int count = 0;
//        for (int i : arr) {
//            count += (i % 2);
//        }
//        return count == 0 ? s.length() : (s.length() - count + 1);



//        Map<Character,Integer> map = new HashMap<Character,Integer>();
//        char[] chars = s.toCharArray();
//        for (char c: chars) {
//            if(map.containsKey(c)){
//                Integer o = map.get(c);
//                map.put(c,o+1);
//            }else {
//                map.put(c,1);
//            }
//        }
//
//        Boolean hasNoe = false;
//        int x = 0;
//        for(Character key : map.keySet()){
//            if(map.get(key) % 2 == 0){
//                x += map.get(key);
//            }
//            if(map.get(key) % 2 < 0){
//                x += map.get(key)/2  ;
//                x = x*2;
//            }
//            if(map.get(key) == 1){ hasNoe = true;}
//            if(map.get(key) == s.length()){
//                return s.length();
//            }
//
//        }
//
//
//
//        return hasNoe?x + 1: x ;
    }



    public static void main(String[] args) {
        List<String> oldCollect = new ArrayList();
        oldCollect.add("1");
        oldCollect.add("2");
        oldCollect.add("3");

        List<String> newCollect =  new ArrayList();
        newCollect.add("3");
        newCollect.add("1");
        newCollect.add("2");

        System.out.println(!(oldCollect.containsAll(newCollect) && newCollect.containsAll(oldCollect)));
    }
}
