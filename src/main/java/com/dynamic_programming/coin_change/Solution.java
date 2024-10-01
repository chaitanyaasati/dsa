package com.dynamic_programming.coin_change;

import java.util.Arrays;

class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] arr = new int[amount+1];
        Arrays.fill(arr, -1);
        int result = minOfCoins(coins, amount, arr);
        if(result != Integer.MAX_VALUE){
            return result;
        }
        return -1;
    }

    public int minOfCoins(int[] coins, int amount, int[] arr){
        if(amount == 0){
            arr[amount] = 0;
            return 0;
        }
        else if(amount < 0){
            return Integer.MAX_VALUE;
        }
        else if(arr[amount] != -1){
            return arr[amount];
        }
        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            int result = minOfCoins(coins, amount - coin, arr);
            if (result != Integer.MAX_VALUE) {
                res = Math.min(res, result + 1);
            }
        }
        if(res != Integer.MAX_VALUE){
            arr[amount] = res;
        }
        return res;
    }
}

/*
Above is recursion with memoization solution(top-down approach)
TC: O(n*amount)
SC: O(amount)

For other solutions:
Recursion(top-down approach)
TC: O(n^amount)
n = length of coins array

Tabutation method(Bottom-up Approach)
TC: O(n*amount)
SC: O(amount)
 */