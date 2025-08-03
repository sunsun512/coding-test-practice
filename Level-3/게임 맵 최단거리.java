import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;

        // 방향 벡터: 상, 하, 좌, 우
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        // 방문 체크 및 거리 저장
        int[][] distance = new int[n][m];
        boolean[][] visited = new boolean[n][m];

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        visited[0][0] = true;
        distance[0][0] = 1;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];

            // 네 방향 탐색
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 범위 안이고, 벽이 아니고, 방문하지 않은 곳
                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if (maps[nx][ny] == 1 && !visited[nx][ny]) {
                        queue.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                        distance[nx][ny] = distance[x][y] + 1;
                    }
                }
            }
        }

        // 도착지 확인
        return visited[n-1][m-1] ? distance[n-1][m-1] : -1;
    }
}
