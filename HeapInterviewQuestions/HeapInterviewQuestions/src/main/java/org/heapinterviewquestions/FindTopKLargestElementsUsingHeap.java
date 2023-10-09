package org.heapinterviewquestions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class FindTopKLargestElementsUsingHeap {


    public static List<Integer> findTopKLargestElementsUsingMaxHeap(int[] arr, int k) {

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        List<Integer> topKElements = new ArrayList<>();

        if (arr.length < k) {
            System.out.printf("Invalid Case");
            topKElements.add(-1);
            return topKElements;
        }

        for (int i = 0; i < arr.length; i++) {
            maxHeap.add(arr[i]);
        }

        for (int i = 0; i < k; i++) {
            topKElements.add(maxHeap.poll());
        }

        return topKElements;
    }

    public static List<Integer> findTopKLargestElementsUsingMinHeap(int[] arr, int k) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        List<Integer> topKElements = new ArrayList<>();

        if (arr.length < k) {
            System.out.printf("Invalid Case");
            topKElements.add(-1);
            return topKElements;
        }

        for (int i = 0; i < k; i++) {
            minHeap.add(arr[i]);
        }

        for (int i = k; i < arr.length; i++) {
            if (arr[i] > minHeap.peek()) {
                minHeap.poll();
                minHeap.add(arr[i]);
            }
        }

        for (int i = 0; i < k; i++) {
            topKElements.add(minHeap.poll());
        }

        return topKElements;
    }


    public static void main(String[] args) {

        int[] arr = {10, 7, 11, 30, 20, 38, 2, 45};
        int k = 3;

        System.out.println("Top k largest element in given array using maxHeap is : " + findTopKLargestElementsUsingMaxHeap(arr, k).toString());
        System.out.println("Top k largest element in given array using minHeap is : " + findTopKLargestElementsUsingMinHeap(arr, k).toString());


    }
}
