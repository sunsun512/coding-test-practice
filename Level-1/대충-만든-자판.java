import java.util.HashMap;
import java.util.Map;
// 출처 https://velog.io/@as9587/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EC%97%B0%EC%8A%B5-%EB%8C%80%EC%B6%A9-%EB%A7%8C%EB%93%A0-%EC%9E%90%ED%8C%90-JAVA-23%EB%85%84-2%EC%9B%94-25%EC%9D%BC
//키의 개수 1~100개
//자판을 이용해 특정 문자열을 작성할 때, 키를 최소한으로 몇번 눌러야 하는지 ?
class Solution {
    final int NOT_VALID = 1000;
    final int IMPOSSIBLE = -1;

    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];

        Map<Character, Integer> dict = new HashMap<>();
        for (String key : keymap) {
            for (int i = 0; i < key.length(); i++) {
                char curChar = key.charAt(i);
                int curPushNum = i + 1;
                int findPushNum = dict.getOrDefault(curChar, NOT_VALID);

                if (curPushNum < findPushNum) {
                    dict.put(curChar, curPushNum);
                }
            }
        }

        for (int idx = 0; idx < targets.length; idx++) {
            int tempVal = 0;
            boolean fail = false;

            String curStr = targets[idx];
            for (int i = 0; i < curStr.length(); i++) {
                char curChar = curStr.charAt(i);
                int findPushNum = dict.getOrDefault(curChar, NOT_VALID);

                if (findPushNum == NOT_VALID) {
                    fail = true;
                    break;
                }

                tempVal += findPushNum;
            }

            if (fail) {
                answer[idx] = IMPOSSIBLE;
            } else {
                answer[idx] = tempVal;
            }

        }
        
        return answer;
    }
}
