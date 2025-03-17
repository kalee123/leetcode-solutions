/*
322. Coin Change

you are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.

 

Example 1:

Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1
Example 2:

Input: coins = [2], amount = 3
Output: -1
Example 3:

Input: coins = [1], amount = 0
Output: 0
 

Constraints:

1 <= coins.length <= 12
1 <= coins[i] <= 231 - 1
0 <= amount <= 104

*/


import java.util.Arrays;

class Solution {
    int []dp;
    public int findChange(int[] coins, int target) {
        if (target == 0) 
        {
            return 0;
        }
        if (target < 0)
        {
            return Integer.MAX_VALUE;
        } 
        if (dp[target] != -1) 
        {
            return dp[target];
        }

        int minCoins = Integer.MAX_VALUE;
        for (int coin : coins) 
        {
            int res = findChange(coins, target - coin);
            if (res != Integer.MAX_VALUE) 
            { 
                minCoins = Math.min(minCoins, res + 1);
            }
        }
        dp[target] = minCoins; 
        return dp[target];
    }
    public int coinChange(int[] coins, int amount) {
        dp=new int[amount+1];
        Arrays.fill(dp,-1);
        int result = findChange(coins,amount);
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}
