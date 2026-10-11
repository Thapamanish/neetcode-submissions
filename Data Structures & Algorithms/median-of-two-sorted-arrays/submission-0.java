class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        int[] mergedArr = new int[m + n];

        int a = 0;
        int b = 0;
        int idx = 0;

        while(a < m && b < n){
            if(nums1[a] < nums2[b]){
                mergedArr[idx++] = nums1[a++]; 
                System.out.println("idx" + idx);
            } else {
                 System.out.println("idx" + idx);
                mergedArr[idx++] = nums2[b++];
            }
        }

        while(a < m){
             mergedArr[idx++] = nums1[a++]; 
        }

        while( b < n){
            mergedArr[idx++] = nums2[b++];
        }

        System.out.println(Arrays.toString(mergedArr));

        double median = 0;
        int len = m + n;
        if(len % 2 == 0){
            median = (double)(mergedArr[len / 2] + mergedArr[len / 2 - 1]) / 2;
        } else {
            median = (double) (mergedArr[len / 2]);
        }

        return median;


    }
}
