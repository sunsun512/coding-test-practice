from collections import Counter

def solution(k, tangerine):
    answer = 0
    count = Counter(tangerine)
    
    for i in  sorted(list(count.values()), reverse = True):
        k -= i
        answer += 1
        if k <= 0:
            break
            
    return answer
