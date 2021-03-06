package p4.p2.p21;

import java.util.Arrays;

public class MergeSort {
    private MergeSort() {
    }

    public static <E extends Comparable<E>> void sort(E[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    public static <E extends Comparable<E>> void sort2(E[] arr) {
        sort2(arr, 0, arr.length - 1);
    }

    private static <E extends Comparable<E>> void sort(E[] arr, int l, int r) {

        if (l >= r) return;

        //可能产生bug的问题，整型溢出,数组越界
        //int mid = (l + r) / 2;
        //解决方法
        int mid = l + (r -l) / 2;

        sort(arr, l, mid);
        sort(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    private static <E extends Comparable<E>> void sort2(E[] arr, int l, int r) {

        if (l >= r) return;

        //可能产生bug的问题，整型溢出,数组越界
        //int mid = (l + r) / 2;
        //解决方法
        int mid = l + (r -l) / 2;

        sort2(arr, l, mid);
        sort2(arr, mid + 1, r);
        if(arr[mid].compareTo(arr[mid + 1]) > 0)
             merge(arr, l, mid, r);
    }



    //合并两个有序的区间 arr[l, mid] 和 arr[mid + 1, r]
    public static <E extends Comparable<E>> void merge(E[] arr, int l, int mid, int r) {

        E[] temp = Arrays.copyOfRange(arr, l, r + 1);

        int i = l, j = mid + 1;

        // 每轮循环为 arr[k] 赋值
        for (int k = l; k <= r; k++) {
            if (i > mid) {
                arr[k] = temp[j - l];
                j++;
            } else if (j > r) {
                arr[k] = temp[i - l];
                i++;
            } else if (temp[i - l].compareTo(temp[j - l]) <= 0) {
                arr[k] = temp[i - l];
                i++;
            } else {
                arr[k] = temp[j - l];
                j++;
            }

        }
        //arr[i] 和 arr[j]


    }

    public static void main(String[] args) {
        int n = 1000000;
//        Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
        Integer[] arr = ArrayGenerator.generateOrderedArray(n);

        Integer[] arr2 = Arrays.copyOf(arr,arr.length);
//        Integer[] arr3 = Arrays.copyOf(arr,arr.length);

        SortingHelper.sortTest("MergeSort",arr);
        SortingHelper.sortTest("MergeSort2",arr2);
//        SortingHelper.sortTest("MergeSort",arr3);

    }

}
