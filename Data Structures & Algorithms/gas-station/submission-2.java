/*
we just need to calculate if the circuit can be closed

what if we start from 2
0 + 2
-2
0 + 3
-4

should we try for all the points? and if we are able to return to the curent

gasAvailable
costNext

if(gasAvailable < costNext) return 0

TC - O(n * n)
SC -O(1)

*/

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        
        for(int i = 0;i < gas.length; i++){
            if(gas[i] < cost[i]) continue;

            int last = 0;
            int currGas = last + gas[i];

            int curr = i;
            System.out.println(i);
            while(currGas >= cost[curr]){
          
                last = currGas - cost[curr];
                curr = (1 + curr) % gas.length;
                 
                if(curr == i) return i;

                currGas = last + gas[curr];


            }
            
            if(curr < i) break;
            i = curr;
            
        }

        return -1;

    }
}
