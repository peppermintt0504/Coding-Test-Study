#연습 문제

def solution(s):
    answer = ''
    j = 0
    for i in range(len(s)) :
        if ord(s[i]) == 32 : j = 1
        if j % 2 ==0 :
            answer += s[i:i+1].upper()
            j = 1
        else :
            answer += s[i:i+1].lower()
            j = 0
    return answer
