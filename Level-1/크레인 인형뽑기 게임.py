from collections import deque

def solution(b, m):
    m = deque(m)
    bucket = []
    cnt = 0
    
    while m:
        move = m.popleft()

        for i in range(len(b)):
            doll = b[i][move-1]

            if doll != 0:
                b[i][move -1] = 0

                if bucket and bucket[-1] == doll:
                    cnt += 2
                    bucket.pop()
                else:
                    bucket.append(doll)
                break
    
    return cnt
