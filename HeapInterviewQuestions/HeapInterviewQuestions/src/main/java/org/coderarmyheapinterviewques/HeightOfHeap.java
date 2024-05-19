package org.coderarmyheapinterviewques;

// Time Complexity : log base 2 N where N = size of array or heap :  2(pow)H = N
public class HeightOfHeap {


    public static int findHeightOfHeap(int [] heapArray){

        if(heapArray.length == 1)  // Edge Case : if there is single node in Heap
            return 1;

        int height = 0;
        int sizeOfHeap = heapArray.length;

        while(sizeOfHeap > 1){
            height++;
            sizeOfHeap = sizeOfHeap/2;
        }

        return height;
    }

    public static void main(String[] args) {

        int [] heapArr = new int [] {1,3,6,5,9,8};
        System.out.println(findHeightOfHeap(heapArr));

    }
}
