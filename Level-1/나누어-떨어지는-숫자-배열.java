import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        int[] answer = Arrays.stream(arr).filter(factor -> factor % divisor == 0).toArray();
          if(answer.length == 0) answer = new int[] {-1}; //나누어 떨어지는 원소가 없으면 -1
          java.util.Arrays.sort(answer);
          return answer;
    }
}
