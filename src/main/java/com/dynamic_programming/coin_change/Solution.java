package com.dynamic_programming.coin_change;

import java.util.Arrays;

/*
You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
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


// Recursion Solution
// TC: O(nofCoins^amount)
// SC: O(amount)
//class Solution {
//    public int coinChange(int[] coins, int amount) {
//        int coinsCount = numberOfCoins(coins, amount);
//        return coinsCount == Integer.MAX_VALUE ? -1 : coinsCount;
//    }
//
//    public int numberOfCoins(int[] coins, int amount){
//        if(amount < -1){
//            return -1;
//        }
//        if(amount == 0){
//            return 0;
//        }
//        int no_of_coins = Integer.MAX_VALUE;
//        for(int coin: coins){
//            int result = numberOfCoins(coins, amount-coin);
//            if(result >= 0){
//                no_of_coins = Math.min(no_of_coins, result + 1);
//            }
//        }
//        return no_of_coins;
//    }
//}

//Recursion with memoization(top-down approach)
//TC: O(amount * No Of Coins)
//SC: O(amount) + O(amount) = 2*O(amount) = O(amount)
//class Solution {
//    public int coinChange(int[] coins, int amount) {
//        int[] dp = new int[amount+1];
//        Arrays.fill(dp, -1);
//        dp[0] = 0;
//        int coinsCount = numberOfCoins(coins, amount, dp);
//        return coinsCount == Integer.MAX_VALUE ? -1 : coinsCount;
//    }
//
//    public int numberOfCoins(int[] coins, int amount, int[] dp){
//        if(amount < 0){
//            return Integer.MAX_VALUE;
//        }
//        if(amount == 0){
//            return 0;
//        }
//        if(dp[amount] != -1){
//            return dp[amount];
//        }
//        int no_of_coins = Integer.MAX_VALUE;
//        for(int coin: coins){
//            int result = numberOfCoins(coins, amount-coin, dp);
//            if(result != Integer.MAX_VALUE){
//                no_of_coins = Math.min(no_of_coins, result + 1);
//            }
//        }
//        return dp[amount] = no_of_coins;
//    }
//}

//Tabulation Bottom-up approach
// TC: O(amount*noOfCoins)
// SC: O(amount)
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for(int amt = 1 ; amt <= amount; amt++){
            int noOfCoins = Integer.MAX_VALUE;
            for(int coin: coins){
                int remainingAmount = amt-coin;
                if(remainingAmount >= 0 && dp[remainingAmount] != Integer.MAX_VALUE){
                    noOfCoins = Math.min(noOfCoins, dp[remainingAmount]+1);
                }
            }
            dp[amt] = noOfCoins;
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}