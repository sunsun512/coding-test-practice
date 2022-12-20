def solution(nums):
    count = set(nums)
    answer = len(nums)/2 if len(count) > len(nums)/2 else len(count) 

    return answer
