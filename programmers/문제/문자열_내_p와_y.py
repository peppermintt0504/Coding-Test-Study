def solution(s):
    answer = True
    p = 0
    y = 0
    
    
    for i in s.lower() :
        if i == 'p' : p += 1
        if i == 'y' : y += 1
       
    print(s)
    print(p,"/",y)
    if p != y : answer = False
    
    return answer
