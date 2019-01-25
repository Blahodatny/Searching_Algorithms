package com.project.search;

import java.util.Arrays;

class Binary {
    // recursion implementation
    // auxiliary space - O(log n) call stack space
    private static int search(int[] arr, int left, int right, int x) {
        return x > arr[left] || x < arr[right] ? search0(arr, left, right, x) : -1;
    }

    private static int search0(int[] arr, int left, int right, int x) {
        if (left <= right) {
            var middle = left + right >>> 1;
            return arr[middle] == x
                    ? middle
                    : arr[middle] > x
                    ? search0(arr, left, middle - 1, x)
                    : search0(arr, middle + 1, right, x);
        }
        return -1;
    }

    /*
     * Best case - O(1)
     * x is the middle of array
     */

    /*
     * Worst case = O(log n)
     * x is first or last element of an array
     */

    /*
     * Average case - O (log n) comparisons
     */

    // iterative implementation
    private static int search(int[] arr, int x) {
        int left = 0, right = arr.length - 1;
        if (x > arr[left] || x < arr[right])
            while (left <= right) {
                var middle = left + (right - left) / 2;
                if (arr[middle] == x)
                    return middle;
                else if (arr[middle] > x)
                    right = middle - 1;
                else
                    left = middle + 1;
            }
        return -1;
    }
    // auxiliary space - O(1)

    public static void main(String... args) {
        var arr = new int[]{-1, 3, 7, 12, 34, 56, 67, 78, 89, 100};
        System.out.println(search(arr, 0, 9, 7));
        System.out.println(search(arr, 7));
        System.out.println(Arrays.binarySearch(arr, 7));
    }
}