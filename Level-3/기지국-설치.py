import math

def solution(n, stations, w):
    answer = 0
    idx = 1

    for i in stations:
        if i - w > 0:
            answer += math.ceil(((i - w) - idx) / (w * 2 + 1))        
        idx = i + w + 1

    if idx - 1 < n:
        answer += math.ceil((n - (idx - 1)) / (w * 2 + 1))

    return answer
