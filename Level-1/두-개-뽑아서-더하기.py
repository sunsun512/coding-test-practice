def solution(numbers):
    answer = []
    numbers.sort()
    
    for i in range(len(numbers)):
        for j in numbers[i+1:]:
            answer.append(numbers[i]+j)
    
    answer = list(set(answer))
    answer.sort()
    return answer
