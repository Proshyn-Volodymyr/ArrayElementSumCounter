package com.gmail.vladimirprocean;

import java.util.Arrays;

public class ArrayElementSumCounter implements Runnable{
    private int[] intArray;
    private int total;

    public ArrayElementSumCounter(int[] intArray) {
        this.intArray = intArray;
    }

    public int[] getIntArray() {
        return this.intArray;
    }

    public int sumElements() {
        int result = 0;
        for (int number : intArray
        ) {
            total += number;
        }
        result = total;
        return result;
    }

    @Override
    public void run() {
        Thread th = Thread.currentThread();
        this.sumElements();
        try{
            Thread.sleep(2000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(th.getName() + " " +total);
    }

    @Override
    public String toString() {
        return "ArrayElementSumCounter{" +
                "intArray=" + Arrays.toString(intArray) +
                '}';
    }
}
