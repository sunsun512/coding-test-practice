import math


def solution(fees, records):
    answer = []
    cars = dict()
    for i in records:
        time, number, flag = i.split()
        totalTime = int(time[:2]) * 60 + int(time[-2:])
        if number in cars:
            cars[number].append(totalTime)
        else:
            cars[number] = [totalTime]
    for i in cars:
        if len(cars[i]) % 2 == 1:
            cars[i].append((23 * 60 + 59))
    for i in cars:
        times = 0
        for j in range(0, len(cars[i]), 2):
            times += cars[i][j + 1] - cars[i][j]
        if times <= fees[0]:
            answer.append([i, fees[1]])
        else:
            times -= fees[0]
            fee = fees[1]
            fee += math.ceil(times / fees[2]) * fees[3]
            answer.append([i, fee])

    return [i[1] for i in sorted(answer, key=lambda x: int(x[0]))]
