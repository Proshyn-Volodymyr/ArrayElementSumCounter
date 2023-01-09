package com.gmail.vladimirprocean;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[200000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random()*100);
        }
        ArrayElementSumCounter aesc = new ArrayElementSumCounter(arr);
        Thread thread;
        int arrPart = (arr.length / 4);
        if (arr.length % 2 != 0) {
            arrPart += 1;
        }
        int[] newArr = new int[arrPart];
        for (int i = 0; i < arr.length; i += arrPart) {
            System.arraycopy(arr, i, newArr, 0, arrPart);
            thread = new Thread(new ArrayElementSumCounter(newArr));
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
//        for (int elem:newArr
//        ) {
//            System.out.println(elem);
//        }
    }
}