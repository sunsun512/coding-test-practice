import itertools

def solution(number):
    answer = 0
    num_combination = [sum(comb) for comb in itertools.combinations(number,3) if sum(comb) == 0]
    answer = len(num_combination)
        
        
    return answer
