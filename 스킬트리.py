def solution(skill, skill_trees):
    skill_book=[]
    temp = []
    answer = 0
    
    for s in range(len(skill)) :        #선행 스킬 정리
        skill_book.append(skill[s:s+1])
            
    for st in skill_trees :  #선행 스킬을 스킬 트리에서의 위치 저장
        for i in range(len(skill_book)) :  
            if st.find(skill_book[i]) == -1 : temp.append(27)
            else : temp.append(st.find(skill_book[i]))


        print(temp)
        c = 0
        
        for j in range(len(temp)-1) :                
            if temp[j] > temp[j+1] :
                c = 1
                break                
        print(c)
        if c == 0 :
            answer += 1
        temp.clear()

    return answer
