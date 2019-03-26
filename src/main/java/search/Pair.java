package search;

import java.util.Arrays;

/*
 * Given a sorted array and a number x
 * Find a pair in array whose sum is closest to x.
 */
class Pair {
    private static int[] search(int[] arr, int x) {
        int res_l = -1, res_r = -1;
        int left = 0, right = arr.length - 1, diff = Integer.MAX_VALUE;
        while (left < right) {
            var abs = Math.abs(arr[left] + arr[right] - x);
            if (abs < diff) {
                res_l = left;
                res_r = right;
                diff = abs;
            }
            if (arr[left] + arr[right] > x)
                right--;
            else
                left++;
        }
        return new int[]{res_l, res_r};
    }

    public static void main(String... args) {
        var arr = new int[]{-1, 3, 7, 12, 34, 56, 67, 78, 89, 100};
        System.out.println(Arrays.toString(search(arr, 50)));
    }
}