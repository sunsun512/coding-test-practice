def solution(phone_book):
    answer = True
    hash = {}
    
    for i in phone_book:
        hash[i] = 1
        
    for i in phone_book:
        temp = ''
        for j in i:
            temp += j
            if temp in hash and temp != i:
                return False
    return answer
