/*
there is only one element which is more than once in the array, if we find it return true else false

TC - O(n)
SC - O(1)


*/


class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();

        for(int num: nums){
            if(!seen.add(num)) return true;
        }

        return false;
       
    }
}