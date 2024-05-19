package org.coderarmyheapinterviewques;

import java.util.Collections;
import java.util.PriorityQueue;

public class MagicianAndChocolates {

    // Returns maximum number of chocolates that one can eat given that half of chosen
    // batch is replenished everytime you pick a batch to eat
    public static int getMaximumNumberOfCocholatesThatCanBeEaten(int [] arr, int givenTime){

        int maxNumOfChoclates = 0;

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0; i < arr.length; i++){
            maxHeap.add(arr[i]);
        }

        while(givenTime != 0 && !maxHeap.isEmpty()){
            int choc = maxHeap.poll();
            maxNumOfChoclates = maxNumOfChoclates + (choc);

            if(choc/2 != 0){
                maxHeap.add(choc/2);
            }

            givenTime--;
        }
        return maxNumOfChoclates;
    }

    public static void main(String[] args) {

        int arr [] = new int []{2,4,6,8,10};
        int givenTime = 5;

//        int arr [] = new int []{6,5};
//        int givenTime = 3;

        System.out.println(getMaximumNumberOfCocholatesThatCanBeEaten(arr,givenTime));
    }
}
