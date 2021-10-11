#콜라츠 추측

def solution(num):
    answer = 0
    for i in range(502) :
        if   num == 1 : break
        elif i == 501 : 
            answer = -1
            break
        elif num % 2 == 0 :
            num /= 2
            answer += 1
        elif num % 2 == 1 :
            num = num*3 + 1
            answer += 1
        
    return answer
