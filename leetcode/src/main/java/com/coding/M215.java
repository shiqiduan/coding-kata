package com.coding;

/**
 * 2023-05-18 09:58:28
 */
public class M215 {
    public int findKthLargest(int[] nums, int k) {
        int s = 0, e = nums.length - 1;
        while (true) {
            int p = partition(nums, s, e);
            if (p == (nums.length - k)) {
                return nums[p];
            } else if (p < (nums.length - k)) {
                s = p + 1;
            } else {
                e = p - 1;
            }
        }
    }

    private int partition(int[] nums, int s, int e) {
        if (s == e) return s;
        int p = (int) (s + Math.random() * (e - s));
        swap(nums, p, e);
        boolean forward = true;
        while (s < e) {
            if (forward) {
                if (nums[s] <= nums[e]) {
                    s++;
                } else {
                    swap(nums, s, e);
                    e--;
                    forward = false;
                }
            } else {
                if (nums[e] >= nums[s]) {
                    e--;
                } else {
                    swap(nums, s, e);
                    s++;
                    forward = true;
                }
            }
        }
        return s;
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        M215 m = new M215();
        System.out.println(m.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
        System.out.println(m.findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
    }
}
