
def solution(brown, yellow):
    answer = [0, 0]
    sum_ = brown + yellow

    for width in range(sum_, 0, -1):
        if sum_ % width:
            continue
        else:
            height = sum_ / width
            y = (width - 2) * (height - 2)
            b = sum_ - y

            if y == yellow and b == brown:
                answer[0] = width
                answer[1] = height
                break

    return answer
