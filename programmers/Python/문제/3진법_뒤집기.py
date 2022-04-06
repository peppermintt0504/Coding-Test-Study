def solution(n):
    answer = 0
    temp = []
    while 1 :
        
        if 3 < n :
            temp.append(int(n%3))
            n = int( n / 3 )
            
        elif 3 == n :
            temp.append(0)
            temp.append(1)
            break
        elif 3 > n :
            temp.append(n)
            break
    
    
    for i in range(len(temp)) :
        answer += pow(3,i) * temp[-i-1]
    
    return answer
