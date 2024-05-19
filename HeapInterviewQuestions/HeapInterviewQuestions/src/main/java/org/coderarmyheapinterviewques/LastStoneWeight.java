package org.coderarmyheapinterviewques;

import java.util.Collections;
import java.util.PriorityQueue;

public class LastStoneWeight {

    // Two Stones of max weight are collided at a time
    public static int getWeightOfLastStoneLeftAfterCollision(int [] arr ){

        int diffOfWeight;

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0; i < arr.length; i++){
            maxHeap.add(arr[i]);
        }




        while(maxHeap.size() > 1){
            int stone_1 = maxHeap.poll();
            int stone_2 = maxHeap.poll();

 /*         No need since its a max heap so top will always be greater
            if(stone_1 > stone_2){
                diffOfWeight = stone_1 - stone_2;
            }else{
                diffOfWeight = stone_2 - stone_1;
            }
 */
            diffOfWeight = stone_1 - stone_2;

            maxHeap.add(diffOfWeight);
        }

        return maxHeap.isEmpty() ? 0 : maxHeap.peek();  // If Priority queue is empty for case [2,2] then return 0
    }

    public static void main(String[] args) {
        int [] stones = new int []{2,7,4,1,8,1};
//      int [] stones = new int []{2,2};

        System.out.println(getWeightOfLastStoneLeftAfterCollision(stones));
    }
}
