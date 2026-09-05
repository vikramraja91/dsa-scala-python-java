package org.javadsa;
import java.util.Arrays;

public class Sorting {

    public static void bubbleSort(int[] x){
        int i=0;
        boolean swapped = true;

        while (swapped && i<x.length-1){
            swapped = false;
            for (int j=0;j<x.length-1-i;i++){
                if (x[j]>x[j+1]){
                    int temp=x[j];
                    x[j]=x[j+1];
                    x[j+1]=temp;
                }
                swapped = true;
            }
        }
    }

    public static int[] mergeSort(int[] arr) {

        if (arr.length <= 1) {
            return arr;
        } else {
            int mid = arr.length / 2;
            int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));
            int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));

            return merge(left, right);

        }
    }

        private static int[] merge(int[] left, int[] right) {

            int[] result = new int[left.length + right.length];
            int i= 0;
            int j= 0;
            int k= 0;

            while(i<left.length && j<right.length){
                if (left[i] <= right[j]) {
                    result[k] = left[i];
                    i++;
                } else {
                    result[k] = right[j];
                    j++;
                }

                k++;
            }
           // Remaining elements from left
            while (i < left.length) {
                result[k] = left[i];
                i++;
                k++;
            }

            // Remaining elements from right
            while (j < right.length) {
                result[k] = right[j];
                j++;
                k++;
            }

        return result;
    }


        public static void main(String[] args) {

            int[] x = {5, 3, 8, 4, 2};

            int[] result = mergeSort(x);

            System.out.println(Arrays.toString(result));
        }
    }



