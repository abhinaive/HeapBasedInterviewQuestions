package org.coderarmyheapinterviewques;

import java.util.Collections;
import java.util.PriorityQueue;

public class ProfitMaximization {

    // Price of each seat is equal to no. of seats int that row
    // Sell these tickets to some given people
    public static int getMaximumProfitBySellingSeats(int [] arr, int numOfPeople){

        int maxProfit = 0;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0; i < arr.length; i++){
            maxHeap.add(arr[i]);
        }

        while(numOfPeople != 0 && !maxHeap.isEmpty()){
            int ticket = maxHeap.poll();

            maxProfit = maxProfit + ticket;

            if((ticket - 1) != 0){
                maxHeap.add(ticket - 1);
            }
            numOfPeople--;
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int seats [] = new int []{6,4,2,3};    // 22
        int numOfPeople = 5;

//        int seats [] = new int []{2,3};   // 7
//        int numOfPeople = 3;

        System.out.println(getMaximumProfitBySellingSeats(seats,numOfPeople));
    }

}
