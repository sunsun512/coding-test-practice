from heapq import heappush, heappushpop

def solution(n, k, enemy):
    answer = 0
    heap = []
    total = 0
    for e in enemy:
        total += e
        if total <= n:
            heappush(heap, -e)
            answer += 1
        elif k > 0 :
            k -= 1
            total += heappushpop(heap, -e)
            answer += 1
        else:
            break
    return answer
