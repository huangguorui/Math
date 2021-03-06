package p4.p2.p23;

import java.util.Arrays;

public class InsertionSort {
    private InsertionSort() {
    }
    public static <E extends Comparable<E>> void sort(E[] arr) {
        for (int i = 0; i < arr.length; i++) {
            //将arr[i]插入到合适的位置
            E t = arr[i];
            int j;
            for (j = i;j - 1 >= 0 && t.compareTo(arr[j - 1]) < 0; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = t;

        }
    }

    public static <E extends Comparable<E>> void sort(E[] arr,int l,int r) {
        for (int i = l; i <= r; i++) {
            //将arr[i]插入到合适的位置
            E t = arr[i];
            int j;
            for (j = i;j - 1 >= l && t.compareTo(arr[j - 1]) < 0; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = t;
        }
    }

    private static <E> void swap(E[] arr, int i, int j) {
        E t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
    public static void main(String[] args) {
        int[] dataSize = {10000,100000};
        for(int n : dataSize){
            System.out.println("Random Array ：");
            Integer[] arr = ArrayGenerator.generateRandomArray(n,n);
            Integer[] arr2 = Arrays.copyOf(arr,arr.length);
            SortingHelper.sortTest("InsertionSort",arr);
            SortingHelper.sortTest("SelectionSort",arr2);

            System.out.println();

            System.out.println("Ordered Array : ");

            arr = ArrayGenerator.generateOrderedArray(n);
            arr2 = Arrays.copyOf(arr,arr.length);

            SortingHelper.sortTest("InsertionSort",arr);
            SortingHelper.sortTest("SelectionSort",arr2);
        }
    }

}
