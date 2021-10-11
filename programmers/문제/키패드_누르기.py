#카카오 인턴십 2020
def solution(numbers, hand):
    answer = ''
    numbers
    hand
    R_hand = [1,4]
    L_hand = [1,4]
    R_count = 0
    L_count = 0
    
    for num in numbers :
        if   num == 0 :
            R_count += abs(R_hand[0] - 2) + abs(R_hand[1] - 4)
            L_count += abs(L_hand[0] - 2) + abs(L_hand[1] - 4)
            
            if   R_count > L_count : 
                answer += "L"
                L_hand[0] = 2
                L_hand[1] = 4
            elif R_count < L_count : 
                answer += "R"
                R_hand[0] = 2
                R_hand[1] = 4
            elif R_count == L_count : 
                if hand =="right" :
                    answer += "R"
                    R_hand[0] = 2
                    R_hand[1] = 4
                else :             
                    answer += "L"
                    L_hand[0] = 2
                    L_hand[1] = 4
            R_count,L_count = 0,0
            
        elif num == 1 : 
            answer += "L"
            L_hand[0] = 1
            L_hand[1] = 1
            
        elif num == 2 :
            R_count += abs(R_hand[0] - 2) + abs(R_hand[1] - 1)
            L_count += abs(L_hand[0] - 2) + abs(L_hand[1] - 1)
            
            if   R_count > L_count : 
                answer += "L"
                L_hand[0] = 2
                L_hand[1] = 1
            elif R_count < L_count : 
                answer += "R"
                R_hand[0] = 2
                R_hand[1] = 1
            elif R_count == L_count : 
                if hand =="right" :
                    answer += "R"
                    R_hand[0] = 2
                    R_hand[1] = 1
                else :             
                    answer += "L"
                    L_hand[0] = 2
                    L_hand[1] = 1
            R_count,L_count = 0,0
            
        elif num == 3 :
            answer += "R"
            R_hand[0] = 1
            R_hand[1] = 1
            
        elif num == 4 :
            answer += "L"
            L_hand[0] = 1
            L_hand[1] = 2
            
        elif num == 5 :
            R_count += abs(R_hand[0] - 2) + abs(R_hand[1] - 2)
            L_count += abs(L_hand[0] - 2) + abs(L_hand[1] - 2)
            
            if   R_count > L_count : 
                answer += "L"
                L_hand[0] = 2
                L_hand[1] = 2
            elif R_count < L_count : 
                answer += "R"
                R_hand[0] = 2
                R_hand[1] = 2
            elif R_count == L_count : 
                if hand =="right" :
                    answer += "R"
                    R_hand[0] = 2
                    R_hand[1] = 2
                else :             
                    answer += "L"
                    L_hand[0] = 2
                    L_hand[1] = 2
            R_count,L_count = 0,0
            
            
        elif num == 6 :
            answer += "R"
            R_hand[0] = 1
            R_hand[1] = 2
            
        elif num == 7 :
            answer += "L"
            L_hand[0] = 1
            L_hand[1] = 3
            
        elif num == 8 :
            R_count += abs(R_hand[0] - 2) + abs(R_hand[1] - 3)
            L_count += abs(L_hand[0] - 2) + abs(L_hand[1] - 3)
            
            if   R_count > L_count : 
                answer += "L"
                L_hand[0] = 2
                L_hand[1] = 3
            elif R_count < L_count : 
                answer += "R"
                R_hand[0] = 2
                R_hand[1] = 3
            elif R_count == L_count : 
                if hand =="right" :
                    answer += "R"
                    R_hand[0] = 2
                    R_hand[1] = 3
                else :             
                    answer += "L"
                    L_hand[0] = 2
                    L_hand[1] = 3
            R_count,L_count = 0,0
            
        elif num == 9 :
            answer += "R"
            R_hand[0] = 1
            R_hand[1] = 3

    return answer
