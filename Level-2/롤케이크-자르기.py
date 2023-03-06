from collections import Counter

def solution(topping):
    answer = 0
    be_ = set()
    af = Counter(topping)

    for t in topping:
        be_.add(t)
        af[t] -= 1

        if af[t] == 0:
            del af[t]
        if len(be_) == len(af):
            answer += 1

    return answer
