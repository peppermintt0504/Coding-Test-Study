def solution(arr):
    answer = []

    for i in range(len(arr)):
        if i == 0 :
            answer.append(arr[i])
        else :
            if arr[i] == arr[i-1] : 0
            else : answer.append(arr[i])
    
    return answer
