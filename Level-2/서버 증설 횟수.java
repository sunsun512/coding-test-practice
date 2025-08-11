import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        Queue<Integer> active = new LinkedList<>(); // 현재 가동 중인 서버들의 만료 시간 저장 큐

        for (int i = 0; i < 24; i++) {
            int need = players[i] / m;  // i시~i+1시 필요한 서버 대수 (몫만 계산, 올림 처리 안 함)
             
            // 1. 만료된 서버 반납
            while (!active.isEmpty() && active.peek() <= i) {
                active.poll();
            }
            
            // 2. 현재 가동 중인 서버 수
            int current = active.size();

            // 3. 부족하면 증설
            if (current < need) {
                int newServer = need - current;
                answer += newServer; // 증설 횟수 누적
                
                // 4. 증설한 서버들의 만료 시간을 큐에 기록
                for (int j = 0; j < newServer; j++) {
                    active.offer(i + k); // 가동중인 서버 추가
                }
            }
        }
        return answer;
    }
}
