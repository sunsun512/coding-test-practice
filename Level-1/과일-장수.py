def solution(k, m, score):
    answer = 0
    score.sort(reverse=True) #점수 내림차순 정렬
    answer = sum([score[i+m-1] for i in range(0,len(score),m) 
                  if i+m <= len(score)])*m  
    return answer
