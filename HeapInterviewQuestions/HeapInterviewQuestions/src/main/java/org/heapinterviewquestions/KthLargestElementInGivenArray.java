package org.heapinterviewquestions;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthLargestElementInGivenArray {

    private static PriorityQueue<Integer> minHeapFromStream;

    public static int KthLargestElementInGivenArrayUsingMinHeap(int [] arr, int k){

        if(arr.length < k){
            System.out.println("Invalid Case");
            return -1;
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int i = 0; i < k; i++){
            minHeap.add(arr[i]);
        }

        for(int i = k; i < arr.length; i++){
            if(arr[i] > minHeap.peek()){
                minHeap.poll();
                minHeap.add(arr[i]);
            }
        }

        return minHeap.peek();

    }

    public static int KthLargestElementInGivenArrayUsingMaxHeap(int [] arr, int k){

        if(arr.length < k){
            System.out.println("Invalid Case");
            return -1;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0; i < arr.length; i++){
            maxHeap.add(arr[i]);
        }

        for(int i = 0; i < k -1; i++){
            maxHeap.poll();
        }

        return maxHeap.peek();

    }

    public int KthLargestElementInGivenStreamOfNumbersUsingMinHeap(int num, int k){

        if(minHeapFromStream.size() < k){
            minHeapFromStream.add(num);
            return minHeapFromStream.size()  == k ? minHeapFromStream.peek() : -1;
        }

        if(num > minHeapFromStream.peek()){
            minHeapFromStream.poll();
            minHeapFromStream.add(num);

        }

        return minHeapFromStream.peek();

    }

    public static void main(String [] args){

        int [] arr = {10, 7 , 11 , 30 , 20 , 38 , 2 , 45};
        int k = 3;

        System.out.println("The kth largest element in given array using minHeap is : " + KthLargestElementInGivenArrayUsingMinHeap(arr,k));
        System.out.println("The kth largest element in given array using maxHeap is : " + KthLargestElementInGivenArrayUsingMaxHeap(arr,k));

        KthLargestElementInGivenArray kthLargest = new KthLargestElementInGivenArray();
        minHeapFromStream = new PriorityQueue<>();

        System.out.println();
        System.out.print("The kth largest element in given stream using minHeap is :");
        for(int i = 0; i < arr.length; i++){
            System.out.print(kthLargest.KthLargestElementInGivenStreamOfNumbersUsingMinHeap(arr[i],k) + " ,");
        }

    }



}
