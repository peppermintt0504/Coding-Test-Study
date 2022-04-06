#예산

def solution(d, budget):
    answer = 0
    summ = 0
    d.sort()
    for i in range(len(d)) :
        summ += d[i] 
        print(summ)
        if summ >  budget :
            answer = i
            break
        if i == len(d) - 1 :
            answer = i + 1
    return answer
