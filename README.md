# Distinct Subsequences

## Description
This repository contains a Java solution for the "Distinct Subsequences" problem. The goal is to find the number of distinct subsequences of a given string `s` that match a target string `t`. The solution uses dynamic programming to efficiently calculate the result.

## Problem Statement
**Given two strings `s` and `t`, return the number of distinct subsequences of `s` which equals `t`.**

The test cases are generated so that the answer fits on a 32-bit signed integer.

### Examples
**Example 1:**
```java
Input: s = "rabbbit", t = "rabbit"
Output: 3
Explanation: There are 3 ways to form "rabbit" from "rabbbit".
```

**Example 2:**
```java
Input: s = "babgbag", t = "bag"
Output: 5
Explanation: There are 5 ways to form "bag" from "babgbag".
```

## Solution
The solution uses dynamic programming. The core idea is to build a 2D array `dp`, where `dp[i][j]` represents the number of ways to form the first `j` characters of `t` using the first `i` characters of `s`.

### Algorithm
1. Initialize a 2D array `dp` of size `(m + 1) x (n + 1)` with all zeros.
2. Set `dp[i][0] = 1` for all `i`, since there is only one way to form an empty `t` — by deleting all characters from `s`.
3. Iterate through `s` and `t`:
    - If `s[i-1] == t[j-1]`, then:
      ```java
      dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
      ```
    - Otherwise:
      ```java
      dp[i][j] = dp[i-1][j];
      ```
4. The result is stored in `dp[m][n]`.

### Time and Space Complexity
- **Time complexity:** O(m * n), where `m` is the length of `s` and `n` is the length of `t`.
- **Space complexity:** O(m * n), though this can be optimized to O(n) using a rolling array.

## How to Run
1. Clone the repository:
   ```bash
   git clone https://github.com/dfcifuentesg/appgate-distinct-subsequences
   ```
2. Navigate to the project directory:
   ```bash
   cd distinct-subsequences
   ```
3. Compile and run the program:
   ```bash
   javac Solution.java
   java Solution
   ```
