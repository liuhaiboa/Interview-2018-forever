
# num1
给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
(还有扩展的三数之和，四数之和)
1. 暴力求解
````$xslt
public int[] twoSum(int[] nums, int target) {
      for (int i = 0; i < nums.length; i++) {
        for (int j = i + 1; j < nums.length; j++) {
            if (nums[j] == target - nums[i]) {
                return new int[] { i, j };
            }
        }
    }
    throw new IllegalArgumentException("No two sum solution");
} 
````
2. 两遍hash表
````$xslt
public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
        map.put(nums[i], i);
    }
    for (int i = 0; i < nums.length; i++) {
        int complement = target - nums[i];
        if (map.containsKey(complement) && map.get(complement) != i) {
            return new int[] { i, map.get(complement) };
        }
    }
    throw new IllegalArgumentException("No two sum solution");
}
````
# num 167 
给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。  
输入：numbers = [2, 7, 11, 15], target = 9。输出：输出: [1,2]
````$xslt
//双指针
public int[] twoSum(int[] numbers, int target) {
        int left=0,right=numbers.length-1;
        int sum;
        //int[] res = new int[2];
        while(left<right){
            sum=numbers[left]+numbers[right];
            if(sum<target)
                left++;
            else if(sum>target)
                right--;
            else
            {
                int[] res = {left+1,right+1};
                   return res;
            }
        }
        return null;
    }
````

# num635
给定一个二叉搜索树和一个目标结果，如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true.
输入：[5,3,6,2,4,null,7]  输出 9
````$xslt
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 HashSet<Integer> hashset = new HashSet<Integer>();
         return preOrder(root,hashset,k);
     }
     public boolean preOrder(TreeNode root,HashSet<Integer> hashset,int k){
         if(root == null)
             return false;
         if(hashset.contains(k - root.val)){
             return true;
         }
         hashset.add(root.val);
         return preOrder(root.left,hashset,k) || preOrder(root.right,hashset,k);
     }

````