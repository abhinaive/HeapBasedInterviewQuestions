package org.heapinterviewquestions;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthSmallestElementInGivenArray {

    private static PriorityQueue<Integer> maxHeapFromStream;

    public static int KthSmallestElementInGivenArrayUsingMaxHeap(int [] arr, int k){

        if(arr.length < k){
            System.out.println("Invalid case");
            return -1;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0; i < k; i++ ){
            maxHeap.add(arr[i]);
        }

        for(int i = k; i < arr.length; i++){
            if(arr[i] < maxHeap.peek()){
                maxHeap.poll();
                maxHeap.add(arr[i]);
            }
        }
        return maxHeap.peek();
    }

    public static int KthSmallestElementInGivenArrayUsingMinHeap(int [] arr, int k){

        if(arr.length < k){
            System.out.println("Invalid case");
            return -1;
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int i = 0; i < arr.length; i++ ){
            minHeap.add(arr[i]);
        }

        for(int i = 0; i < k - 1; i++){
                minHeap.poll();
        }

        return minHeap.peek();
    }

    public int KthSmallestElementInGivenStreamOfNumbersUsingMaxHeap(int num, int k){

        if(maxHeapFromStream.size() < k){
            maxHeapFromStream.add(num);
            return maxHeapFromStream.size()  == k ? maxHeapFromStream.peek() : -1;
        }

        if(num < maxHeapFromStream.peek()){
            maxHeapFromStream.poll();
            maxHeapFromStream.add(num);
        }
        return maxHeapFromStream.peek();
    }

    public static void main(String[] args) {

        int [] arr = {10, 7 , 11 , 30 , 20 , 38 , 2 , 45};
        int k = 3;
        System.out.println("The kth Smallest element in given array using maxHeap is : " + KthSmallestElementInGivenArrayUsingMaxHeap(arr,k));
        System.out.println("The kth largest element in given array using minHeap is : "  + KthSmallestElementInGivenArrayUsingMinHeap(arr,k));

        KthSmallestElementInGivenArray kthSmallest = new KthSmallestElementInGivenArray();
        maxHeapFromStream = new PriorityQueue<>(Collections.reverseOrder());

        System.out.println();
        System.out.print("The kth Smallest element in given stream using maxHeap is : ");
        for(int i = 0; i < arr.length; i++){
            System.out.print(kthSmallest.KthSmallestElementInGivenStreamOfNumbersUsingMaxHeap(arr[i],k) + " ,");
        }

    }

}
