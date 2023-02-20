import math

def solution(x, y, n):
    dp = [float('inf')]*(3_000_001)
    
    dp[x] = -1
    dp[y] = 0
    
    for num in range(max(y-n, max(y//2, y//3)), x-1, -1):
        dp[num] = min(dp[num+n]+1, min(dp[num*2]+1, dp[num*3]+1))
    
    return -1 if dp[x]>= float('inf') else dp[x]
