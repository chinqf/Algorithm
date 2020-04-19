import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class Test {
    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(solution(arr));


    }

    public static int solution(int[] arr) {
        int res = 0;
        LinkedList<Integer> list = new LinkedList<Integer>();
        // 先找到左边递增到最大的值的索引，在这之前都无法装雨水
        int left_max_index = 0;
        int left_max = 0;
        for (int i=0; i<arr.length; i++) {
            if (arr[i] >= left_max) {
                left_max = arr[i];
                left_max_index = i;
            } else {
                break;
            }
        }
        // 同理找到右边最大值索引，在这之后都无法接雨水
        int right_max_index = arr.length - 1;
        int right_max = 0;
        for (int j = arr.length - 1; j >= 0; j--) {
            if (arr[j] >= right_max) {
                right_max = arr[j];
                right_max_index = j;
            } else {
                break;
            }
        }
        // 算两个索引之间能接到的雨水
        for (int i = left_max_index; i<= right_max_index; i++) {
            if (list.isEmpty() || arr[i] <= left_max) {
                list.addLast(arr[i]);
            } else {
                right_max = arr[i];
                while (!list.isEmpty()) {
                    res += Math.min(left_max, right_max) - list.removeLast();
                }
                list.addLast(arr[i]);
                left_max = arr[i];
            }
        }
        if (!list.isEmpty()) right_max = arr[right_max_index];
        System.out.println("res: " + res);
        System.out.println(left_max);
        System.out.println(right_max);
        while (!list.isEmpty()) {
            int r = list.removeLast();

            System.out.println("r: " + (Math.min(left_max, right_max) - r));
            res += Math.min(left_max, right_max) - r;
        }
        return res;
    }
}
