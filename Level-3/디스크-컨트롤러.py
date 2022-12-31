import heapq

def solution(jobs): 
    answer, now, i = 0, 0, 0
    start = -1
    heap = []
    
    while i < len(jobs):
        # 현재 시점에서 처리할 수 있는 작업들 저장
        for job in jobs:
            if start < job[0] <= now:
                heapq.heappush(heap, (job[1], job[0]))
        
        if heap:
            cur = heapq.heappop(heap)
            start = now
            now += cur[0]
            answer += now - cur[1]
            i += 1
        else:
            now += 1
            
    return answer // i
