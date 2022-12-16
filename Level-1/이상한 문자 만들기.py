def solution(s):
    answer = ""
    s_toarr = s.split(" ")
    for i in s_toarr:
        for x in range(len(i)):
            if x == 0 or x % 2 == 0:
                answer += i[x].upper()
            else:
                answer += i[x].lower()
        answer += " "
    answer = answer[0 : -1]
    return answer
