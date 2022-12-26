def solution(x, n):
    answer = []
    x_copy = x
    while len(answer) < n:
        answer.append(x)
        x += x_copy
    return answer
