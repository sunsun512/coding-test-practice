from collections import Counter
from functools import reduce

def solution(clothes):
    counter = Counter([type for clothe, type in clothes])
    answer = reduce(lambda acc, cur: acc*(cur+1), counter.values(), 1) - 1
    return answer
