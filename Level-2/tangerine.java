import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        // 1. 크기별 개수 세기
        Map<Integer, Integer> map = new HashMap<>();
        for (int size : tangerine) {
            map.put(size, map.getOrDefault(size, 0) + 1);
        }

        // 2. 개수만 뽑아서 내림차순 정렬
        List<Integer> counts = new ArrayList<>(map.values());
        counts.sort(Collections.reverseOrder());

        // 3. 큰 개수부터 k 채우기
        int kind = 0;
        for (int c : counts) {
            k -= c;
            kind++;
            if (k <= 0) break;
        }

        return kind;
    }
}
