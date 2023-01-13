def solution(N,stages):
    member = len(stages)
    counting = {}
    result = {}
    for stage in stages:
        if counting.get(stage):
            counting[stage] += 1
        else:
            counting[stage] = 1
    for stage in range(1,N+1):
        if member == 0 :
            result[stage] = 0
        else:
            result[stage] = (counting.get(stage,0) / member)
            member -= counting.get(stage,0)

    return sorted(result,key=lambda x: result[x], reverse = True)
