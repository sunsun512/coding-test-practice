def solution(arr1, arr2):
    x = len(arr1)
    y = len(arr2[0])
    answer = [[0]*y for _ in range(x)]

    for i in range(x): 
        lists = []
        for j in range(len(arr2[0])): 
            for k in range(len(arr1[0])): 
                answer[i][j] += arr1[i][k] * arr2[k][j]
    return answer
