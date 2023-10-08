package org.heapinterviewquestions;

import java.util.PriorityQueue;
import java.util.Collections;


public class MaxAndMinHeapImplementation {

    public static void minHeap(int[] arr){
        PriorityQueue<Integer> heap = new PriorityQueue<>(); /*By default min heap*/

        for(int i = 0; i <arr.length; i++){
            heap.add(arr[i]);
            System.out.print(heap.peek() + " ");
        }

        System.out.println();

        for(int i = 0; i< arr.length; i++){
            heap.poll();
            System.out.println(heap.peek() + " ");
        }

        System.out.println();
    }

    public static void maxHeap(int[] arr){
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder()); /* Max Heap*/

        for(int i = 0; i < arr.length; i++){
            heap.add(arr[i]);
            System.out.println(heap.peek() + " ");
        }

        System.out.println();

        for(int i = 0; i < arr.length; i++){
            heap.poll();
            System.out.println(heap.peek() + " ");
        }

        System.out.println();
    }

    public static void main(String [] args){

        int[] arr = {10,7,11,5,2,13,1,45};

        MaxAndMinHeapImplementation.minHeap(arr);
        MaxAndMinHeapImplementation.maxHeap(arr);
    }

}
