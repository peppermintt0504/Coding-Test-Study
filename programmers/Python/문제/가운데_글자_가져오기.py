def solution(s):
    answer = ''
    length = len(s)
    
    if length % 2 == 0 : 
        print("even")
        print(int((length)/2-1),"-",int((length)/2))
        answer = s[int((length)/2-1):int((length)/2+1)]
        
    else :
        print("odd")
        print(int((length-1)/2))
        answer =s[int((length-1)/2)]
    
    return answer
