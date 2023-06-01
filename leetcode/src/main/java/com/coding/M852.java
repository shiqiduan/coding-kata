package com.coding;

public class M852 {
    public int peakIndexInMountainArray(int[] arr) {
        int s = 1, e = arr.length - 2;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                return mid;
            }
            if (arr[mid] > arr[mid - 1] && arr[mid] < arr[mid + 1]) {
                s = mid + 1;
                continue;
            }
            if (arr[mid] < arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                e = mid - 1;
            }
        }
        return s;
    }
}
