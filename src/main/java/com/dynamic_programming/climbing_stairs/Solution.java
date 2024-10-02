package com.dynamic_programming.climbing_stairs;

import java.util.Arrays;

//Recursion Solution - Top Down approach
// TC: O(2^n)
// SC: O(N)
//class Solution {
//    public int climbStairs(int n) {
//        if( n < 0){
//            return 0;
//        }
//        if( n == 0){
//            return 1;
//        }
//        return climbStairs(n-1) + climbStairs(n-2);
//    }
//}


//Recursion with memoization(Top-down approach)
// TC: O(N)
// SC: O(N) + O(N) = O(N)
//class Solution {
//    public int climbStairs(int n) {
//        int[] dp = new int[n + 1];
//        Arrays.fill(dp, -1);
//        dp[0] = 1;
//        return climb(n, dp);
//    }
//
//    public int climb(int n, int[] dp) {
//        if (n < 0) {
//            return 0;
//        }
//        if (dp[n] != -1) {
//            return dp[n];
//        }
//        return dp[n] = climb(n - 1, dp) + climb(n - 2, dp);
//    }
//}

// Tabulation(Iterative)(Bottom up approach)
// TC: O(N)
// SC: O(N)
//class Solution {
//    public int climbStairs(int n) {
//        int[] dp = new int[n + 1];
//        Arrays.fill(dp, -1);
//        dp[0] = 1;
//        dp[1] = 1;
//        for(int index = 2; index <= n; index++){
//            dp[index] = dp[index-1] + dp[index-2];
//        }
//        return dp[n];
//    }
//}

// Tabulation with space optimisation(Iterative approach)(Bottom up approach)
//TC: O(N)
//SC: O(1)
class Solution {
    public int climbStairs(int n) {
        int last = 1;
        int lastSecond = 1;
        int current = 0;
        if (n == 1) {
            return 1;
        }
        for (int index = 2; index <= n; index++) {
            current = last + lastSecond;
            lastSecond = last;
            last = current;
        }
        return current;
    }
}

