def solution(k, ranges):
    answer = []
    nums =[]
    while k!=1:
        if k not in nums: 
            nums.append(k)
        if k%2 ==0:
            k//=2
        else:
            k= k*3+1
    nums.append(1)
    area=[(nums[i-1]+nums[i])/2 for i in range(1,len(nums))]
    for i in ranges:
        if i[0]+-1*i[1] ==len(area):
            cal_integer=0
        elif i[0]+-1*i[1]>len(area):
            cal_integer = -1
        else:
            cal_integer = sum(area[i[0]:])-sum(area[-1:i[1]-1:-1])
        answer.append(cal_integer)
    return answer
