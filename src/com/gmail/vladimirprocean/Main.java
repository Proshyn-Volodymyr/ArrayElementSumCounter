package com.gmail.vladimirprocean;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[20];
        int arrPart = (arr.length / 4);
        int index = 0;
        int sumOfElements = 0;

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 10);
        }

        Thread[] threads = new Thread[4];
        ArrayElementSumCounter[] counters = new ArrayElementSumCounter[4];

        for (int i = 0; i < arr.length; i += arrPart) {
            counters[index] = new ArrayElementSumCounter(i, i + arrPart, arr);
            threads[index] = new Thread(counters[index]);
            threads[index].start();
            try{
                threads[index].join();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            sumOfElements += counters[index].getTotal();
            index++;
        }
        System.out.println(sumOfElements);
    }
}