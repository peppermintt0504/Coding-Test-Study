#비밀 지도

def Bin(arr,n) :
    Bi = []
    for i in range(len(arr)) :
        Bi.append([])
        for num in range(n-1,-1,-1):
            if arr[i] >= pow(2,num) : 
                Bi[i].append("#")
                arr[i] -= pow(2,num)
            else:
                Bi[i].append(" ")
    return Bi

def solution(n, arr1, arr2):
    answer = []
    b_arr1 = Bin(arr1,n)
    b_arr2 = Bin(arr2,n)
    
    for i in range(n) :
        answer.append("")
        for j in range(n):
            if b_arr1[i][j] == '#' or b_arr2[i][j] == '#' :
                answer[i] += "#"
            else : answer[i] += " "
                
    
    return answer
