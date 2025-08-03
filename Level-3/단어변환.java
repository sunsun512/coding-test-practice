import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        if (!Arrays.asList(words).contains(target)) {
            return 0;
        }
        boolean[] visited = new boolean[words.length];
        Queue<Word> queue = new LinkedList<>();
        queue.add(new Word(begin, 0));

        while (!queue.isEmpty()) {
            Word current = queue.poll();

            // 목표 단어 도달 시 단계 반환
            if (current.word.equals(target)) {
                return current.step;
            }

            // 현재 단어와 하나만 다른 단어 탐색
            for (int i = 0; i < words.length; i++) {
                if (!visited[i] && isConvertible(current.word, words[i])) {
                    visited[i] = true;
                    queue.add(new Word(words[i], current.step + 1));
                }
            }
        }

        return 0; // 변환 불가능할 경우
    }
    
    
    private boolean isConvertible(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                diff++;
            }
        }
        return diff == 1;
    }

    // 단어와 단계 수를 저장하는 클래스
    class Word {
        String word;
        int step;

        Word(String word, int step) {
            this.word = word;
            this.step = step;
        }
    }
}
