package leetcode.editor.cn;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] arr = {5, 6, 2, 1, 9, 7, 3, 11, 0};
        partition(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static int partition(int[] arr, int left, int right) {
        int point = arr[left];
        int move = left;
        for (int i = left + 1; i <= right; i++) {
            if (arr[i] < point) {
                move ++;
                swap(arr, move, i);
            }
        }
        swap(arr, move, left);
        return move;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
