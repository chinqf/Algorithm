/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 示例
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 */
public class MaximumSubarray {

    public static void main(String[] args) {
        int[] arr = {1, 1, -1, 98};
        System.out.println(solution(arr));
    }

    public static int solution(int[] arr) {
        int max = arr[0];
        int currSum = arr[0];
        for (int i=1; i<arr.length; i++) {
            currSum = Math.max(currSum+arr[i], arr[i]);
            max = Math.max(max, currSum);
        }
        return max;
    }

}
