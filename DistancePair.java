/*
Distance Pair
Medium

Given a list of integers nums, find a pair i < j, such that nums[i] + nums[j] + (i - j) is maximized, and return the value.

Constraints

n ≤ 100,000 where n is the length of nums.
Example 1
Input
nums = [5, 5, 1, 1, 1, 7]
Output
9
Explanation
Picking the two 5 is the best since its score is 5 + 5 + 0 - 1 = 9.

If we had picked the rightmost 5 with the 7 we'd get 5 + 7 + (1 - 5) = 8
*/

import java.util.*;

class Solution {
    public int solve(int[] nums) {
        int n = nums.length-1;
        int maxLeft = nums[n]-n;
        int maxPair = (nums[n-1]+n-1)+maxLeft;

        for(int i=n-2;i>=0;i--){
            maxLeft = Math.max(nums[i+1]-(i+1),maxLeft);
            int sum = (nums[i]+i)+maxLeft;
            maxPair=Math.max(sum,maxPair);
        }
        return maxPair;
    }
}