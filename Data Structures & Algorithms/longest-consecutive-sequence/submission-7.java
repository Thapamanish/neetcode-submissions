/*
given : array of integers

find: longest consecutive sequence of numbers


2 20 4 10 3 4 5

2 3 4 5
20
10


we can do is sort the array
ans = 1
check from 2nd element as n-1 = n ? if yes then store it in ans we can use a flag to check if
consecutive is broken or not

but it is O(nlogn)

we can use hashset and check if a element is the start of the sequence and then try adding and
counting it till the end of that sequence

for 2 3 4 5 if anthing else then 2  comes we skip but if 2 cames we start coutining until we have
last element in the sequence which is 5 then we store it in ans and start again

TC ->O(n) + O(n) + O(n) traverse and if there is one sequence then we have to do plus
SC -> O(n)

*/
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> seen = new HashSet<>();

        for(int num: nums) seen.add(num);
        int longest = 0;
        for(int num: nums){
            if(seen.contains(num - 1)) continue;
            int curr = num;
            int count = 1;
            while(seen.contains(++curr)){
                count++;
            }
            longest = Math.max(longest, count);
        }

        return longest;
    }
}

// class Solution {
//     public int longestConsecutive(int[] nums) {
//         if(nums.length == 0) return 0;
//         Arrays.sort(nums);
//         int ans = 1;
//         boolean flag = true;
//         int currentAns = 1;
//         for (int i = 1; i < nums.length; i++) {
//             if (flag)
//                 currentAns = 1;
//             if (nums[i - 1] == nums[i]) {
//                 continue;
//             }
//             if (nums[i - 1] == nums[i] - 1) {
//                 currentAns++;
//                 flag = false;
//                 ans = Math.max(ans, currentAns);
//             } else {
//                 flag = true;
//             }
//         }

//         return ans;
//     }
// }
