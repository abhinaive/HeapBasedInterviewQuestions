package org.heapinterviewquestions;

import java.util.PriorityQueue;

public class SortArrayInAscOrderUsingHeap {

    public static void heapSort(int[] arr) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i = 0; i < arr.length; i++) {
            minHeap.add(arr[i]);
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = minHeap.poll();
        }
    }

    public static void main(String[] args) {

        int[] arr = {10, 7, 11, 30, 20, 38, 2, 45};

        System.out.print("Printing array before calling heap sort : ");

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ,");
        }

        System.out.println();

        SortArrayInAscOrderUsingHeap.heapSort(arr);

        System.out.print("Printing array after heap sort using min heap : ");

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ,");
        }

    }
}
