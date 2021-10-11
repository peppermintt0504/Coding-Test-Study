def solution(strings, n):
    answer = []
    temp = []
    
    for i in strings :
        temp.append(i[n] + i)
    temp.sort()
    for i in range(len(temp)) :
        answer.append(temp[i][1:])
   
    return answer
