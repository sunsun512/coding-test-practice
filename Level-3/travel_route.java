import java.util.*;

class Solution {
    public String[] solution(String[][] tickets) {
        // 그래프 생성: 출발지 -> (도착지들을 알파벳 순으로 저장)
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        for (String[] ticket : tickets) {
            graph.computeIfAbsent(ticket[0], k -> new PriorityQueue<>()).add(ticket[1]);
        }

        // 결과 경로를 저장할 리스트
        LinkedList<String> route = new LinkedList<>();
        dfs("ICN", graph, route);

        return route.toArray(new String[0]);
    }

    private void dfs(String airport, Map<String, PriorityQueue<String>> graph, 
                     LinkedList<String> route) {
        PriorityQueue<String> dests = graph.get(airport);
        while (dests != null && !dests.isEmpty()) {
            String next = dests.poll();
            dfs(next, graph, route);
        }
        // 경로를 거꾸로 저장 (마지막에 addFirst)
        route.addFirst(airport);
    }

}
