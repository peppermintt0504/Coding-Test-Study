def solution(a, b):
    answer = ["SUN","MON","TUE","WED","THU","FRI","SAT"]
    month = [0,31,29,31,30,31,30,31,31,30,31,30]
    jan1 = 5
    today = 0
    M_days = 0
    for i in month[:a]: M_days += i
    
    today = (jan1 + M_days + b - 1 ) % 7
    
    print("5 + ",M_days, " + ", b-1,"=")
    print(today)
    
    return answer[today]
