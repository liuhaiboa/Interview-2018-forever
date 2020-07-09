package LeetCode;

public class num680 {
//    给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
//    示例 1:
//    输入: "aba"
//    输出: True
//    示例 2:
//    输入: "abca"
//    输出: True
//    解释: 你可以删除c字符。
//    注意:字符串只包含从 a-z 的小写字母。字符串的最大长度是50000。

//    public static boolean validPalindrome(String s) {
//
//        int low = 0, high = s.length() - 1;
//        while (low < high) {
//            char c1 = s.charAt(low), c2 = s.charAt(high);
//            if (c1 == c2) {
//                low++;
//                high--;
//            } else {
//                boolean flag1 = true, flag2 = true;
//                for (int i = low, j = high - 1; i < j; i++, j--) {
//                    char c3 = s.charAt(i), c4 = s.charAt(j);
//                    if (c3 != c4) {
//                        flag1 = false;
//                        break;
//                    }
//                }
//                for (int i = low + 1, j = high; i < j; i++, j--) {
//                    char c3 = s.charAt(i), c4 = s.charAt(j);
//                    if (c3 != c4) {
//                        flag2 = false;
//                        break;
//                    }
//                }
//                return flag1 || flag2;
//            }
//        }
//        return true;
//
//
//    }

    public boolean validPalindrome(String s) {
        return validPalindrome(s, 0, s.length()-1, 1);
    }

    /**
     *
     * @param s 输入字符串
     * @param left 左指针
     * @param right 右指针
     * @param chance 删除节点的机会次数
     */
    private boolean validPalindrome(String s, int left, int right, int chance) {
        if (left > right) {
            return true;
        }
        if (s.charAt(left) == s.charAt(right)) {
            return validPalindrome(s, left + 1, right - 1, chance);
        } else {
            if (chance == 0) {
                return false;
            }
            return validPalindrome(s, left, right - 1, chance-1) || validPalindrome(s, left + 1, right, chance-1);
        }
    }








}
