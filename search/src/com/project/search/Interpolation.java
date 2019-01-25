package com.project.search;

class Interpolation {
    /*
     * Best case - O(1)
     * x is arr[pos]
     */

    /*
     * Worst case = O(n)
     * e.g. x == 1000, arr = [1, 2, ..., 999, 1000, 10^9]
     */

    /*
     * Average case - O (log log n) comparisons
     */

    private static int search(int[] arr, int x) {
        int lo = 0, hi = (arr.length - 1);

        while (lo <= hi && x >= arr[lo] && x <= arr[hi]) {
            var pos = lo +
                    (hi - lo) / (arr[hi] - arr[lo]) * (x - arr[lo]);

            if (arr[pos] == x)
                return pos;

            if (arr[pos] < x)
                lo = pos + 1;

            else
                hi = pos - 1;
        }
        return -1;
    }

    public static void main(String... args) {
        var arr = new int[]{-1, 3, 7, 12, 34, 56, 67, 78, 89, 100};
        System.out.println(search(arr, 7));
    }
}