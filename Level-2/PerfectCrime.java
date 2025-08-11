import java.util.Arrays;

// DP(동적 계획법)
/* 
  dp 테이블에서 행은 물건 개수 진행 상태, 열은 A의 누적 흔적 수를 나타냄.
  각 상태에서 A가 선택할지, B가 선택할지를 탐색.
  최종적으로 dp[len][aTrace]가 B도둑의 흔적이 m 미만인 상태 중 A의 최소 흔적을 찾음.
  시간복잡도: O(물건 개수 × n) → 최대 50×100 정도면 충분히 가능. 
 */
class Solution {
    public int solution(int[][] info, int n, int m) {
        int len = info.length;
        int INF = 1000000; // 불가능을 나타내는 큰 값

        // dp[i][aTrace] = i번째까지 훔쳤을 때, B의 최소 누적 흔적
        int[][] dp = new int[len + 1][n];
        for (int[] row : dp) {
            Arrays.fill(row, INF);
        }

        dp[0][0] = 0; // 초기 상태

        for (int i = 0; i < len; i++) {
            for (int aTrace = 0; aTrace < n; aTrace++) {
                if (dp[i][aTrace] == INF) continue; // 불가능한 상태는 스킵
                int bTrace = dp[i][aTrace];

                // 1) A가 훔치는 경우
                int newATrace = aTrace + info[i][0];
                if (newATrace < n) {
                    dp[i + 1][newATrace] = Math.min(dp[i + 1][newATrace], bTrace);
                }

                // 2) B가 훔치는 경우
                int newBTrace = bTrace + info[i][1];
                if (newBTrace < m) {
                    dp[i + 1][aTrace] = Math.min(dp[i + 1][aTrace], newBTrace);
                }
            }
        }

        // 결과 찾기
        int answer = -1;
        for (int aTrace = 0; aTrace < n; aTrace++) {
            if (dp[len][aTrace] < m) {
                if (answer == -1 || aTrace < answer) {
                    answer = aTrace;
                }
            }
        }

        return answer;
    }
} 
