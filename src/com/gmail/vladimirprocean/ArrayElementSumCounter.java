package com.gmail.vladimirprocean;

public class ArrayElementSumCounter implements Runnable{
    int[] numbers;
    private int startPosition;
    private int endPosition;
    private int total;

    public ArrayElementSumCounter(int startPosition, int endPosition, int[] numbers) {
        this.numbers = numbers;
        this.startPosition = startPosition;
        this.endPosition = endPosition;
    }
    public int getTotal() {
        return total;
    }

    private synchronized int sumElements() {
        int result = 0;
        for (int i = startPosition; i < endPosition ; i++) {
        result += numbers[i];
        }
        return result;
    }

    @Override
    public void run() {
        total = this.sumElements();
    }

    @Override
    public String toString() {
        return "ArrayElementSumCounter{" +
                "total=" + total +
                '}';
    }
}
