### 829. Consecutive Numbers Sum  **Hard**

Given a positive integer N, how many ways can we write it as a sum of consecutive positive integers?

Example 1:
Input: 5
Output: 2
Explanation: 5 = 5 = 2 + 3

Example 2:
Input: 9
Output: 3
Explanation: 9 = 9 = 4 + 5 = 2 + 3 + 4

Example 3:
Input: 15
Output: 4
Explanation: 15 = 15 = 8 + 7 = 4 + 5 + 6 = 1 + 2 + 3 + 4 + 5

#### Note: 1 <= N <= 10 ^ 9.
#### Solution
N = (X + 1) + (X + 2) + (X + 3) +...+ (X + K) = K*X + (1 + K) * K / 2
* Solution 1 [consecutiveNumbersSum1](../../Java/src/Math/ConsecutiveNumbersSum_829.java)
   * N = (1 + K) * K / 2 + k * x
    -> N - (1 + K) * K / 2  = K * X
    -> (N - (1 + K) * K / 2) / K = X 
    -> x is integer => IF (N - (1 + K) * K / 2) % K == 0 THEN res++

* Solution 2 [consecutiveNumbersSum2](../../Java/src/Math/ConsecutiveNumbersSum_829.java)
    * follow solution 1, we can get 2 won't effect the total number of result combination, 
       so we can make N get all the 2s out first