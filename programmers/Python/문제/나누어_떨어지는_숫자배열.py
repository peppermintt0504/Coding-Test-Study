def solution(arr, divisor):
    answer = []
    print(len(answer))
    for i in range(len(arr)) :
        if arr[i] % divisor == 0 :
            answer.append(arr[i])
    answer.sort()
    if len(answer) == 0 :
        answer.append(-1)
    return answer
