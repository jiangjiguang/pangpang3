package com.pangpang3.utils.books.suanfadaolun.paixu;

/**
 * Created by root on 17-5-21.
 */
public class feizhi {

    public static void main(String[] args) {
        Integer[] arr = {1,3,4,5,2,6,7,9};
        sort(arr);
        System.out.println(11);
    }

    public static void sort(Integer[] arr){
        int p = arr.length /2;

        Integer[] l = new Integer[p];
        Integer[] r = new Integer[p];

        for(int i=0; i<p; i++){
            l[i] = arr[i];
        }
        for(int i=p; i<arr.length; i++){
            r[i-p] = arr[i];
        }

        int i = 0;
        int j = 0;
        for(int k=0; k<arr.length; k++){
            if(i<4 && l[i] <= r[j]){
                arr[k] = l[i];
                i++;
            }else{
                arr[k] = r[j];
                j++;
            }
        }
    }
}
