class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int low = 0;
        int high = numbers.length - 1;

        while(low <= high){
            int twoSum = numbers[low] + numbers[high]; 
            if(twoSum == target) break;
            else if(twoSum > target) high--;
            else low++;
        }

        return new int[]{low + 1, high + 1};
    }
}
