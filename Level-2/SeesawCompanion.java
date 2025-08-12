import java.util.*;


class Solution {
    public long solution(int[] weights) {
        long count = 0;
        Map<Double, Integer> map = new HashMap<>();

        // weights 정렬하면 중복 처리가 더 쉬워짐
        Arrays.sort(weights);

        for (int w : weights) {
            // 가능한 거리 비율: 2:3, 2:4, 3:4 와 자기 자신(1:1)
            double[] ratios = {1.0, 2.0 / 3.0, 3.0 / 2.0, 2.0 / 4.0, 4.0 / 2.0, 3.0 / 4.0, 4.0 / 3.0};

            for (double r : ratios) {
                double target = w * r;
                if (map.containsKey(target)) {
                    count += map.get(target);
                }
            }

            // 현재 몸무게 저장 (Double로 저장해야 비율 계산 가능)
            map.put((double) w, map.getOrDefault((double) w, 0) + 1);
        }
        return count;
    }
}
