package p4.p2.p25;

import java.util.Arrays;

public class MergeSort {
    private MergeSort() {
    }
    // 自顶向下的归并排序
    public static <E extends Comparable<E>> void sort(E[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    public static <E extends Comparable<E>> void sort2(E[] arr) {
        //获取和整个数组相同的临时空间
        E[] temp = Arrays.copyOf(arr, arr.length);
        sort2(arr, 0, arr.length - 1,temp);
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

    private static <E extends Comparable<E>> void sort2(E[] arr, int l, int r,E[] temp) {

//        if (l >= r) return;
        if(r - l <= 15){
            InsertionSort.sort(arr,l,r);
            return; //不写会重复执行
        }


        //可能产生bug的问题，整型溢出,数组越界
        //int mid = (l + r) / 2;
        //解决方法
        int mid = l + (r -l) / 2;

        sort2(arr, l, mid,temp);
        sort2(arr, mid + 1, r,temp);
        if(arr[mid].compareTo(arr[mid + 1]) > 0)
             merge2(arr, l, mid, r,temp);
    }
    //自底向上的归并排序
    public static <E extends  Comparable<E>> void sortBU(E[] arr){

        E[] temp = Arrays.copyOf(arr,arr.length);

        int n = arr.length;
        // 遍历合并的区间长度
        for(int sz = 1; sz < n;sz += sz){
            // 遍历合并的两个区间的起始位置 i
            //合并 [i,i + sz -1]和 [i + sz, i + sz + sz -1] 有bug
            //合并 [i,i + sz -1]和 [i + sz,Math.min(i + sz + sz -1,n - 1)] 解决方法

            for (int i = 0; i + sz < n ;i +=sz+sz)
                if(arr[i + sz - 1].compareTo(arr[i + sz]) > 0)
                merge2(arr,i,i + sz -1,Math.min(i + sz + sz -1,n - 1),temp);

        }

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

    //合并两个有序的区间 arr[l, mid] 和 arr[mid + 1, r]
    public static <E extends Comparable<E>> void merge2(E[] arr, int l, int mid, int r,E[] temp) {

        System.arraycopy(arr,l,temp,l,r - l + 1);

        int i = l, j = mid + 1;

        // 每轮循环为 arr[k] 赋值
        for (int k = l; k <= r; k++) {
            if (i > mid) {
                arr[k] = temp[j];
                j++;
            } else if (j > r) {
                arr[k] = temp[i];
                i++;
            } else if (temp[i - l].compareTo(temp[j]) <= 0) {
                arr[k] = temp[i];
                i++;
            } else {
                arr[k] = temp[j];
                j++;
            }

        }
        //arr[i] 和 arr[j]


    }

    public static void main(String[] args) {
        int n = 5000000;
        Integer[] arr = ArrayGenerator.generateRandomArray(n, n);

        Integer[] arr2 = Arrays.copyOf(arr,arr.length);
        SortingHelper.sortTest("MergeSort",arr);
        SortingHelper.sortTest("MergeSortBU",arr2);
    }
}
