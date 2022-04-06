def solution(s):
    answer = []
    divi = []
    
    for i in range(1, int(len(s) / 2) + 2) :
        for j in range(int(len(s) / i ) + 1) :
            if s[(j * i) : (j * i) + i] == '' : break
            divi.append(s[(j * i) : (j * i) + i])
        
        con = 0
        answer.append(0)
        for d in range(len(divi)) : 
            
            if d == len(divi) - 1 :
                con = 0 
                answer[i-1] += len(divi[d])
                break
            
            if divi[d] == divi[d+1] :
                if con == 0 :
                    con = 1
                    answer[i-1] += 1
                else : 0
            else : 
                con = 0 
                answer[i-1] += len(divi[d])
        divi.clear()    
    return min(answer)
