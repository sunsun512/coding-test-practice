import java.util.*;

class Solution {
    // 최소연산 - BFS (너비 우선 탐색)
  // 경우에 따라 DP보다 느릴 수도 있음.
    public int solutionBFS(int x, int y, int n) {
        Queue<int[]> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        queue.offer(new int[]{x, 0}); // {현재값, 연산횟수}
        visited.add(x);

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int value = current[0];
            int count = current[1];

            if (value == y) {
                return count; // 목표 도달
            }

            // 가능한 다음 연산들
            int[] nextValues = {value + n, value * 2, value * 3};
            for (int next : nextValues) {
                if (next <= y && !visited.contains(next)) { 
                    visited.add(next);
                    queue.offer(new int[]{next, count + 1});
                }
            }
        }

        return -1; // 도달 불가
    }
    
    // 동적 계획
  // 메모리를 y 크기만큼 써야 함 → y가 크면 부담.
    public int solutionDP(int x, int y, int n) {
        int[] dp = new int[y + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[x] = 0;

        for (int i = x; i <= y; i++) {
            if (dp[i] == Integer.MAX_VALUE) continue;

            if (i + n <= y) {
                dp[i + n] = Math.min(dp[i + n], dp[i] + 1);
            }
            if (i * 2 <= y) {
                dp[i * 2] = Math.min(dp[i * 2], dp[i] + 1);
            }
            if (i * 3 <= y) {
                dp[i * 3] = Math.min(dp[i * 3], dp[i] + 1);
            }
        }

        return dp[y] == Integer.MAX_VALUE ? -1 : dp[y];
    }
}
