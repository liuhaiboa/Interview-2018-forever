package LeetCode;


import java.util.ArrayList;
import java.util.List;

public class num198 {





        public static int rob(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int length = nums.length;
            if (length == 1) {
                return nums[0];
            }
            int[] dp = new int[length];
            dp[0] = nums[0];
            dp[1] = Math.max(nums[0], nums[1]);
            for (int i = 2; i < length; i++) {
                dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
            }
            return dp[length - 1];
        }


    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {

            int max= 0;
        for (int candy1 : candies) {
            if (candy1 > max) {
                max = candy1;
            }
        }
        List<Boolean> list = new ArrayList<>();
        for (int candy : candies) {
            if (candy + extraCandies > max) {
                list.add(true);
            } else {
                list.add(false);
            }
        }
        System.out.println(list);
        return list;







    }


    public static double new21Game(int N, int K, int W) {
        double num = 1;
        for(int i = 1;i<W;i++){
            if(i>K|| i==K){
                num = i;
                break;

            }
        }

        return (W-num)/N;
    }

    public static void main(String[] args) {
//        double v = new21Game(10, 1, 10);
//        System.out.println(v);

        System.out.println(1.0/10.0);
    }
}
