def solution(ingredient):
    answer=0
    li=[]
    for i in ingredient: 
        li.append(i)
        if len(li)>=4 and li[-4]==1 and li[-3]==2 and li[-2]==3 and li[-1]==1: 
            for _ in range(4):
                li.pop()
            answer+=1
    return answer
