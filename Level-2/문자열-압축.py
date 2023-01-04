def solution(s):
    ss = len(s)//2 + 1
    answer = len(s)
    for i in range(1, ss):
        count = 1
        sub_ans = ''
        sub = s[:i]
        for j in range(i, len(s), i):
            if sub == s[j:j+i]:
                count += 1
            else:
                if count == 1:
                    sub_ans += sub
                else:
                    sub_ans += str(count) + sub
                sub = s[j:j+i]
                count = 1
        if count <= 1:
            sub_ans += sub
        else:
            sub_ans += str(count) + sub
        answer = min(answer, len(sub_ans))
    return answer
