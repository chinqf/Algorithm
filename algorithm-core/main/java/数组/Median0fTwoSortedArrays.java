package 数组;

/** 寻找两个有序数组的中位数
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 * 示例1：
 * nums1 = [1, 3]
 * nums2 = [2]
 * 则中位数是 2.0
 *
 * 示例2：
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * 则中位数是 (2 + 3)/2 = 2.5
 */

public class Median0fTwoSortedArrays {
    public static void main(String[] args) {
        int[] num1 = {1, 2};
        int[] num2 = {3, 4};
        System.out.println(findMedianSortedArrays01(num1, num2));

    }

    // 复杂度 O(M+N): 找到两个数组总长度的一半位置的元素
    public static double findMedianSortedArrays01(int[] nums1, int[] nums2) {
        int length = nums1.length + nums2.length;
        int index01 = 0;
        int index02 = 0;
        int index = 0;
        int left = nums1[0];
        int right = nums1[0];
        while (index <= length/2) {
            left = right;
            if (index01<nums1.length && ( index02>=nums2.length || nums1[index01] <= nums2[index02])) {
                right=nums1[index01++];
            } else {
                right=nums2[index02++];
            }
            index++;
        }
        return length%2==0 ? (left + right)*1.0/2 : right;
    }

    // 复杂度 O(log(M+N)) 二分查找+取第k小数的思路
    public double findMedianSortedArrays02(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        int index01 = 0, index02 = 0;
        // 中位数位置
        int pos = (len1+len2) / 2;
        int mid = 0;
        int start = 0;
        while (pos >= 0) {
            mid = pos / 2;
            if (len1-index01-1 < mid) {

            } else if (len2-index02-1 < mid) {

            } else {
                if (nums1[index01+mid-1]>nums2[index02+mid-1]) {
                    index02 = index02+mid-1;
                } else {
                    index01 = index01+mid-1;
                }
            }
        }
        return -1;
    }

}
