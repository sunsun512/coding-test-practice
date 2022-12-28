def solution(food):
    answer = '0' 
    for i in range(len(food)-1,0,-1): 
        answer=str(i)*(food[i]//2)+answer
        answer=answer+str(i)*(food[i]//2)
    return answer
