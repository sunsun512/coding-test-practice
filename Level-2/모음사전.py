from itertools import product
# 중복 순열을 이용해서 가능한 모든 조합을 구한 후 index를 찾았다.

def solution(word):
    words = []
    for i in range(1, 6):
        for c in product(['A', 'E', 'I', 'O', 'U'], repeat=i):
            words.append(''.join(list(c)))

    words.sort()
    return words.index(word) + 1
  
 # 등비수열의 합을 이용한 풀이
def solution_(word):
    answer = 0
    for i, n in enumerate(word):
        answer += (5 ** (5 - i) - 1) / (5 - 1) * "AEIOU".index(n) + 1
    return answer
