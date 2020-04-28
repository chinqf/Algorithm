import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** 三数之和
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 *
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 示例：
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 */

public class ThreeNumberSum {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums));

    }

    // 排序+双指针
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList();
        Arrays.sort(nums);
        for (int i=0; i<nums.length; i++) {
            if (nums[i] > 0) break;
            if (i>0 && nums[i]==nums[i-1]) continue;
            int left = i+1;
            int right = nums.length-1;
            while(left < right) {
                if (nums[i]+nums[left]+nums[right]==0) {
                    List<Integer> list = new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right]));
                    ans.add(list);
                    while(left+1<right && nums[left]==nums[left+1]) left++;
                    while(left<right-1 && nums[right-1]==nums[right]) right--;
                    left++;
                    right--;
                } else if (nums[i]+nums[left]+nums[right]>0) {
                    right--;
                } else {
                    left ++;
                }
            }
        }
        return ans;
    }

}
