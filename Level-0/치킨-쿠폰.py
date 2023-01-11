def solution(chicken):
    answer = 0
    coupone = chicken
    while coupone >= 10:
        coupone -= 10
        answer += 1
        coupone +=1
    return answer
