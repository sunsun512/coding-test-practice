import java.util.*;

class Solution {
    private static final int MOD = 1_000_000_007;

    public int solution(int n, int count) {
        if (count < 1 || count > n) return 0;
        if (n == 1) return (count == 1) ? 1 : 0;

        long[][] dp = new long[n + 1][n + 1];
        dp[1][1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                long addVisible = dp[i - 1][j - 1]; // 새 종류가 보이는 경우
                long notVisible = (2L * (i - 1) % MOD) * dp[i - 1][j] % MOD; // 보이지 않는 경우
                dp[i][j] = (addVisible + notVisible) % MOD;
            }
        }

        return (int) dp[n][count];
    }
}

// cache[i][j] : i종류의 빌딩을 가지고 j종류의 빌딩이 구분되게 세우는 경우의 수
//
// cache[i+1][j+1], 즉, i+1번째 종류의 빌딩이 보여서 j+1종류가 되려면 맨 앞에 세워야 함.
// 따라서 cache[i+1][j+1] = cache[i][j]
//
// cache[i+1][j] : 즉, i+1번째 종류의 빌딩이 가려지게 세우려면,
// 두 빌딩은 무조건 이어붙인 상태로 배치되고, 2*i 개의 큰 빌딩들 오른쪽 아무데나 들어가도 되므로
// 2*i 종류.
// 따라서 cache[i+1][j] = cache[i][j] * 2*i
//
// 정리하면
// cache[i][j] = cache[i-1][j-1] + cache[i-1][j] * 2*(i-1)
// https://www.ai-bio.info/programmers/140105
