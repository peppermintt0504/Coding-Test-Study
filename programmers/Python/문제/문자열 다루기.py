def solution(s):
    if len(s) == 4 or len(s) == 6 :
        for i in s :
            if ord(i) >= 28 and ord(i) <= 57 :
                answer = True
            else :
                answer = False
                break
    else : answer = False
    return answer
