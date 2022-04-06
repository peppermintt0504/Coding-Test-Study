def solution(s):
    answer = ''
    temp = []
    for i in s :
        temp.append(i)
        
    temp.sort(reverse = True)
    for i in temp :
        answer = answer + i
    print(answer)
    return answer
