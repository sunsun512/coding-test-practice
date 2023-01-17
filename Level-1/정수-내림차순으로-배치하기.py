def solution(n):
    a = sorted(list(map(int, str(n))), reverse = True)
    answer = ''.join(list(map(str, a)))
    return int(answer)
