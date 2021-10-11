#월간 코드 챌린지 시즌 1

def solution(a, b):
    answer = 0
    
    for one, two in zip(a,b) :
        answer += one * two
    
    return answer
