function solution(n) {
  const mod = 1000000007;
  const dp = [1, 1, 3, 10, 23, 62];
  for (let i = 6; i <= n; i++) {
    dp[i] = (dp[i - 1] + dp[i - 2] * 2 + dp[i - 3] * 6 + dp[i - 4] - dp[i - 6] + mod) % mod;
  }
  return dp[n];
}