def solution(s):
    answer = 0
    cnt_x, cnt_notx = 0, 0
    for word in s:
        if cnt_x == cnt_notx:
            answer += 1
            k = word
        if k == word:
            cnt_x += 1
        else:
            cnt_notx += 1
    return answer
