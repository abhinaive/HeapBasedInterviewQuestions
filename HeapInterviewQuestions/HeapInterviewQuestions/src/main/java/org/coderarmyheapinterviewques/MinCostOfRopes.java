package org.coderarmyheapinterviewques;

import java.util.PriorityQueue;

public class MinCostOfRopes {

    public static long findCombinedMinCostOfRopesTakingTwoRopesAtATime(long [] arr){

        long sumofAllCost = 0;

        PriorityQueue<Long> minHeap = new PriorityQueue<>();

        for(int i = 0; i < arr.length; i++){
            minHeap.add(arr[i]);
        }

        if(arr.length==1)  // no need to connect therefore 0 cost
            return 0;

        while(minHeap.size() > 1){
            long rope_1 = minHeap.poll();
            long rope_2 = minHeap.poll();
            sumofAllCost = sumofAllCost + (rope_1 + rope_2);

            minHeap.add(rope_1 + rope_2);
        }
        return sumofAllCost;
    }

    public static void main(String[] args) {

        long [] ropeCost = new long []{4,3,2,6};

        System.out.println(findCombinedMinCostOfRopesTakingTwoRopesAtATime(ropeCost));  // 29

    }
}
