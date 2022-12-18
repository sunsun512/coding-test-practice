import collections
answer = []
graph = collections.defaultdict(list)

def dfs(s):
    while graph[s]:
        dfs(graph[s].pop(0))

    if not graph[s]:
        answer.append(s)
        return

def solution(tickets):
    
    for a,b in tickets:
        graph[a].append(b)
    for a, b in graph.items():
        graph[a].sort()
        
    dfs("ICN")

    return answer[::-1]
  
  
# 다른 풀이
from collections import deque
from collections import defaultdict

def solution2(tickets):
    answer = []
    tickets.sort(key = lambda x:(x[1], x[0]))
    dic = defaultdict(list)
    for [start, end] in tickets:
        dic[start].append(end)
    for k in dic.keys():
        dic[k].sort(reverse = True)
        
    def DFS():
        stack = ["ICN"]
        while stack:
            start = stack[-1]
            if not dic[start]: # start에서 출발하는 항공편이 없는경우 바로 답에 넣기
                answer.append(stack.pop())
            else:
                stack.append(dic[start].pop())
    DFS()
    return answer[::-1]
